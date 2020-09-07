
public class Suv implements Car {
	
	private String model;
	private int price;
	private int maxSpeed;
	private double fuelConsumption;
	private int mileage;
	private String colour;
	private int power;

	public Suv(String model, int price, int maxSpeed, double fuelConsumption, int mileage, String colour, int power) {
		this.model = model;
		this.price = price;
		this.maxSpeed = maxSpeed;
		this.fuelConsumption = fuelConsumption;
		this.mileage = mileage;
		this.colour = colour;
		this.power = power;
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
	
	public int getPower() {
		return power;
	}

	@Override
	public String toString() {
		return "Suv [model " + getModel() + ", price " + getPrice() + "$, maximum speed " + getMaxSpeed()
				+ " kmh, fuel consumption " + getFuelConsumption() + " l/100 km, mileage " + getMileage()
				+ " km, colour " + getColour() + ", power " + getPower() + " horse]";
	}

}