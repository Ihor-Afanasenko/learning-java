package com.hillel.TaxiStation.Interface;

import com.hillel.TaxiStation.Implementation.InvalidSpeedException;

public interface TaxiStation {

	public int calculatePriceCars();

	public Car[] sortCarsFuelConsumption();

	public Car[] listCarsWithSpeedBetweenMinMax(int minSpeed, int maxSpeed) throws InvalidSpeedException;
}