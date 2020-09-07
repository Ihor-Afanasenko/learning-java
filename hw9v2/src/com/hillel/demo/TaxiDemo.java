package com.hillel.demo;

import java.io.IOException;
import com.hillel.data.CarsDataProcessor;
import com.hillel.exception.InvalidSpeedException;
import com.hillel.implementation.Taxi;
import com.hillel.interfaces.Car;

public class TaxiDemo {

	public static void main(String[] args) throws IOException {

		Taxi firstTaxis = new Taxi(CarsDataProcessor.readDataFromFile());

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
			int maxSpeed = 150;

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
		CarsDataProcessor.writeDataFromFile(outputData.toString());
	}
}