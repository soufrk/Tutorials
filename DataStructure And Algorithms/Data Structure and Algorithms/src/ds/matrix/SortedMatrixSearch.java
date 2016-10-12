package ds.matrix;

public class SortedMatrixSearch {

	public static void main(String[] args) {
		int[][] matrix = { { 0, 1, 2, 3, 4 }, { 10, 11, 12, 13, 14 }, { 20, 21, 22, 23, 24 }, { 30, 31, 32, 33, 34 },
				{ 40, 41, 42, 43, 44 } };
		int noToSearch = 50;
		int[] coordinates = searchMatrix(matrix, matrix[0].length, noToSearch);
		if (coordinates[0] == -1) {
			System.out.println("Number doesn't exist in matrix");
		} else {
			System.out.printf("Number exists at coordinate : %d, %d", coordinates[0], coordinates[1]);
		}
	}

	private static int[] searchMatrix(int[][] matrix, int n, int noToSearch) {
		int[] resultCoordinates = { -1, -1 };
		int i = 0, j = n - 1;
		while (j >= 0 && i <= n - 1) {
			if (noToSearch == matrix[i][j]) {
				resultCoordinates[0] = i;
				resultCoordinates[1] = j;
				break;
			} else if (noToSearch > matrix[i][j])
				i++;
			else
				j--;
		}
		return resultCoordinates;
	}

}
