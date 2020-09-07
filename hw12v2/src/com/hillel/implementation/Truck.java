package com.hillel.implementation;

import com.hillel.interfaces.Car;

public class Truck implements Car {

	private String mark;
	private String model;
	private double fuelConsumption;
	private int maxSpeed;
	private int price;
	private int doorNumber;

	public Truck(String mark, String model, double fuelConsumption, int maxSpeed, int price, int doorNumber) {
		this.mark = mark;
		this.model = model;
		this.fuelConsumption = fuelConsumption;
		this.maxSpeed = maxSpeed;
		this.price = price;
		this.doorNumber = doorNumber;
	}

	public String getMark() {
		return mark;
	}

	public String getModel() {
		return model;
	}

	public int getPrice() {
		return price;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public double getFuelConsumption() {
		return fuelConsumption;
	}

	public int getNumberDoors() {
		return doorNumber;
	}

	@Override
	public String toString() {
		return "Truck: mark " + getMark() + ", model " + getModel() + ", price " + getPrice() + "$, max speed "
				+ getMaxSpeed() + " kmh, fuel consumption " + getFuelConsumption() + " l/100 km, door number "
				+ doorNumber + ".";
	}
}