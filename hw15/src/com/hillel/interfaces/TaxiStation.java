package com.hillel.interfaces;

import java.util.List;

import com.hillel.exception.InvalidSpeedException;

public interface TaxiStation {

	public int calculatePriceCars();

	public List<Car> sortCarsFuelConsumption();

	public List<Car> listCarsWithSpeedBetweenMinMax(int minSpeed, int maxSpeed) throws InvalidSpeedException;
}