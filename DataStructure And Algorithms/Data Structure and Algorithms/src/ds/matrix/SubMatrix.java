package ds.matrix;

/**
 * Create a sum matrix by taking the min of the element's nearest elements
 * 
 * @author saurabh.kedia
 *
 */
public class SubMatrix {

	public static void main(String[] args) {
		int[][] matrix = { { 0, 1, 1, 0, 1 }, { 1, 1, 0, 1, 0 }, { 0, 1, 1, 1, 0 }, { 1, 1, 1, 1, 0 },
				{ 1, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0 } };
		int m = 6, n = 5;
		int[][] subMatrix = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i != 0 && j != 0 && matrix[i][j] == 1) {
					subMatrix[i][j] = min(subMatrix[i][j - 1], subMatrix[i - 1][j], subMatrix[i - 1][j - 1]) + 1;
				} else {
					subMatrix[i][j] = matrix[i][j];
				}
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(subMatrix[i][j]);
			}
			System.out.println();
		}
	}

	private static int min(int i, int j, int k) {
		int min = (i < j) ? (i < k) ? i : k : (j < k) ? j : k;
		return min;
	}

}
