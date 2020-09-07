package task2v2.com.hillel.demo;

import task2v2.com.hillel.impl.Processor;
import task2v2.com.hillel.data.Data;

public class Demo {

	public static void main(String[] args) {
		Data d = new Data();
		Processor firstProcess = new Processor(d.read());
		d.write(firstProcess.reverseSymbols());
	}
}