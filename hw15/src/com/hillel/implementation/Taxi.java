package com.hillel.implementation;

import com.hillel.interfaces.Car;
import com.hillel.interfaces.TaxiStation;
import com.hillel.exception.InvalidSpeedException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Taxi implements TaxiStation {

	private ArrayList<Car> cars;

	public Taxi(ArrayList<Car> cars) {
		this.cars = cars;
	}

	public int calculatePriceCars() {

		return cars.stream().map((n) -> n.getPrice())
				.reduce(0, (a, b) -> a + b);
	}

	public List<Car> sortCarsFuelConsumption() {

		return cars.stream().sorted(this::compareDouble)
				.collect(Collectors.toList());
	}

	public List<Car> listCarsWithSpeedBetweenMinMax(int minSpeed, int maxSpeed) throws InvalidSpeedException {

		if (minSpeed < 0 || maxSpeed < 0) {
			throw new InvalidSpeedException();
		}

		return cars.stream()
				.filter(car -> car.getMaxSpeed() > minSpeed && car.getMaxSpeed() < maxSpeed)
				.collect(Collectors.toList());
	}

	private int compareDouble(Car firstCar, Car secondCar) {
		long firstInBits = Double.doubleToLongBits(firstCar.getFuelConsumption());
		long secondInBits = Double.doubleToLongBits(secondCar.getFuelConsumption());
		return (firstInBits == secondInBits ? 0 : (firstInBits < secondInBits ? -1 : 1));
	}
}