package algorithms.backtracking;

import java.util.Arrays;

/**
 * Implementation by KD
 * @author KD
 *
 */
public class KnightsTour {

	int[][] chessBoard;
	int[] moves;
	int i;

	public KnightsTour() {
		this.chessBoard = new int[8][8];
		this.moves = new int[8 * 8];
		for (int i = 0; i < 8 * 8; i++)
			this.moves[i] = -1;
		this.i = 0;
		this.chessBoard = initializeToZero(this.chessBoard);
	}

	private int[][] initializeToZero(int[][] chessBoard2) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				this.chessBoard[i][j] = -1;
			}
		}
		return chessBoard;
	}

	public static void main(String[] args) {
		KnightsTour k = new KnightsTour();
		k.chessBoard[0][0] = 0;
		System.out.println(k.knightTour(0, 0));
	}

	public boolean knightTour(int x, int y) {
		if (i == 63)
			return true;
		moves[i] = x * 10 + y;
		this.chessBoard[x][y] = i++;
		System.out.println(Arrays.toString(moves));
		if (move1(x, y) || move2(x, y) || move3(x, y) || move4(x, y) || move5(x, y) || move6(x, y) || move7(x, y)
				|| move8(x, y))
			return true;
		moves[i--] = -1;
		this.chessBoard[x][y] = -1;
		return false;
	}

	public boolean isMovePossible(int x, int y) {
		boolean flag = true;
		if (x < 0 || x >= chessBoard.length || y < 0 || y >= chessBoard.length || this.chessBoard[x][y] != -1)
			return false;
		return flag;
	}

	// x + 2, y + 1
	public boolean move1(int x, int y) {
		boolean flag = false;
		if (isMovePossible(x + 2, y + 1)) {
//			this.chessBoard[x + 2][y + 1] = 1;
			flag = knightTour(x + 2, y + 1);
//			if (!flag)
//				this.chessBoard[x + 2][y + 1] = 0;
		}
		return flag;
	}

	// x + 2, y - 1
	public boolean move2(int x, int y) {
		boolean flag = false;
		if (isMovePossible(x + 2, y - 1)) {
//			this.chessBoard[x + 2][y - 1] = 1;
			flag = knightTour(x + 2, y - 1);
//			if (!flag)
//				this.chessBoard[x + 2][y - 1] = 0;
		}
		return flag;
	}

	// x + 1, y + 2
	public boolean move3(int x, int y) {
		boolean flag = false;
		if (isMovePossible(x + 1, y + 2)) {
//			this.chessBoard[x + 1][y + 2] = 1;
			flag = knightTour(x + 1, y + 2);
//			if (!flag)
//				this.chessBoard[x + 1][y + 2] = 0;
		}
		return flag;
	}

	// x - 1, y + 2
	public boolean move4(int x, int y) {
		boolean flag = false;
		if (isMovePossible(x - 1, y + 2)) {
//			this.chessBoard[x - 1][y + 2] = 1;
			flag = knightTour(x - 1, y + 2);
//			if (!flag)
//				this.chessBoard[x - 1][y + 2] = 0;
		}
		return flag;
	}

	// x - 2, y + 1
	public boolean move5(int x, int y) {
		boolean flag = false;
		if (isMovePossible(x - 2, y + 1)) {
//			this.chessBoard[x - 2][y + 1] = 1;
			flag = knightTour(x - 2, y + 1);
//			if (!flag)
//				this.chessBoard[x - 2][y + 1] = 0;
		}
		return flag;
	}

	// x - 2, y - 1
	public boolean move6(int x, int y) {
		boolean flag = false;
		if (isMovePossible(x - 2, y - 1)) {
//			this.chessBoard[x - 2][y - 1] = 1;
			flag = knightTour(x - 2, y - 1);
//			if (!flag)
//				this.chessBoard[x - 2][y - 1] = 0;
		}
		return flag;
	}

	// x + 1, y - 2
	public boolean move7(int x, int y) {
		boolean flag = false;
		if (isMovePossible(x + 1, y - 2)) {
//			this.chessBoard[x + 1][y - 2] = 1;
			flag = knightTour(x + 1, y - 2);
//			if (!flag)
//				this.chessBoard[x + 1][y - 2] = 0;
		}
		return flag;
	}

	// x - 1, y - 2
	public boolean move8(int x, int y) {
		boolean flag = false;
		if (isMovePossible(x - 1, y - 2)) {
//			this.chessBoard[x - 1][y - 2] = 1;
			flag = knightTour(x - 1, y - 2);
//			if (!flag)
//				this.chessBoard[x - 1][y - 2] = 0;
		}
		return flag;
	}
}
