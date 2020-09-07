package com.hillel.path;

public enum Path {
	Input_file("D:\\my_java\\hillel_course\\hw9v2\\src\\com\\hillel\\data\\cars.txt"), Output_file(
			"D:\\my_java\\hillel_course\\hw9v2\\src\\com\\hillel\\data\\result.txt");

	private String adress;

	Path(String adress) {
		this.adress = adress;
	}

	public String getAdress() {
		return adress;
	}
}