package com.hillel.implementation;

import com.hillel.interfaces.Car;

public class Hatchback implements Car {

	private String mark;
	private String model;
	private double fuelConsumption;
	private int maxSpeed;
	private int price;
	private double engineCapacity;

	public Hatchback(String mark, String model, double fuelConsumption, int maxSpeed, int price,
			double engineCapacity) {
		this.mark = mark;
		this.model = model;
		this.fuelConsumption = fuelConsumption;
		this.maxSpeed = maxSpeed;
		this.price = price;
		this.engineCapacity = engineCapacity;
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

	public double getEngineCapacity() {
		return engineCapacity;
	}

	@Override
	public String toString() {
		return "Hatchback: mark " + getMark() + ", model " + getModel() + ", price " + getPrice() + "$, max speed "
				+ getMaxSpeed() + " kmh, fuel consumption " + getFuelConsumption() + " l/100 km, engine capacity "
				+ engineCapacity + " l.";
	}
}