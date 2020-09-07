package com.hillel.interfaces;

import java.util.ArrayList;
import com.hillel.exception.InvalidSpeedException;

public interface TaxiStation {

	public int calculatePriceCars();

	public Car[] sortCarsFuelConsumption();

	public ArrayList<Car> listCarsWithSpeedBetweenMinMax(int minSpeed, int maxSpeed) throws InvalidSpeedException;
}