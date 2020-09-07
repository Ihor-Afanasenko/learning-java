package com.hillel.data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;

import com.hillel.implementation.Hatchback;
import com.hillel.implementation.Suv;
import com.hillel.implementation.Truck;
import com.hillel.interfaces.Car;
import com.hillel.utils.ArrayCarsUtils;

public class CarsDataProcessor {

	public static final String INPUT_FILE = "D:\\my_java\\hillel_course\\homework_hillel\\homework9\\src\\com\\hillel\\data\\cars.txt";
	public static final String OUTPUT_FILE = "D:\\my_java\\hillel_course\\homework_hillel\\homework9\\src\\com\\hillel\\data\\result.txt";

	public Car[] readDataFromFile() throws IOException {
		Car[] cars = null;
		int counterCars = 0;

		try (InputStream inputStream = new FileInputStream(INPUT_FILE)) {

			char[] dataChar = new char[inputStream.available()];

			for (int j = 0, i = 0; (i = inputStream.read()) != -1; j++) {
				dataChar[j] = (char) i;
			}

			String dataString = String.valueOf(dataChar);

			cars = new Car[1];

			for (String subString : dataString.split(";")) {
				if (counterCars > 0) {
					cars = ArrayCarsUtils.extendArrayByLength(cars);
				}
				String[] currentArray = new String[7];
				int index = 0;
				for (String subSubString : subString.split(",")) {
					currentArray[index++] = subSubString;
				}
				cars[counterCars++] = createCar(currentArray[0], currentArray[1], currentArray[2], currentArray[3],
						currentArray[4], currentArray[5], currentArray[6]);
			}

		} catch (FileNotFoundException e) {
			System.out.println("File not founded.");
		} catch (IOException e1) {
			System.out.println("An input/output Occurred.");
		}

		return cars;
	}

	public void writeDataFromFile(String outputData) {

		try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(OUTPUT_FILE))) {
			writer.write(outputData);

		} catch (FileNotFoundException e) {
			System.out.println("File not founded.");
		} catch (IOException e1) {
			System.out.println("An input/output Occurred.");
		}

	}

	public Car createCar(String mark, String model, String FuelConsumption, String maxSpeed, String price,
			String specialProperty, String type) {
		Car car = null;

		switch (type) {
		case ("Hatchback"):
			car = new Hatchback(mark, model, Double.parseDouble(FuelConsumption), Integer.parseInt(maxSpeed),
					Integer.parseInt(price), Double.parseDouble(specialProperty));
			break;
		case ("Suv"):
			car = new Suv(mark, model, Double.parseDouble(FuelConsumption), Integer.parseInt(maxSpeed),
					Integer.parseInt(price), Integer.parseInt(specialProperty));
			break;
		case ("Truck"):
			car = new Truck(mark, model, Double.parseDouble(FuelConsumption), Integer.parseInt(maxSpeed),
					Integer.parseInt(price), Integer.parseInt(specialProperty));
		}
		return car;
	}
}