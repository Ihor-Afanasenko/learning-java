package com.hillel.demo;

import com.hillel.impl.WorkWithText;
import com.hillel.impl.WorkWithTextV2;
import com.hillel.impl.WorkWithTextV3;

public class Demo {

	public static void main(String[] args) {
		String text = "cat, and dog ata dog. first? first? first   - second: last dad!";
		WorkWithText firstText = new WorkWithText(text);
		System.out.println(firstText.countPunctuationSymbols());
		firstText.printWordsWhoHaveEqualFirstAndLastSymbol();
		firstText.replaceKsymbolInWords(5, '0');
		firstText.wordsFrequency();
		System.out.println(firstText.getText());
		
		WorkWithTextV2 first=new WorkWithTextV2(text);
		System.out.println(first.countPunctuationSymbols());
		first.printWordsWhoHaveEqualFirstAndLastSymbol();
		first.replaceKsymbolInWords(5, '0');
		first.wordsFrequency();
		System.out.println(first.getText());
		
		WorkWithTextV3 second=new WorkWithTextV3(text);
		System.out.println(second.countPunctuationSymbols());
		second.printWordsWhoHaveEqualFirstAndLastSymbol();
		second.replaceKsymbolInWords(5, '0');
		second.wordsFrequency();
		System.out.println(second.getText());
		
	}

}