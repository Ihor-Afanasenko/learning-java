package com.hillel.implementation;

import com.hillel.interfaces.Car;

public class Suv implements Car {

	private String mark;
	private String model;
	private double fuelConsumption;
	private int maxSpeed;
	private int price;
	private int power;

	public Suv(String mark, String model, double fuelConsumption, int maxSpeed, int price, int power) {
		this.mark = mark;
		this.model = model;
		this.fuelConsumption = fuelConsumption;
		this.maxSpeed = maxSpeed;
		this.price = price;
		this.power = power;
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

	public int getPower() {
		return power;
	}

	@Override
	public String toString() {
		return "Suv: mark " + getMark() + ", model " + getModel() + ", price " + getPrice() + "$, max speed "
				+ +getMaxSpeed() + " kmh" + ", fuel consumption " + getFuelConsumption() + " l/100 km, power "
				+ getPower() + " horse.";
	}
}