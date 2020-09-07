
public class Truck extends Car {
	private int numberDoors;

	public Truck(String model, int price, int maxSpeed, double fuelConsumption, int mileage, String colour,
			int numberDoors) {
		super(model, price, maxSpeed, fuelConsumption, mileage, colour);
		this.numberDoors = numberDoors;
	}

	public int getNumberDoors() {
		return numberDoors;
	}

	@Override
	public String toString() {
		return "Truck [model " + getModel() + ", price " + getPrice() + "$, maximum speed " + getMaxSpeed()
				+ " kmh, fuel consumption " + getFuelConsumption() + " l/100 km, mileage " + getMileage()
				+ " km, colour " + getColour() + ", number doors " + numberDoors + "]";
	}
}