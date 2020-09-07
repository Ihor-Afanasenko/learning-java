package com.hillel.impl;

import java.sql.SQLException;
import java.util.List;
import com.hillel.db.DBResult;
import com.hillel.db.Query;
import com.hillel.interfaces.Library;

public class VideoLibrary implements Library {

	private DBResult result;

	public VideoLibrary() throws SQLException {
		result = new DBResult();
	}

	@Override
	public List<Film> findFilmThisOrPreviousYear() {

		return result.findFilm(Query.FIND_FILM.getSqlQuery());
	}

	@Override
	public List<Actor> findActorsByFilm(String titleFilm) {

		return result.findActor(Query.FIND_ACTOR_FIRST.getSqlQuery(), titleFilm);

	}

	@Override
	public List<Actor> findActorsByNorMoreFilms(int N) {

		return result.findActor(Query.FIND_ACTOR_SECOND.getSqlQuery(), N);
	}

	@Override
	public List<Actor> findActorsWhoDirectorFilm() {

		return result.findActor(Query.FIND_ACTOR_THIRD.getSqlQuery());
	}

	@Override
	public void deleteFilmThenRelaseYearLessNYears(int year) {

		result.updateDB(Query.DELETE_FILM.getSqlQuery(), year);

	}
}