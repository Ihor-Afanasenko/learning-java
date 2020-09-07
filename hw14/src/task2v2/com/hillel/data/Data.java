package task2v2.com.hillel.data;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Data {
	public static final String INPUT_FILE = "D:\\my_java\\my_improv\\hw14\\src\\task2v2\\com\\hillel\\data\\input.txt";
	public static final String OUTPUT_FILE = "D:\\my_java\\my_improv\\hw14\\src\\task2v2\\\\com\\hillel\\data\\result.txt";

	public ArrayList<String> read() {
		ArrayList<String> result = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(INPUT_FILE)))) {
			String strLine;
			while ((strLine = br.readLine()) != null) {
				result.add(strLine);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		} catch (IOException e) {
			System.out.println("An input error occured.");
		}
		return result;
	}

	public void write(ArrayList<String> list) {
		try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(OUTPUT_FILE))) {
			StringBuilder outputData = new StringBuilder();
			int count = 0;
			for (String str : list) {
				outputData.append(str);
				count++;
				if (count < list.size())
					outputData.append('\n');
			}
			writer.write(outputData.toString());

		} catch (FileNotFoundException e) {
			System.out.println("File not founded.");
		} catch (IOException e1) {
			System.out.println("An input/output Occurred.");
		}
	}
}
