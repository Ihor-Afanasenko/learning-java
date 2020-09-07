package com.hillel.implementation;

import com.hillel.interfaces.Car;
import com.hillel.interfaces.TaxiStation;

import java.util.Arrays;
import java.util.Comparator;

import com.hillel.exception.InvalidSpeedException;

public class Taxi implements TaxiStation {

	private Car[] cars;

	public Taxi(Car[] cars) {
		this.cars = cars;
	}

	static int compareDouble(Car firstCar, Car secondCar) {
		long firstInBits = Double.doubleToLongBits(firstCar.getFuelConsumption());
		long secondInBits = Double.doubleToLongBits(secondCar.getFuelConsumption());
		return (firstInBits == secondInBits ? 0 : (firstInBits < secondInBits ? -1 : 1));
	}

	public int calculatePriceCars() {
		int sumPrice = 0;
		for (int i = 0; i < cars.length; i++) {
			sumPrice += cars[i].getPrice();
		}
		return sumPrice;
	}

	public Car[] sortCarsFuelConsumption() {

		// Implementation interface Comparator
		Arrays.sort(cars, new Comparator<Car>() {
			@Override
			public int compare(Car firstCar, Car secondCar) {
				long firstInBits = convertDoubleToLong(firstCar.getFuelConsumption());
				long secondInBits = convertDoubleToLong(secondCar.getFuelConsumption());
				return (firstInBits == secondInBits ? 0 : (firstInBits < secondInBits ? -1 : 1));
			}
		});

		// Lambda expression
		Arrays.sort(cars, (firstCar, secondCar) -> {
			long firstInBits = convertDoubleToLong(firstCar.getFuelConsumption());
			long secondInBits = convertDoubleToLong(secondCar.getFuelConsumption());
			return (firstInBits == secondInBits ? 0 : (firstInBits < secondInBits ? -1 : 1));
		});

		// Link to the static method
		Arrays.sort(cars, Taxi::compareDouble);

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
	
	private long convertDoubleToLong(double numberDouble) {
		return Double.doubleToLongBits(numberDouble);
	}
}