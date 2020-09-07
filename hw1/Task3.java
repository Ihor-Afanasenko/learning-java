public class Task3 {
	public static void main(String[] args) {

		// Create random amount of element
		int amountElement = (int) (100 * Math.random());

		double array[] = new double[amountElement];

		// Filling an array with random numbers
		for (int i = 0; i < array.length; i++) {
			array[i] = Math.random();
		}
		
		// Print an array arguments
		System.out.println("Array arguments in a column");

		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}

		System.out.println("Array arguments in a string");

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" " );
		}
	}

}
