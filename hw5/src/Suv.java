
public class Suv extends Car {
	private int power;

	public Suv(String model, int price, int maxSpeed, double fuelConsumption, int mileage, String colour, int power) {
		super(model, price, maxSpeed, fuelConsumption, mileage, colour);
		this.power = power;
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