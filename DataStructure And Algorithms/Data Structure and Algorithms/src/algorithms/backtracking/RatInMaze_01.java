package algorithms.backtracking;

public class RatInMaze_01 {

	public static void main(String[] args) {
		int[][] maze = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0, 1, 0, 0 }, { 1, 1, 1, 1 } };
		int[][] path = new int[maze.length][maze[0].length];
		path[0][0] = 1;
		System.out.println(ratRun(maze, path, 0, 0));
		printPath(path);
	}

	private static void printPath(int[][] path) {
		for(int i = 0; i < path.length; i++){
			for(int j = 0; j < path[0].length; j++){
				System.out.print(path[i][j]);
			}
			System.out.println();
		}
	}

	private static boolean ratRun(int[][] maze, int[][] path, int x, int y) {
		if (x == maze.length - 1 && y == maze[0].length - 1)
			return true;
		// forward move
		if (isMovePossible(maze, x + 1, y))
			x += 1;
		// downward move
		else if (isMovePossible(maze, x, y + 1))
			y += 1;

		boolean flag = false;
		path[x][y] = 1;
		flag = ratRun(maze, path, x, y);
		
		// backtrack
		if (!flag)
			path[x][y] = 0;
		return flag;
	}

	private static boolean isMovePossible(int[][] maze, int x, int y) {
		if (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] != 0)
			return true;
		return false;
	}

}
