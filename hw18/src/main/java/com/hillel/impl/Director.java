package com.hillel.impl;

import java.util.Date;

public class Director extends People {

	public Director(String name, Date dateOfBirth) {
		super(name, dateOfBirth);
	}

	@Override
	public String toString() {
		return "Director [full name " + getName() + " date of birth  " + getDateOfBirth() + "]";
	}

}