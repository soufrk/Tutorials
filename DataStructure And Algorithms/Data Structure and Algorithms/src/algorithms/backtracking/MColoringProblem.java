package algorithms.backtracking;

public class MColoringProblem {

	public static void main(String[] args) {
		int[][] graph = { { 0, 1, 1, 1 }, { 1, 0, 1, 0 }, { 1, 1, 0, 1 }, { 1, 0, 1, 0 }, };
		int m = 3; // Number of colors
		// Initialize all color values as 0. This
		// initialization is needed for correct functioning
		// of isSafe()
		int[] colors = new int[graph.length];
		for (int i = 0; i < graph.length; i++) {
			colors[i] = 0;
		}
		if (!colorGraph(graph, colors, 0, m))
			System.out.println(false);
		else
			print(colors);

	}

	private static boolean colorGraph(int[][] graph, int[] colors, int vertex, int m) {
		if (vertex == graph.length) {
			return true;
		}
		for (int i = 1; i <= m; i++) {
			if (isSafe(colors, vertex, i, graph)) {
				colors[vertex] = i;
				if (colorGraph(graph, colors, vertex + 1, m))
					return true;

			}
			colors[vertex] = 0;
		}
		return false;
	}

	private static boolean isSafe(int[] colors, int vertex, int j, int[][] graph) {
		for (int i = 0; i < colors.length; i++)
			if (graph[vertex][i] == 1 && j == colors[i])
				return false;
		return true;
	}

	private static void print(int[] coloredGraph) {
		for (int j = 0; j < coloredGraph.length; j++) {
			System.out.print(coloredGraph[j] + "\t");
		}
		System.out.println();
	}

}
