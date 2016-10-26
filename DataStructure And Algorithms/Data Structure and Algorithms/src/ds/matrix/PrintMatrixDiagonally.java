package ds.matrix;

public class PrintMatrixDiagonally {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 }, { 17, 18, 19, 20 } };
		int m = 5, n = 4, k = 0;
		int[] oneDArray = new int[m * n];
		// matrix to an array
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				oneDArray[k++] = matrix[i][j];
			}
		}
		// print diagonally
		for (int i = 0; i < m * n; i++) {
			for (int j = 0; j < i/2 + 1; j++) {
				System.out.printf("%4d", oneDArray[i]);
			}
//			for (int j = 0; j < i/2 + 1; j++) {
//				System.out.printf("%4d", oneDArray[i]);
//			}
			System.out.println();
		}
	}

}
