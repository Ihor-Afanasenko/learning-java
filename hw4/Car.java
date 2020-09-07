//1. Создать в классе процессора из предыдущего задания поле для хранения массива объектов. 
//Сделать два перегруженных конструктора - один принимает массив объектов и устанавливает 
//его в поле, второй - не принимает параметров но создает пустой массив 
//объектов и устанавливает его в поле. Перегрузить все три метода, чтобы в одном случае 
//они принимали массив и параметры для поиска и работали с этим массивом,
//а в другом случае принимали только параметры для поиска и работали с внутренним массивом в случае если он не пустой. 

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
