
public class Task1 {

	public static void main(String[] args) {

		int[] array = { 234, 3423, 34563, 53432, 3432, 3874, 487843, 837490234, 483413421 };

		for (int i = 0; i < array.length; i++) {

			if ((array[i] & 1) == 0) {
				System.out.println(array[i] + " even number.");
			} else {
				System.out.println(array[i] + " odd number.");
			}
		}
	}
}