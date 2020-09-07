package com.hillel.exception;

@SuppressWarnings("serial")
public class InvalidSpeedException extends Exception {

	public InvalidSpeedException() {
	}

	public String toString() {
		return "Maximum or minimum speed less then zero.";
	}
}