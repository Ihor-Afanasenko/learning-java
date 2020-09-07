
public class Task5 {

	public static void main(String[] args) {

		int counter;
		int shortNumber;
		int longNumber;
		int indexShortNumber = 0;
		int indexLongNumber = 0;

		int[] arrayNumber = { 1203535, 234, 34434, 68, 1_234_536_456, 878443, 234645, 2342536, 134, 5366 };

		int[] lengthNumber = new int[arrayNumber.length];

		// Counting the number of characters in a number

		for (int i = 0; i < arrayNumber.length; i++) {
			counter = 0;

			while ((int) (arrayNumber[i] / Math.pow(10, counter++)) != 0) {
			}

			lengthNumber[i] = counter;
		}
		shortNumber = lengthNumber[0];
		longNumber = lengthNumber[0];

		for (int i = 0; i < arrayNumber.length; i++) {

			if (shortNumber > lengthNumber[i]) {
				shortNumber = lengthNumber[i];
				indexShortNumber = i;
			}
			if (longNumber < lengthNumber[i]) {
				longNumber = lengthNumber[i];
				indexLongNumber = i;
			}
		}
		System.out.println(arrayNumber[indexLongNumber] + " - long number in the array has lenght " + longNumber + ".");
		System.out.println(
				arrayNumber[indexShortNumber] + " - short number in the array has length " + shortNumber + ".");
	}

}
