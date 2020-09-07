package com.hillel.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.stream.Collectors;

public class WorkWithText {

	private String text;
	private ArrayList<String> words;

	public WorkWithText(String text) {
		this.text = text;
		words = new ArrayList<>(Arrays.asList(text.replaceAll("\\p{Punct}|\\p{Blank}{2,}", "").split("\\p{Space}")));
	}

	public void wordsFrequency() {
		for (String w : this.notSameWords()) {
			System.out.println(w + " frequency: " + Collections.frequency(words, w));
		}
	}

	public void replaceKsymbolInWords(int k, char symbol) {
		String result = words.stream().map(w -> {
			if (w.length() >= k) {
				char[] curArray = w.toCharArray();
				curArray[k - 1] = symbol;
				w = new String(curArray);
			}
			return w;
		}).collect(Collectors.joining(" "));
		System.out.println(result);
	}

	public void printWordsWhoHaveEqualFirstAndLastSymbol() {
		this.notSameWords().stream().filter(w -> w.charAt(0) == w.charAt(w.length() - 1)).forEach(System.out::println);
	}

	public int countPunctuationSymbols() {
		return text.replaceAll("[^\\p{Punct}]", "").length();
	}

	private HashSet<String> notSameWords() {
		return new HashSet<>(words);
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}