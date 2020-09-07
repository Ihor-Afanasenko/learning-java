// 3.  Рекурсивно вычислить сумму цифр числа (делать отдельным классом и в нем метод).

import java.util.Scanner;

public class Task3 {

	public static void main(String[] args) {
		System.out.print("Input number: ");

		Scanner scan = new Scanner(System.in);
		String numberInput = scan.next();
		scan.close();

		int n = Integer.valueOf(numberInput);

		System.out.println("The sum numerals of the entered number " + n + " is " + printSumNumerals(n) + ".");

	}

	static long printSumNumerals(int n) {
		if (n % 10 != 0 || (int) n / 10 != 0) {
			return printSumNumerals(n / 10) + n % 10;
		} else {
			return 0;
		}
	}
}