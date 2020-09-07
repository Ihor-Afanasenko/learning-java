package com.hillel.implementation;

import com.hillel.interfaces.Car;
import com.hillel.interfaces.TaxiStation;
import com.hillel.exception.InvalidSpeedException;
import java.util.ArrayList;
import java.util.Arrays;

public class Taxi implements TaxiStation {

	private ArrayList<Car> cars;

	public Taxi(ArrayList<Car> cars) {
		this.cars = cars;
	}

	public int calculatePriceCars() {
		int sumPrice = 0;
		for (int i = 0; i < cars.size(); i++) {
			sumPrice += (cars.get(i)).getPrice();
		}
		return sumPrice;
	}

	public Car[] sortCarsFuelConsumption() {

		// Link to the method
		Car[] carsArray = new Car[cars.size()];
		cars.toArray(carsArray);
		Arrays.sort(carsArray, this::compareDouble);
		return carsArray;
	}

	public ArrayList<Car> listCarsWithSpeedBetweenMinMax(int minSpeed, int maxSpeed) throws InvalidSpeedException {

		if (minSpeed < 0 || maxSpeed < 0) {
			throw new InvalidSpeedException();
		}
		ArrayList<Car> carsForSpeed = new ArrayList<>();

		for (int i = 0; i < cars.size(); i++) {
			if ((cars.get(i)).getMaxSpeed() > minSpeed & (cars.get(i)).getMaxSpeed() < maxSpeed) {
				carsForSpeed.add(cars.get(i));
			}
		}
		return carsForSpeed;
	}

	private int compareDouble(Car firstCar, Car secondCar) {
		long firstInBits = Double.doubleToLongBits(firstCar.getFuelConsumption());
		long secondInBits = Double.doubleToLongBits(secondCar.getFuelConsumption());
		return (firstInBits == secondInBits ? 0 : (firstInBits < secondInBits ? -1 : 1));
	}
}