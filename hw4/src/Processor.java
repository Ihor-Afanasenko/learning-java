
public class Processor {
	Car[] arrayCars;

	Processor(Car carsArray[]) {
		this.arrayCars = carsArray;
	}

	Processor() {
		Car[] arrayEmpty = new Car[10];
		arrayCars = arrayEmpty;
	}

	public void printCar(Car someCar) {
		System.out.println("Id car " + someCar.id + " brand " + someCar.brand + " model " + someCar.model
				+ " year of manufactoring " + someCar.yearManufacture + " colour " + someCar.colour + " price "
				+ someCar.price + " number regestration " + someCar.numberRegistration);
	}

	public void printCarsGivenBrand(String brand, Car arraysCar[]) {
		System.out.println();
		System.out.println("Cars of brand " + brand + ":");
		for (int i = 0; i < arraysCar.length; i++) {
			if (arraysCar[i].brand.equals(brand)) {
				printCar(arraysCar[i]);
			}
		}
	}

	public void printCarsGivenModelAndYear(String model, int yearsUsed, Car arraysCar[]) {
		System.out.println();
		System.out.println("Cars model " + model + " have run over " + yearsUsed + " years:");
		for (int i = 0; i < arraysCar.length; i++) {
			if (arraysCar[i].model.equals(model) && (2017 - arraysCar[i].yearManufacture > yearsUsed)) {
				printCar(arraysCar[i]);
			}
		}
	}

	public void printCarsGivenYearManufactureAndPrice(int yearManufacture, int price, Car arraysCar[]) {
		System.out.println();
		System.out.println(yearManufacture + " cars of the year, the price of which is higher " + price + ":");
		for (int i = 0; i < arraysCar.length; i++) {
			if (arraysCar[i].yearManufacture == yearManufacture && (arraysCar[i].price > price)) {
				printCar(arraysCar[i]);
			}
		}
	}

	public void printCarsGivenBrand(String brand) {
		System.out.println();
		System.out.println("Cars of brand " + brand + ":");
		for (int i = 0; i < arrayCars.length; i++) {
			if (arrayCars[i] != null && arrayCars[i].brand.equals(brand)) {
				printCar(arrayCars[i]);
			} else {
				return;
			}
		}
	}

	public void printCarsGivenModelAndYear(String model, int yearsUsed) {

		System.out.println();
		System.out.println("Cars model " + model + " have run over " + yearsUsed + " years:");
		for (int i = 0; i < arrayCars.length; i++) {
			if (arrayCars[i] != null && arrayCars[i].model.equals(model)
					&& (2017 - arrayCars[i].yearManufacture > yearsUsed)) {
				printCar(arrayCars[i]);

			} else {
				return;
			}
		}
	}

	public void printCarsGivenYearManufactureAndPrice(int yearManufacture, int price) {
		System.out.println();
		System.out.println(yearManufacture + " cars of the year, the price of which is higher " + price + ":");
		for (int i = 0; i < arrayCars.length; i++) {
			if (arrayCars[i] != null && arrayCars[i].yearManufacture == yearManufacture
					&& (arrayCars[i].price > price)) {
				printCar(arrayCars[i]);

			} else {
				return;
			}
		}
	}
}