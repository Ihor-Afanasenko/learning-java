
public class Hatchback extends Car {
	private double engineCapacity;

	public Hatchback(String model, int price, int maxSpeed, double fuelConsumption, int mileage, String colour,
			double engineCapacity) {
		super(model, price, maxSpeed, fuelConsumption, mileage, colour);
		this.engineCapacity = engineCapacity;
	}

	public double getEngineCapacity() {
		return engineCapacity;
	}

	@Override
	public String toString() {
		return "Hatchback [model "+ getModel()+  ", price " + getPrice() + "$, maximum speed " + getMaxSpeed()+" kmh"
				+ ", fuel consumption " + getFuelConsumption() + " l/100 km, mileage " + getMileage() + " km, colour "
				+ getColour() + ", engine capacity " + engineCapacity +" l]";
	}
}