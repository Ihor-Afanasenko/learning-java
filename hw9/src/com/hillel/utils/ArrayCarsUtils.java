package com.hillel.utils;

import com.hillel.interfaces.Car;

public class ArrayCarsUtils {

	public static Car[] extendArrayByLength(Car[] cars) {
		Car temp[] = new Car[cars.length + 1];
		for (int i = 0; i < cars.length; i++) {
			temp[i] = cars[i];
		}
		return temp;
	}
}