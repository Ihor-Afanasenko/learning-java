package com.hillel.impl;

import java.util.Date;

public class Actor extends People {

	public Actor(String name, Date dateOfBirth) {
		super(name, dateOfBirth);
	}

	@Override
	public String toString() {
		return "Actor [full name " + getName() + ", date of birth " + getDateOfBirth() + "]";
	}
}