package algorithms.backtracking;

/**
 * Place N-Queens on a chess board of size NxN where no two queens come in the
 * way of other.
 * 
 * @author KD
 *
 */
public class NQueens_01 {

	int[][] chessBoard;

	public NQueens_01(int n) {
		// initialise the chessboard of NxN dimension with 0
		this.chessBoard = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				this.chessBoard[i][j] = 0;
			}
		}
	}

	public static void main(String[] args) {
		int n = 8;
		NQueens_01 q = new NQueens_01(n);
		boolean isPossible = q.placeQueens(0, n);
		if (isPossible)
			q.printChessBoard();
		else
			System.out.println("No Solution is Possible");
	}

	private void printChessBoard() {
		int n = this.chessBoard.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(this.chessBoard[i][j] + " ");
			}
			System.out.println();
		}
	}

	private boolean placeQueens(int queen, int n) {
		if (queen == n)
			return true;
		for (int row = 0; row < n; row++) {
			// if a queen can be placed at the given position place it there
			if (canPlace(chessBoard, row, queen)) {
				chessBoard[row][queen] = 1;
				// if a solution can be reached from there return true else
				// remove the queen from there and go to next iteration.
				if (placeQueens(queen + 1, n))
					return true;
				// if we are here that means we need to backtrack
				chessBoard[row][queen] = 0;
			}
		}
		return false;
	}

	private boolean canPlace(int[][] chessBoard, int row, int column) {
		// check horizontally for any other queen present
		for (int i = 0; i < column; i++) {
			if (chessBoard[row][i] == 1)
				return false;
		}

		// check upper end diagonal for any queen present
		for (int i = row, j = column; i >= 0 && j >= 0; i--, j--) {
			if (chessBoard[i][j] == 1)
				return false;
		}

		// check lower end diagonal for any queen present
		for (int i = row, j = column; i < chessBoard.length && j >= 0; i++, j--) {
			if (chessBoard[i][j] == 1)
				return false;
		}

		return true;
	}
}
