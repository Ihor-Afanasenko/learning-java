
public class Truck implements Car {
	
	private String model;
	private int price;
	private int maxSpeed;
	private double fuelConsumption;
	private int mileage;
	private String colour;
	private int doorNumber;

	public Truck(String model, int price, int maxSpeed, double fuelConsumption, int mileage, String colour,
			int doorNumber) {
		this.model = model;
		this.price = price;
		this.maxSpeed = maxSpeed;
		this.fuelConsumption = fuelConsumption;
		this.mileage = mileage;
		this.colour = colour;
		this.doorNumber = doorNumber;
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

	public int getNumberDoors() {
		return doorNumber;
	}

	@Override
	public String toString() {
		return "Truck [model " + getModel() + ", price " + getPrice() + "$, maximum speed " + getMaxSpeed()
				+ " kmh, fuel consumption " + getFuelConsumption() + " l/100 km, mileage " + getMileage()
				+ " km, colour " + getColour() + ", door number " + doorNumber + "]";
	}
}