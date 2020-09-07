
public class Task6 {

	public static void main(String[] args) {

		int numberElement;
		int counterDefferentNumber;
		int f = 0;

		int[] arraySomeNumber = { 343, 438, 4233, 6342, 6534, 233, 23432, 123, 32424, 1, 1234567890, 0, 34343, 84 };

		int[] indexRezultNumber = new int[arraySomeNumber.length];

		for (int i = 0; i < arraySomeNumber.length; i++) {
			numberElement = 1;

			while ((int) (arraySomeNumber[i] / Math.pow(10, numberElement++)) != 0) {
			}

			int[] arrayNumberDecile = new int[numberElement];

			int j = 0;
			while (j < numberElement) {
				arrayNumberDecile[j] = (int) ((arraySomeNumber[i] % Math.pow(10, j + 1)) / Math.pow(10, j));
				j++;
			}

			counterDefferentNumber = 0;

			for (j = 0; j < numberElement - 1; j++) {
				for (int k = j + 1; k < numberElement; k++) {
					if ((arrayNumberDecile[j] ^ arrayNumberDecile[k]) == 0) {
						counterDefferentNumber++;
					}
				}
			}

			if (counterDefferentNumber == 0) {
				indexRezultNumber[f++] = i;
			}

		}
		if (indexRezultNumber.length == 0) {
			System.out.println("These numbers consist with the same signs.");

		} else {
			System.out.println("These numbers have different element:");
			for (int i = 0; i < f; i++) {
				System.out.println(arraySomeNumber[indexRezultNumber[i]]);
			}
		}
	}

}