//1. ������� ����� �� ������������. ���������� ����������� ��� ���� �����. ������� �������� ����� ���������, �������
//����� ��������� ������������ �������� � ���������� � ��������� ����� ��� ������ ������a. � ������ main ������� ������ �������� � ���������
//����� ��������� ��������� ����������� ��������.
//Car: id, �����, ������, ��� �������, ����, ����, ��������������� �����.
//������� ������ ��������. �������:
//a) ������ ����������� �������� �����;
//b) ������ ����������� �������� ������, ������� ��������������� ������ n ���;
//c) ������ ����������� ��������� ���� �������, ���� ������� ������ ���������.

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
