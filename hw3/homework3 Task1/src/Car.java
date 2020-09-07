//Создать класс по спецификации. Определить конструктор для всех полей. Создать отдельно класс процессор, который
// будет выполнять определенные действия с объектамии и содержать метод для печати объектов. В методе main создать массив объектов и используя
// класс процессор выполнить необходимые операции.
// Car: id, Марка, Модель, Год выпуска, Цвет, Цена, Регистрационный номер.
// Создать массив объектов. Вывести:
// a) список автомобилей заданной марки;
// b) список автомобилей заданной модели, которые эксплуатируются больше n лет;
// c) список автомобилей заданного года выпуска, цена которых больше указанной.

public class Car {
	int idCar;
	String brandCar;
	String modelCar;
	int yearManufactureCar;
	String colourCar;
	int priceCar;
	String numberRegistrationCar;

	Car(int idCar, String brandCar, String modelCar, int yearManufactureCar, String colourCar, int priceCar,
			String numberRegistrationCar) {
		this.idCar = idCar;
		this.brandCar = brandCar;
		this.modelCar = modelCar;
		this.yearManufactureCar = yearManufactureCar;
		this.colourCar = colourCar;
		this.priceCar = priceCar;
		this.numberRegistrationCar = numberRegistrationCar;
	}

}
