package com.hillel.implementation;

import com.hillel.interfaces.Car;
import com.hillel.interfaces.TaxiStation;
import com.hillel.exception.InvalidSpeedException;
import java.util.ArrayList;
import java.util.Collections;

public class Taxi implements TaxiStation {

	private ArrayList<Car> cars;

	public Taxi(ArrayList<Car> cars) {
		this.cars = cars;
	}

	public int calculatePriceCars() {

		int sumPrice = 0;
		for (Car car : cars) {
			sumPrice += car.getPrice();
		}
		return sumPrice;
	}

	public ArrayList<Car> sortCarsFuelConsumption() {

		Collections.sort(cars, this::compareDouble);
		return cars;
	}

	public ArrayList<Car> listCarsWithSpeedBetweenMinMax(int minSpeed, int maxSpeed) throws InvalidSpeedException {

		if (minSpeed < 0 || maxSpeed < 0) {
			throw new InvalidSpeedException();
		}
		ArrayList<Car> carsForSpeed = new ArrayList<>(cars);
		carsForSpeed.removeIf((Car car) -> (car.getMaxSpeed() > minSpeed) && (car.getMaxSpeed() > maxSpeed));
		return carsForSpeed;
	}

	private int compareDouble(Car firstCar, Car secondCar) {
		long firstInBits = Double.doubleToLongBits(firstCar.getFuelConsumption());
		long secondInBits = Double.doubleToLongBits(secondCar.getFuelConsumption());
		return (firstInBits == secondInBits ? 0 : (firstInBits < secondInBits ? -1 : 1));
	}
}