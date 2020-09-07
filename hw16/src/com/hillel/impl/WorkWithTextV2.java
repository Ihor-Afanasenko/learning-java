package com.hillel.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class WorkWithTextV2 {
	private String text;
	private ArrayList<String> words;

	public WorkWithTextV2(String text) {
		this.text = text;
		words = new ArrayList<>(Arrays.asList(text.split("[\\P{L}]+")));
	}

	public void wordsFrequency() {
		words.parallelStream().distinct()
				.forEach(w -> System.out.println(w + " frequency: " + Collections.frequency(words, w)));
	}

	public void replaceKsymbolInWords(int k, char symbol) {
		words.stream().map(w -> {
			if (w.length() >= k) {
				char[] currentArray = w.toCharArray();
				currentArray[k - 1] = symbol;
				w = new String(currentArray);
			}
			return w;
		}).forEach(System.out::println);
	}

	public void printWordsWhoHaveEqualFirstAndLastSymbol() {
		words.stream().distinct().filter(w -> w.charAt(0) == w.charAt(w.length() - 1)).forEach(System.out::println);
	}

	public int countPunctuationSymbols() {
		return text.replaceAll("[^\\p{Punct}]", "").length();
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
