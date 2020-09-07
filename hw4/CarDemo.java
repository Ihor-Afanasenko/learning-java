
public class CarDemo {

	public static void main(String[] args) {

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

		Processor first = new Processor(carsArray);

		first.printCarsGivenBrand("Skoda", carsArray);
		first.printCarsGivenModelAndYear("Octavia", 10, carsArray);
		first.printCarsGivenYearManufactureAndPrice(2004, 25000, carsArray);

		Processor second = new Processor();
		second.printCarsGivenBrand("Dacia");
		second.printCarsGivenModelAndYear("Juke", 5);
		second.printCarsGivenYearManufactureAndPrice(2014, 26000);
	}
}