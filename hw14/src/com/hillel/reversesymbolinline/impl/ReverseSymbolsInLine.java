package com.hillel.reversesymbolinline.impl;

import java.util.ArrayList;

public class ReverseSymbolsInLine {

	private ArrayList<String> lineList;

	public ReverseSymbolsInLine(ArrayList<String> lineList) {
		this.lineList = lineList;
	}

	public ArrayList<String> reverseSymbolsInList() {
		ArrayList<String> currentList = new ArrayList<>();
		for (String str : getLineList()) {
			currentList.add(reverseSymbolsInOneLine(str));
		}
		return currentList;
	}

	public ArrayList<String> reverseListAndSymbols() {
		ArrayList<String> currentList = new ArrayList<>();

		for (int i = getLineList().size() - 1; i >= 0; i--) {
			currentList.add(reverseSymbolsInOneLine(getLineList().get(i)));
		}
		return currentList;
	}

	public String reverseSymbolsInOneLine(String str) {
		char[] charArray = str.toCharArray();
		int halfLine = (int) Math.floor(charArray.length / 2);
		for (int i = 0; i < halfLine; i++) {
			charArray[i] ^= charArray[charArray.length - i - 1];
			charArray[charArray.length - i - 1] ^= charArray[i];
			charArray[i] ^= charArray[charArray.length - i - 1];
		}
		return String.valueOf(charArray);
	}	

	public ArrayList<String> getLineList() {
		return lineList;
	}

}
