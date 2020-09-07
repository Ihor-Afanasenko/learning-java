package com.hillel.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CountWords {

	public static final String PATH_TO_FILE = "D:\\my_java\\hillel_course\\homework_hillel\\hw13\\src\\com\\hillel\\data\\text2.txt";

	public String readTextFromFile() {
		String dataString = null;
		try (InputStream inputStream = new FileInputStream(PATH_TO_FILE)) {
			char[] dataChar = new char[inputStream.available()];

			for (int j = 0, i = 0; (i = inputStream.read()) != -1; j++) {
				dataChar[j] = (char) i;
			}

			dataString = String.valueOf(dataChar);

		} catch (FileNotFoundException e) {
			System.out.println("File not founded.");
		} catch (IOException e1) {
			System.out.println("An input/output Occurred.");
		}
		return dataString;
	}

	public String textProcessingDeletePunctuationsSymbols() {
		return readTextFromFile().replaceAll("\\p{Punct}", "");
	}

	public HashMap<String, Integer> createMap() {

		HashMap<String, Integer> hm = new HashMap<>();

		String[] stringArray = textProcessingDeletePunctuationsSymbols().split(" ");

		for (String str : stringArray) {
			Integer frequency = hm.get(str);
			hm.put(str, frequency == null ? 1 : frequency + 1);
		}
		return hm;
	}

	public void printMap() {
		Set<Map.Entry<String, Integer>> set = createMap().entrySet();
		System.out.println("Number of words in the text.");
		for (Map.Entry<String, Integer> me : set) {
			System.out.print(me.getKey() + ": ");
			System.out.println(me.getValue());
		}
	}

}
