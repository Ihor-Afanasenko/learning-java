
public class Task3 {

	public static void main(String[] args) {

		int[] numberFibonacci = new int[20];

		numberFibonacci[0] = numberFibonacci[1] = 1;

		System.out.println("Fibonacci numbers up to twenty:");

		for (int i = 0; i < numberFibonacci.length; i++) {

			if (i > 1) {
				numberFibonacci[i] = numberFibonacci[i - 2] + numberFibonacci[i - 1];
			}

			System.out.print(numberFibonacci[i] + " ");
		}
	}
}