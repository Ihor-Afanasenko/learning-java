// 2. Дано натуральное число n (обычная переменная int). Рекурсивно вывести все числа от 1 до n. (Ввод 5 -> вывод 1 2 3 4 5, делать отдельным классом и в нем метод)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task2 {

	public static void main(String[] args) throws IOException {

		System.out.print("Enter natural number n: ");

		String consoleArgument = new BufferedReader(new InputStreamReader(System.in)).readLine();

		int n = Integer.parseInt(consoleArgument);

		System.out.println("All numbers from one to " + n + ": " + printNumberN(n) + ".");
	}

	static String printNumberN(int n) {
		if (n == 1) {
			return "1";
		} else {
			return printNumberN(n - 1) + " " + n;
		}
	}
}