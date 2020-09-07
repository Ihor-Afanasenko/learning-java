package task2v2.com.hillel.impl;

import java.util.ArrayList;
import java.util.Spliterator;

public class Processor {
	private ArrayList<String> list;

	public Processor(ArrayList<String> list) {
		this.list = list;
	}

	public ArrayList<String> reverseSymbols() {
		ArrayList<String> result = new ArrayList<>();
		Spliterator<String> spliterator = getList().spliterator();
		while (spliterator.tryAdvance((n) -> result.add(((new StringBuilder(n)).reverse()).toString())))
			;
		return result;
	}

	public ArrayList<String> getList() {
		return list;
	}
}