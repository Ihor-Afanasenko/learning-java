package com.hillel.interfaces;

import java.util.List;

import com.hillel.impl.Actor;
import com.hillel.impl.Film;

public interface Library {

	public List<Film> findFilmThisOrPreviousYear();

	public List<Actor> findActorsByFilm(String title);

	public List<Actor> findActorsByNorMoreFilms(int N);

	public List<Actor> findActorsWhoDirectorFilm();

	public void deleteFilmThenRelaseYearLessNYears(int year);
}
