
public class Task4 {

	public static void main(String[] args) {
		// Matrix size: rowsFirstMatrix, columnsFirstMatrix, rowsSecondMatrix,
		// columnsSecondMatrix

		int rowsFirstMatrix = 4;
		int columnsFirstMatrix = 4;
		int rowsSecondMatrix = 4;
		int columnsSecondMatrix = 4;

		int[][] matrixFirst = { { 1, 2, 3, 4 }, { 4, 5, 6, 7 }, { 7, 8, 9, 10 }, { 10, 11, 12, 13 } };
		int[][] matrixSecond = { { 1, 2, 3, 4 }, { 4, 5, 6, 7 }, { 7, 8, 9, 10 }, { 10, 11, 12, 13 } };

		if (columnsFirstMatrix != rowsSecondMatrix) {
			System.out.println("These matrices can't be multiplied.");
		} else {

			int[][] rezultMatrix = new int[columnsSecondMatrix][rowsFirstMatrix];

			for (int i = 0; i < columnsFirstMatrix; i++) {
				for (int j = 0; j < rowsFirstMatrix; j++) {
					for (int k = 0; k < rowsSecondMatrix; k++) {
						rezultMatrix[i][j] += matrixFirst[i][k] * matrixSecond[k][j];
					}
				}
			}

			System.out.println("The result is the multiplication of the first matrix by the second:");
			for (int i = 0; i < columnsFirstMatrix; i++) {
				for (int j = 0; j < rowsSecondMatrix; j++) {
					System.out.print(rezultMatrix[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
