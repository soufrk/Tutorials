package practice.technique.dynamic.programming;


// passed { 0, 2, 0 }, { 0, 0, 1 }, { 1, 1, 1 } 
// passed { 0, 1, 0 }, { 1, 0, 1 }, { 0, 2, 2 } 
// passed { 0, 1, 0 }, { 1, 0, 1 }, { 0, 2, 2 }
public class TomNJerry {
	public static void main(String[] args) {
		int[][] maze = new int[][] { { 0, 0, 2 }, { 0, 0, 0 }, { 2, 1, 2 } };
		int x = 1, y = 1;
		int minMoves = minMoves(maze, x, y);
		System.out.println(minMoves);
	}

	public static int minMoves(int[][] maze, int x, int y) {
		int n = 0, result = 0;
		// maze is null or path is blocked
		if (maze == null || (maze[0].length != 1 && maze[0][1] == 1 && maze[1][0] == 1)) {
			return -1;
			// n is 1
		} else if (maze[0].length == 1) {
			return 1;
			// n >= 2
		} else {
			n = maze[0].length;
			int nC = 0, nB = 0;
			int[][] cC = null;
			int[][] cB = null;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					nC += (maze[i][j] == 2) ? 1 : 0;
					nB += (maze[i][j] == 1) ? 1 : 0;
				}
			}
			int a = 0, b = 0, c = 0, d = 0;
			cC = new int[nC][2];
			cB = new int[nB][2];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (maze[i][j] == 2) {
						cC[a][b++] = i;
						cC[a++][b] = j;
						b = 0;
					}
					if (maze[i][j] == 1) {
						cB[c][d++] = i;
						cB[c++][d] = j;
						d = 0;
					}
				}
			}
			result = totalDistance(cC, cB, nC, nB, x, y, n);
		}
		return result;
	}

	private static int totalDistance(int[][] cC, int[][] cB, int nC, int nB, int jx, int jy, int n) {
		int count = 0;
		int tx = 0, ty = 0;
		for (int[] i : cC) {
			count = goToNextCoordinate(i[0], i[1], tx, ty, cB, count, n);
			System.out.println("Count after chesse at cx " + i[0] + " cy " + i[1] + " : " + count);
			tx = i[0];
			ty = i[1];
			if(count == -1)
				return count;
		}
		count = goToNextCoordinate(jx, jy, tx, ty, cB, count, n);
		return count;
	}

	private static int goToNextCoordinate(int cx, int cy, int tx, int ty, int[][] cB, int count, int n) {
		System.out.println("tx " + tx + " ty " + ty + " cx " + cx + " cy " + cy);
		System.out.println("Count " + count);
		if (cx == tx && cy == ty)
			return count;
		else if (cx - tx > 0 && !isBlocked(tx + 1, ty, cB) && tx < n) {
			count = goToNextCoordinate(cx, cy, tx + 1, ty, cB, count + 1, n);
		} else if (cy - ty > 0 && !isBlocked(tx, ty + 1, cB) && ty < n) {
			count = goToNextCoordinate(cx, cy, tx, ty + 1, cB, count + 1, n);
		} else if (cx - tx < 0 && !isBlocked(tx + 1, ty, cB) && tx >= 0) {
			count = goToNextCoordinate(cx, cy, tx - 1, ty, cB, count + 1, n);
		} else if (cy - ty < 0 && !isBlocked(tx, ty - 1, cB) && ty >= 0) {
			count = goToNextCoordinate(cx, cy, tx, ty - 1, cB, count + 1, n);
		} else {
			count = -1;
		}
		return count;
	}

	private static boolean isBlocked(int cx, int cy, int[][] cB) {
		boolean result = false;
		for (int[] i : cB) {
			if (i[0] == cx && i[1] == cy) {
				result = true;
				break;
			}
		}
		return result;
	}
}
