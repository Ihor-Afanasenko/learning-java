
public class Taxi implements TaxiStation {

	private Car[] cars;

	public Taxi(Car[] cars) {
		this.cars = cars;
	}

	public int calculatePriceCars() {
		int sumPrice = 0;
		for (int i = 0; i < cars.length; i++) {
			sumPrice += cars[i].getPrice();
		}
		return sumPrice;
	}

	public Car[] sortCarsFuelConsumption() {

		// Bubble-Sort
		// for (int i = cars.length - 1; i > 0; i--) {
		// for (int j = 0; j < i; j++) {
		// if (cars[j].getFuelConsumption() > cars[j + 1].getFuelConsumption()) {
		// Car current = cars[j];
		// cars[j] = cars[j + 1];
		// cars[j + 1] = current;
		// }
		// }
		// }

		// Modified Bubble-Sort
		// int swapped = 1;
		// for (int i = 0; i < (cars.length - 1) && swapped == 1; i++) {
		// swapped = 0;
		// for (int j = 0; j < cars.length - i - 1; j++) {
		// if (cars[j].getFuelConsumption() > cars[j + 1].getFuelConsumption()) {
		// Car current = cars[j];
		// cars[j] = cars[j + 1];
		// cars[j + 1] = current;
		// swapped = 1;
		// }
		// }
		// }

		// SelectionSort
		for (int i = 0; i < cars.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < cars.length; j++) {
				if (cars[j].getFuelConsumption() < cars[min].getFuelConsumption()) {
					min = j;
				}
			}
			Car current = cars[i];
			cars[i] = cars[min];
			cars[min] = current;
		}
		return cars;
	}

	public Car[] listCarsWithSpeedBetweenMinMax(int minSpeed, int maxSpeed) {

		// int index = 0;
		// Car[] currentCar = new Car[cars.length];
		//
		// for (int i = 0; i < cars.length; i++) {
		// if (cars[i].getMaxSpeed() > minSpeed & cars[i].getMaxSpeed() < maxSpeed) {
		// currentCar[index] = cars[i];
		// index++;
		// }
		// }
		// Car[] result = new Car[index];
		// for (int i = 0; i < index; i++) {
		// result[i] = currentCar[i];
		// }

		int firstLengthArray = 0;
		Car[] result = new Car[firstLengthArray];
		for (int i = 0; i < cars.length; i++) {
			if (cars[i].getMaxSpeed() > minSpeed & cars[i].getMaxSpeed() < maxSpeed) {
				Car[] currentCar = new Car[++firstLengthArray];
				for (int j = 0; j < result.length; j++) {
					currentCar[j] = result[j];
				}
				currentCar[currentCar.length - 1] = cars[i];
				result = currentCar;
			}
		}
		return result;
	}
}