package com.hillel.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WorkWithTextV3 {
	private String text;
	private ArrayList<String> words;

	public WorkWithTextV3(String text) {
		this.text = text;
		words = new ArrayList<String>(Pattern.compile("[\\P{L}]+").splitAsStream(text).collect(Collectors.toList()));
	}

	public void wordsFrequency() {
		words.stream().distinct()
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
		}).forEach(w -> System.out.print(w + ' '));
		System.out.println();
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