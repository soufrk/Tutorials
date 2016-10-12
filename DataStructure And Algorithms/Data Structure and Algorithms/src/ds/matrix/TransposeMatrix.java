package ds.matrix;

public class TransposeMatrix {

	public static void main(String[] args) {
		char[][] matrix = { { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' } };
		int m = 4, n = 3, k = 0;
		Character[][] transposedMatrix = new Character[n][m];
		Character[] oneDArray = new Character[m * n];
		// flatten the data structure from 2D to 1D
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				oneDArray[k++] = matrix[i][j];
			}
		}
		System.out.println("Actual Matrix : ");
		// print actual matrix
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
		k = 0;
		// transpose the matrix
		System.out.println("Transposed Matrix : ");
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				transposedMatrix[j][i] = oneDArray[k++];
			}
		}
		// print transposed matrix
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(transposedMatrix[i][j]);
			}
			System.out.println();
		}
	}

}
