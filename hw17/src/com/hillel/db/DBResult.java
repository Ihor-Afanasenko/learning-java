package com.hillel.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.hillel.impl.*;
import com.hillel.db.DBHelper;

public class DBResult {
	
	private DBHelper helper;
	
	public DBResult() throws SQLException {
		helper=new DBHelper();
	}

	public List<Film> findFilm(String query) {

		List<Film> films = new ArrayList<>();
		Statement st = null;
		try {
			helper = new DBHelper();
			st = helper.getStatement();
			ResultSet rs = st.executeQuery(query);

			int curId = 0;

			while (rs.next()) {
				if (rs.getInt(1) != curId) {
					films.add(new Film(rs.getInt(1), rs.getString(2),
							findNamePeople(Query.SELECT_ACTOR_NAME_IN_FILM.getSqlQuery(), rs.getString(2)),
							findNamePeople(Query.SELECT_DIRECTOR_NAME_IN_FILM.getSqlQuery(), rs.getString(2)),
							rs.getDate(5), rs.getString(6)));
					curId++;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			helper.closeStatement(st);
			helper.closeConnection();
		}

		return films;
	}

	public List<Actor> findActor(String query) {

		List<Actor> actors = new ArrayList<>();
		Statement st = null;
		try {
			helper = new DBHelper();
			st = helper.getStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				actors.add(new Actor(rs.getString(1), rs.getDate(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			helper.closeStatement(st);
			helper.closeConnection();
		}
		return actors;
	}

	public List<Actor> findActor(String query, String title) {

		List<Actor> actors = new ArrayList<>();
		PreparedStatement ps = null;
		try {
			helper = new DBHelper();
			ps = helper.insertValuesString(helper.getPreparedStatement(query), title);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				actors.add(new Actor(rs.getString(1), rs.getDate(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			helper.closePreparedStatement(ps);
			helper.closeConnection();
		}

		return actors;
	}

	public List<Actor> findActor(String query, int number) {

		List<Actor> actors = new ArrayList<>();
		PreparedStatement ps = null;
		try {
			helper = new DBHelper();
			ps = helper.insertValuesInt(helper.getPreparedStatement(query), number);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				actors.add(new Actor(rs.getString(1), rs.getDate(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			helper.closePreparedStatement(ps);
			helper.closeConnection();
		}

		return actors;
	}

	public void updateDB(String query, int year) {
		PreparedStatement ps = null;
		try {
			helper = new DBHelper();
			ps = helper.insertValuesInt(helper.getPreparedStatement(query), year);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			helper.closePreparedStatement(ps);
			helper.closeConnection();
		}

	}

	private List<String> findNamePeople(String query, String titleFilm) {

		List<String> names = new ArrayList<>();
		PreparedStatement ps = null;
		try {
			helper = new DBHelper();
			ps = helper.insertValuesString(helper.getPreparedStatement(query), titleFilm);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				names.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			helper.closePreparedStatement(ps);
			helper.closeConnection();
		}

		return names;
	}
}