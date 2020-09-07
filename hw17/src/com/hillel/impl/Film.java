package com.hillel.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Film extends Entity {
	private String title;
	private List<String> list;
	private List<String> director;
	private Date releaseYear;
	private String country;

	public Film(int id, String title, List<String> list, List<String> director, Date releaseYear, String country) {
		super(id);
		this.title = title;
		this.list = list;
		this.director = director;
		this.releaseYear = releaseYear;
		this.country = country;

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public List<String> getDirector() {
		return director;
	}

	public void setDirector(List<String> director) {
		this.director = director;
	}

	public Date getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Date releaseYear) {
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
		DateFormat df = new SimpleDateFormat("yyyy");
		return "Film [id " + getId() + " title " + title + ", names actors " + list + ", names directors " + director
				+ ", release year " + df.format(releaseYear) + ", country " + country + "]";
	}
}
