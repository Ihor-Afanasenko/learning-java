package com.hillel.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hillel.impl.Actor;
import com.hillel.impl.Film;

public class DBHelper {

	private final static String SELECT_FILMS_THIS_OR_PREVIOUS_YEAR = "SELECT * FROM film WHERE release_year>=YEAR(CURDATE())-1";

	private final static String SELECT_ACTORS_BY_FILM = "SELECT actor.actor_name,actor.date_of_birth FROM actor,film,film_actor WHERE film.film_id=film_actor.film_id AND film_actor.actor_id=actor.actor_id AND UPPER(film.title) like ?";

	private final static String SELECT_ACTORS_BY_N_FILM = "SELECT actor.actor_name,actor.date_of_birth FROM film,actor,film_actor WHERE film.film_id=film_actor.film_id AND film_actor.actor_id=actor.actor_id GROUP BY actor_name HAVING COUNT(*)>= ?";

	private final static String SELECT_ACTORS_WHO_DIRECTORS_FILM = "SELECT actor.actor_name,actor.date_of_birth FROM actor,film_actor,film,film_director,director WHERE actor.actor_id=film_actor.actor_id AND film_actor.film_id=film.film_id AND film.film_id=film_director.film_id AND actor.actor_name=director.director_name";

	private final static String DELETE_FILMS_THAT_HAVE_RELEASE_YEAR_MORE_N = "DELETE film.*,film_actor.*,film_director.* FROM film,film_actor,film_director WHERE film.film_id=film_actor.film_id AND film.film_id=film_director.film_id AND release_year<=YEAR(CURDATE())-?";

	private final static String SELECT_ACTORS_NAMES_BY_FILM = "SELECT actor.actor_name FROM actor,film,film_actor WHERE film.film_id=film_actor.film_id AND film_actor.actor_id=actor.actor_id AND UPPER(film.title) like ?";

	private final static String SELECT_DIRECTORS_NAMES_BY_FILM = "SELECT director.director_name FROM director,film,film_director WHERE film.film_id=film_director.film_id AND film_director.director_id=director.director_id AND UPPER (film.title) like ?";

	private Connection cn;

	public DBHelper() throws SQLException {
		cn = ConnectorDB.getConnection();
	}

	public List<Film> findFilmsByYear() {

		List<Film> films = new ArrayList<>();
		Statement st = null;

		try {
			st = getStatement();
			ResultSet rs = st.executeQuery(SELECT_FILMS_THIS_OR_PREVIOUS_YEAR);
			while (rs.next()) {
				films.add(new Film(rs.getInt(1), 
						rs.getString(2),
						findNamePeople(SELECT_ACTORS_NAMES_BY_FILM, rs.getString(2)),
						findNamePeople(SELECT_DIRECTORS_NAMES_BY_FILM, rs.getString(2)), 
						rs.getDate(3),
						rs.getString(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeStatement(st);
			closeConnection();
		}

		return films;
	}

	public List<Actor> findActorsWhoDirectors() {

		List<Actor> actors = new ArrayList<>();
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

	public List<Actor> findActorsByFilm(String title) {

		List<Actor> actors = new ArrayList<>();
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

	public List<Actor> findActorsNfilms(int number) {

		List<Actor> actors = new ArrayList<>();
		PreparedStatement ps = null;
		try {
			ps = insertValuesInt(this.getPreparedStatement(SELECT_ACTORS_BY_N_FILM), number);
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

	public boolean deleteFilmsByYears(int year) {
		PreparedStatement ps = null;
		boolean flag=false;
		try {
			ps = insertValuesInt(getPreparedStatement(DELETE_FILMS_THAT_HAVE_RELEASE_YEAR_MORE_N), year);
			ps.executeUpdate();
			flag=true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeStatement(ps);
			closeConnection();
		}
		return flag;

	}

	private List<String> findNamePeople(String query, String titleFilm) {

		List<String> names = new ArrayList<>();
		PreparedStatement ps = null;
		try {
			ps = insertValuesString(getPreparedStatement(query), titleFilm);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				names.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return names;
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