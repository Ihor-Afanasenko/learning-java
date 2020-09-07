
public class Car {
	private String model;
	private int price;
	private int maxSpeed;
	private double fuelConsumption;
	private int mileage;
	private String colour;

	public Car(String model, int price, int maxSpeed, double fuelConsumption, int mileage, String colour) {
		this.model = model;
		this.price = price;
		this.maxSpeed = maxSpeed;
		this.fuelConsumption = fuelConsumption;
		this.mileage = mileage;
		this.colour = colour;
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

	public int getMileage() {
		return mileage;
	}

	public String getColour() {
		return colour;
	}
}
