package com.hillel.implementation;

import com.hillel.interfaces.Car;
import com.hillel.interfaces.TaxiStation;
import com.hillel.exception.InvalidSpeedException;

public class Taxi implements TaxiStation {

	private Car[] cars;

	public Taxi(Car[] cars) {
		this.cars = cars;
	}

	public int calculatePriceCars() {
		int sumPrice = 0;
		for (int i = 0; i < cars.length; i++) {
			sumPrice += cars[i].getPrice();
		}
		return sumPrice;
	}

	public Car[] sortCarsFuelConsumption() {
		// SelectionSort
		for (int i = 0; i < cars.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < cars.length; j++) {
				if (cars[j].getFuelConsumption() < cars[min].getFuelConsumption()) {
					min = j;
				}
			}
			Car current = cars[i];
			cars[i] = cars[min];
			cars[min] = current;
		}
		return cars;
	}

	public Car[] listCarsWithSpeedBetweenMinMax(int minSpeed, int maxSpeed) throws InvalidSpeedException {

		if (minSpeed < 0 || maxSpeed < 0) {
			throw new InvalidSpeedException();
		}

		int firstLengthArray = 0;
		Car[] result = new Car[firstLengthArray];
		for (int i = 0; i < cars.length; i++) {
			if (cars[i].getMaxSpeed() > minSpeed & cars[i].getMaxSpeed() < maxSpeed) {
				Car[] currentCar = new Car[++firstLengthArray];
				for (int j = 0; j < result.length; j++) {
					currentCar[j] = result[j];
				}
				currentCar[currentCar.length - 1] = cars[i];
				result = currentCar;
			}
		}
		return result;
	}
}