
public class CatalogCar {

	public static void main(String[] args) {
		// Subtask first
		String brandFirstSubtask = "Skoda";
		// Subtask second
		String modelSecondSubtask = "Octavia";
		int yearsUsed = 5;
		// Subtask third
		int yearThirdSubtask = 2004;
		int priceDeterminate = 25000;

		Car[] carsArray = new Car[10];

		carsArray[0] = new Car(1, "Renault", "Logan", 1993, "white", 25000, "AX2353BX");
		carsArray[1] = new Car(2, "Skoda", "Octavia", 2005, "black", 35000, "AX2355BX");
		carsArray[2] = new Car(3, "Mitsubishi", "Lancer", 2004, "white", 45000, "AX2555BX");
		carsArray[3] = new Car(4, "Lexus", "RX350", 2000, "black", 65000, "AX2355MX");
		carsArray[4] = new Car(5, "Citroen", "Cactus", 2011, "brown", 50000, "AX2568BX");
		carsArray[5] = new Car(6, "Skoda", "Octavia", 2012, "white", 45000, "AX2355MM");
		carsArray[6] = new Car(7, "Dacia", "Duster", 2012, "green", 15000, "AX1255MM");
		carsArray[7] = new Car(8, "Nissan", "Juke", 2004, "yellow", 33000, "AX1111MM");
		carsArray[8] = new Car(9, "Toyota", "Camry", 2004, "dark green", 25500, "AX2895MM");
		carsArray[9] = new Car(10, "Skoda", "Octavia", 2010, "black", 15000, "AX1125MM");

		Car[] informationCar = new Car[1];

		System.out.println("Cars of brand " + brandFirstSubtask + ":");
		for (int i = 0; i < carsArray.length; i++) {
			if (carsArray[i].brandCar.equals(brandFirstSubtask)) {
				informationCar[0] = carsArray[i];
				printInformationCatalog(informationCar);
			}
		}
		System.out.println();
		System.out.println("Cars model " + modelSecondSubtask + " have run over " + yearsUsed + " years:");
		for (int i = 0; i < carsArray.length; i++) {
			if (carsArray[i].modelCar.equals("Octavia") & (2017 - carsArray[i].yearManufactureCar > yearsUsed)) {
				informationCar[0] = carsArray[i];
				printInformationCatalog(informationCar);
			}
		}

		System.out.println();
		System.out.println(
				yearThirdSubtask + " cars of the year, the price of which is higher " + priceDeterminate + ":");
		for (int i = 0; i < carsArray.length; i++) {
			if (carsArray[i].yearManufactureCar == yearThirdSubtask & (carsArray[i].priceCar > priceDeterminate)) {
				informationCar[0] = carsArray[i];
				printInformationCatalog(informationCar);
			}
		}

	}

	public static void printInformationCatalog(Car[] informationCar) {
		System.out.println("Id car " + informationCar[0].idCar + " brand " + informationCar[0].brandCar + " model "
				+ informationCar[0].modelCar + " year of manufactoring " + informationCar[0].yearManufactureCar
				+ " colour " + informationCar[0].colourCar + " price " + informationCar[0].priceCar
				+ " number regestration " + informationCar[0].numberRegistrationCar);
	}
}
