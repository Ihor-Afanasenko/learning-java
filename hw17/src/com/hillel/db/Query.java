package com.hillel.db;

public enum Query {
	FIND_FILM(
			"SELECT film.film_id,film.title, actor.actor_name,director.director_name, film.release_year, film.country\n"
					+ "FROM film,actor,film_actor,film_director,director \n"
					+ "WHERE film.film_id=film_actor.film_id \n" + "AND film_actor.actor_id=actor.actor_id \n"
					+ "AND film.film_id=film_director.film_id\n"
					+ "AND film_director.director_id=director.director_id\n"
					+ "AND release_year>=YEAR(CURDATE())-1"), 
	FIND_ACTOR_FIRST(
							"SELECT actor.actor_name,actor.date_of_birth\n" + "FROM actor,film,film_actor\n"
									+ "WHERE film.film_id=film_actor.film_id AND film_actor.actor_id=actor.actor_id AND\n"
									+ "UPPER(film.title) like ?"), 
	FIND_ACTOR_SECOND("SELECT actor.actor_name,actor.date_of_birth\n" + 
			"FROM film,actor,film_actor\n" + 
			"WHERE film.film_id=film_actor.film_id \n" + 
			"AND film_actor.actor_id=actor.actor_id \n" + 
			"GROUP BY actor_name\n" + 
			"HAVING COUNT(*)>= ?"),
	
	FIND_ACTOR_THIRD("SELECT actor.actor_name,actor.date_of_birth\n" + 
			"FROM actor,film_actor,film,film_director,director\n" + 
			"WHERE actor.actor_id=film_actor.actor_id\n" + 
			"AND film_actor.film_id=film.film_id\n" + 
			"AND film.film_id=film_director.film_id\n" + 
			"AND actor.actor_name=director.director_name"), 
	DELETE_FILM(
																			"DELETE \n" + "FROM film \n"
																					+ "WHERE release_year<=YEAR(CURDATE())-?"), 
	SELECT_ACTOR_NAME_IN_FILM(
																							"SELECT actor.actor_name\n"
																									+ "FROM actor,film,film_actor\n"
																									+ "WHERE film.film_id=film_actor.film_id AND film_actor.actor_id=actor.actor_id AND\n"
																									+ "UPPER(film.title) like ?"), 
	SELECT_DIRECTOR_NAME_IN_FILM(
																											"SELECT director.director_name\n"
																													+ "FROM director,film,film_director\n"
																													+ "WHERE film.film_id=film_director.film_id AND film_director.director_id=director.director_id AND\n"
																													+ "UPPER (film.title) like ?");

	private String sqlQuery;

	Query(String sql) {
		this.sqlQuery = sql;
	}

	public String getSqlQuery() {
		return sqlQuery;
	}
}