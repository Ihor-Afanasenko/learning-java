package com.hillel.impl;

import java.sql.SQLException;
import java.util.List;
import com.hillel.db.DBHelper;
import com.hillel.interfaces.Library;

public class VideoLibrary implements Library {

	@Override
	public List<Film> findFilmThisOrPreviousYear() throws SQLException  {

		return (new DBHelper()).findFilmsByYear();
	}

	@Override
	public List<Actor> findActorsByFilm(String titleFilm) throws SQLException {

		return (new DBHelper()).findActorsByFilm(titleFilm);
	}

	@Override
	public List<Actor> findActorsByNorMoreFilms(int n) throws SQLException {

		return (new DBHelper()).findActorsNfilms(n);
	}

	@Override
	public List<Actor> findActorsWhoDirectorFilm() throws SQLException {

		return (new DBHelper()).findActorsWhoDirectors();
	}

	@Override
	public boolean deleteFilmThenRelaseYearLessNYears(int year) throws SQLException {

	return	(new DBHelper()).deleteFilmsByYears(year);

	}
}