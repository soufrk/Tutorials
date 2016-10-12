package ds.matrix;

public class BooleanMatrix {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 0, 0, 1 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 } };
		int m = 3, n = 4;
		int[][] result = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 1) {
					result = rowColModification(i, j, result, m, n);
				}
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(result[i][j]);
			}
			System.out.println();
		}
	}

	private static int[][] rowColModification(int i, int j, int[][] result, int m, int n) {
		for (int a = 0; a < n; a++) {
			result[i][a] = 1;
		}
		for (int b = 0; b < m; b++) {
			result[b][j] = 1;
		}
		return result;
	}

}
