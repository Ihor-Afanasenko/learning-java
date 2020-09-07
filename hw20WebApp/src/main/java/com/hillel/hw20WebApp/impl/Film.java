package com.hillel.hw20WebApp.impl;

public class Film extends Entity {
	private String title;
	private String releaseYear;
	private String country;

	public Film(int id, String title, String releaseYear, String country) {
		super(id);
		this.title = title;
		this.releaseYear = releaseYear;
		this.country = country;

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Film [id " + getId() + " title " + title + ", release year " + releaseYear + ", country " + country
				+ "]";
	}
}
