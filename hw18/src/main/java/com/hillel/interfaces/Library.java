package com.hillel.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.hillel.impl.Actor;
import com.hillel.impl.Film;

public interface Library {

	public List<Film> findFilmThisOrPreviousYear() throws SQLException;

	public List<Actor> findActorsByFilm(String title) throws SQLException;

	public List<Actor> findActorsByNorMoreFilms(int n) throws SQLException;

	public List<Actor> findActorsWhoDirectorFilm() throws SQLException;

	public boolean deleteFilmThenRelaseYearLessNYears(int year) throws SQLException;
}
