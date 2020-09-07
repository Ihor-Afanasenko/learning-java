
public class Taxis {

	private Car[] cars;

	public Taxis(Car[] cars) {
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
		for (int i = cars.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (cars[j].getFuelConsumption() > cars[j + 1].getFuelConsumption()) {
					Car current = cars[j];
					cars[j] = cars[j + 1];
					cars[j + 1] = current;
				}
			}
		}

		return cars;
	}

	public Car[] listCarsWithSpeedBetweenMinMax(int minSpeed, int maxSpeed) {

		int index = 0;

		Car[] currentCar = new Car[cars.length];

		for (int i = 0; i < cars.length; i++) {

			if (cars[i].getMaxSpeed() > minSpeed & cars[i].getMaxSpeed() < maxSpeed) {

				currentCar[index] = cars[i];

				index++;

			}
		}

		Car[] rezult = new Car[index];

		for (int i = 0; i < index; i++) {

			rezult[i] = currentCar[i];

		}
		return rezult;
	}

}