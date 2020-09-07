package task2v3.com.hillel.impl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Processor {
	private static final String INPUT_FILE = "D:\\my_java\\my_improv\\hw14\\src\\task2v3\\com\\hillel\\impl\\input.txt";
	private static final String OUTPUT_FILE = "D:\\my_java\\my_improv\\hw14\\src\\task2v3\\\\com\\hillel\\impl\\result.txt";

	public void reverseLineInText() {
		Deque<String> text = new ArrayDeque<>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(INPUT_FILE)))) {
			String strLine;
			while ((strLine = br.readLine()) != null) {
				text.push(strLine);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		} catch (IOException e) {
			System.out.println("An input error occured.");
		}

		try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(OUTPUT_FILE))) {
			StringBuilder outputData = new StringBuilder();
			int count = 0;
			for (String str : text) {
				outputData.append(str);
				count++;
				if (count < text.size())
					outputData.append('\n');
			}
			writer.write(outputData.toString());

		} catch (FileNotFoundException e) {
			System.out.println("File not founded.");
		} catch (IOException e1) {
			System.out.println("An input/output Occurred.");
		}
	}

	public static void main(String[] args) {
		Processor first = new Processor();
		first.reverseLineInText();
	}
}