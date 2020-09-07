package com.hillel.demo;

import java.io.IOException;
import java.util.ArrayList;

import com.hillel.data.CarsDataProcessor;
import com.hillel.exception.InvalidSpeedException;
import com.hillel.implementation.Taxi;
import com.hillel.interfaces.Car;

public class TaxiDemo {

	public static void main(String[] args) throws IOException {

		CarsDataProcessor data = new CarsDataProcessor();

		ArrayList<Car> cars = data.readDataFromFile();

		Taxi firstTaxis = new Taxi(cars);

		StringBuilder outputData = new StringBuilder();

		System.out.println("Total price taxi station: " + firstTaxis.calculatePriceCars() + "$.");
		outputData.append("Total price taxi station: " + firstTaxis.calculatePriceCars() + "$. \r\n");

		System.out.println();
		System.out.println("List cars sorted by fuel consumption: ");
		outputData.append("\r\n").append("List cars sorted by fuel consumption: ");

		for (Car car : firstTaxis.sortCarsFuelConsumption()) {
			System.out.println(car);
			outputData.append("\r\n").append(car);
		}
		try {

			int minSpeed = 100;
			int maxSpeed = 130;

			System.out.println();
			System.out.println("List cars which maximum speed between " + minSpeed + " and " + maxSpeed + " kmh:");
			outputData.append("\r\n").append("\r\n")
					.append("List cars which maximum speed between " + minSpeed + " and " + maxSpeed + " kmh:");
			for (Car car : firstTaxis.listCarsWithSpeedBetweenMinMax(minSpeed, maxSpeed)) {
				System.out.println(car);
				outputData.append("\r\n").append(car);
			}
		} catch (InvalidSpeedException e) {
			System.out.println(e);
		}
		data.writeDataFromFile(outputData.toString());
	}
}