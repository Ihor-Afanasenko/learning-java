
public class TaxiDemo {

	public static void main(String[] args) {

		Car[] cars = { new Hatchback("Skoda Octavia", 20_000, 120, 5.1, 100_000, "white", 1.9),
				new Hatchback("Audi A5 Sportback", 33_575, 129, 5.0, 50_000, "dack blue", 2.0),
				new Suv("Mitsubishi Outlander", 36_990, 160, 7.2, 60_000, "black", 227),
				new Suv("Kia Sportage", 23_067, 182, 6.6, 50_000, "white", 135),
				new Truck("Chevrolet Silverado", 35_000, 149, 6.2, 56_000, "red", 4),
				new Truck("Tayota Tacoma", 30_000, 160, 11.2, 50_000, "silver", 2),
				new Hatchback("Lexus CT 200h", 23_759, 149, 6.4, 17_000, "red", 2.1) };

		Taxi firstTaxis = new Taxi(cars);

		System.out.println("Total price taxi station: " + firstTaxis.calculatePriceCars() + "$.");

		System.out.println();
		System.out.println("List cars sorted by fuel consumption: ");
		for (Car car : firstTaxis.sortCarsFuelConsumption()) {
			System.out.println(car);
		}

		int minSpeed = 100;
		int maxSpeed = 150;

		System.out.println();
		System.out.println("List cars which maximum speed between " + minSpeed + " and " + maxSpeed + " kmh:");
		for (Car car : firstTaxis.listCarsWithSpeedBetweenMinMax(minSpeed, maxSpeed)) {
			System.out.println(car);
		}
	}
}
