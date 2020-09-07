//1. Создать класс по спецификации. Определить конструктор для всех полей. Создать отдельно класс процессор, который
//будет выполнять определенные действия с объектамии и содержать метод для печати объектa. В методе main создать массив объектов и используя
//класс процессор выполнить необходимые операции.
//Car: id, Марка, Модель, Год выпуска, Цвет, Цена, Регистрационный номер.
//Создать массив объектов. Вывести:
//a) список автомобилей заданной марки;
//b) список автомобилей заданной модели, которые эксплуатируются больше n лет;
//c) список автомобилей заданного года выпуска, цена которых больше указанной.

public class Car {
	int id;
	String brand;
	String model;
	int yearManufacture;
	String colour;
	int price;
	String numberRegistration;

	Car(int id, String brand, String model, int yearManufacture, String colour, int price,
			String numberRegistration) {
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.yearManufacture = yearManufacture;
		this.colour = colour;
		this.price = price;
		this.numberRegistration = numberRegistration;
	}
}
