
public class Task2 {

	public static void main(String[] args) {

		int n;

		int[] array = { 234, 342, 3, 5365, 68893, 35345, 2, 1, 17, 387834, 7853875, 199 };

		for (int i = 0; i < array.length; i++) {

			n = 0;

			for (int j = 2; ((array[i] >= j * j) & (n != 1)); j++) {
				if (array[i] % j == 0) {
					n = 1;
				}
			}
			if ((n != 1) & (array[i] > 1)) {
				System.out.println(array[i] + " -  prime number.");
			}
		}
	}
}