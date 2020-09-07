package com.hillel.hw19WebApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RequestProcessor {

	public List<Integer> processingNumbers(String numbers) {
		List<Integer> intNumber = splitStringToList(numbers).stream().map(Integer::valueOf).sorted()
				.collect(Collectors.toList());
		return intNumber;
	}

	public int findFrequencyWordInText(String word) throws IOException {
		String text = null;
		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("/file.txt")))) {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				line = br.readLine();
			}
			text = sb.toString();
		}
		return Collections.frequency(splitStringToList(text), word);
	}

	private List<String> splitStringToList(String st) {
		List<String> list = new ArrayList<>(
				Arrays.asList(st.replaceAll("\\p{Punct}|\\p{Blank}{2,}", "").split("\\p{Space}")));
		return list;
	}
}
