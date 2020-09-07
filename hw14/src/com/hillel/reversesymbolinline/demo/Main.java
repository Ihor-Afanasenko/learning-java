package com.hillel.reversesymbolinline.demo;

import com.hillel.reversesymbolinline.data.Data;
import com.hillel.reversesymbolinline.impl.ReverseSymbolsInLine;

public class Main {

	public static void main(String[] args) {

		Data data = new Data();
		ReverseSymbolsInLine first = new ReverseSymbolsInLine(data.readByLine());
		data.writeData(first.reverseSymbolsInList());
		// data.writeData(first.reverseListAndSymbols());
	}
}
