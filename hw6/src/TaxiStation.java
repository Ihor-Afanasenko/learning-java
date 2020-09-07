
public interface TaxiStation {
	
	public int calculatePriceCars();
	
	public Car[] sortCarsFuelConsumption();
	
	public Car[] listCarsWithSpeedBetweenMinMax(int minSpeed, int maxSpeed);
}
