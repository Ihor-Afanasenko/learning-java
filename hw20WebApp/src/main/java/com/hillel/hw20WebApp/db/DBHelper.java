package com.hillel.hw20WebApp.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.hillel.hw20WebApp.impl.Actor;
import com.hillel.hw20WebApp.impl.Film;

public class DBHelper {

	private final static String SELECT_FILMS_THIS_OR_PREVIOUS_YEAR = "SELECT * FROM film WHERE release_year>=YEAR(CURDATE())-1";

	private final static String SELECT_FILMS_OLDER_THEN_YEAR = "SELECT * FROM film WHERE release_year<=YEAR(CURDATE())-?";

	private final static String SELECT_ACTORS_BY_FILM = "SELECT actor.actor_name,actor.date_of_birth FROM actor,film,film_actor WHERE film.film_id=film_actor.film_id AND film_actor.actor_id=actor.actor_id AND UPPER(film.title) like ?";

	private final static String SELECT_ACTORS_BY_N_FILM = "SELECT actor.actor_name,actor.date_of_birth FROM film,actor,film_actor WHERE film.film_id=film_actor.film_id AND film_actor.actor_id=actor.actor_id GROUP BY actor_name HAVING COUNT(*)>= ?";

	private final static String SELECT_ACTORS_WHO_DIRECTORS_FILM = "SELECT actor.actor_name,actor.date_of_birth FROM actor,film_actor,film,film_director,director WHERE actor.actor_id=film_actor.actor_id AND film_actor.film_id=film.film_id AND film.film_id=film_director.film_id AND actor.actor_name=director.director_name";

	private final static String DELETE_FILMS_THAT_HAVE_RELEASE_YEAR_MORE_N = "DELETE film.*,film_actor.*,film_director.* FROM film,film_actor,film_director WHERE film.film_id=film_actor.film_id AND film.film_id=film_director.film_id AND release_year<=YEAR(CURDATE())-?";

	private Connection cn;

	public DBHelper() {
		try {
			Context envCtx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) envCtx.lookup("jdbc/video_library");
			cn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Film> findFilmsByYear() {

		List<Film> films = new ArrayList<Film>();
		Statement st = null;

		try {
			st = getStatement();
			ResultSet rs = st.executeQuery(SELECT_FILMS_THIS_OR_PREVIOUS_YEAR);
			DateFormat df = new SimpleDateFormat("yyyy");
			while (rs.next()) {
				films.add(new Film(rs.getInt(1), rs.getString(2), df.format(rs.getDate(3)), rs.getString(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeStatement(st);
			closeConnection();
		}

		return films;
	}

	public List<Actor> findActorsByFilm(String title) {

		List<Actor> actors = new ArrayList<Actor>();
		PreparedStatement ps = null;
		try {
			ps = insertValuesString(getPreparedStatement(SELECT_ACTORS_BY_FILM), title);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				actors.add(new Actor(rs.getString(1), rs.getDate(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeStatement(ps);
			closeConnection();
		}

		return actors;
	}

	public List<Actor> findActorsWhoDirectors() {

		List<Actor> actors = new ArrayList<Actor>();
		Statement st = null;
		try {
			st = getStatement();
			ResultSet rs = st.executeQuery(SELECT_ACTORS_WHO_DIRECTORS_FILM);
			while (rs.next()) {
				actors.add(new Actor(rs.getString(1), rs.getDate(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeStatement(st);
			closeConnection();
		}
		return actors;
	}

	public List<Actor> findActorsNfilms(int number) {

		List<Actor> actors = new ArrayList<Actor>();
		PreparedStatement ps = null;
		try {
			ps = insertValuesInt(getPreparedStatement(SELECT_ACTORS_BY_N_FILM), number);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				actors.add(new Actor(rs.getString(1), rs.getDate(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeStatement(ps);
			closeConnection();
		}

		return actors;
	}

	public List<Film> findFilmsOlderThenGivenYear(int year) {

		List<Film> films = new ArrayList<Film>();
		PreparedStatement ps = null;

		try {
			ps = insertValuesInt(getPreparedStatement(SELECT_FILMS_OLDER_THEN_YEAR), year);
			ResultSet rs = ps.executeQuery();
			DateFormat df = new SimpleDateFormat("yyyy");
			while (rs.next()) {
				films.add(new Film(rs.getInt(1), rs.getString(2), df.format(rs.getDate(3)), rs.getString(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeStatement(ps);
		}

		return films;
	}

	public void deleteFilmsByYears(int year) {
		PreparedStatement ps = null;
		try {
			ps = insertValuesInt(getPreparedStatement(DELETE_FILMS_THAT_HAVE_RELEASE_YEAR_MORE_N), year);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeStatement(ps);
			closeConnection();
		}
	}

	public Statement getStatement() {
		Statement st = null;
		try {
			st = cn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return st;
	}

	public PreparedStatement getPreparedStatement(String sql) {
		PreparedStatement ps = null;
		try {
			ps = cn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ps;
	}

	public PreparedStatement insertValuesString(PreparedStatement ps, String value) {
		try {
			value = value.toUpperCase();
			ps.setString(1, "%" + value + "%");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ps;
	}

	public PreparedStatement insertValuesInt(PreparedStatement ps, int value) {
		try {
			ps.setInt(1, value);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ps;
	}

	public void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void closeConnection() {
		if (cn != null) {
			try {
				cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
