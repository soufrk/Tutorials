package algorithms.backtracking;

public class HamiltonianCycle {

	public static void main(String[] args) {
		int[][] adjacencyGraph = { { 0, 1, 0, 1, 0 }, { 1, 0, 1, 1, 1 }, { 0, 1, 0, 0, 1 }, { 1, 1, 0, 0, 1 },
				{ 0, 1, 1, 1, 0 }, };
		int[] nodesVisited = new int[adjacencyGraph.length];
		for (int i = 0; i < nodesVisited.length; i++) {
			nodesVisited[i] = -1;
		}
		nodesVisited[0] = 0;
		int vertex = 1;
		System.out.println("Is Hamiltonian Cycle: " + isHamiltonianCycle(adjacencyGraph, nodesVisited, vertex));
		print(nodesVisited);

	}

	private static boolean isHamiltonianCycle(int[][] adjacencyGraph, int[] nodesVisited, int vertex) {
		// when all the nodes have been traversed
		if (vertex == adjacencyGraph.length) {
			if (adjacencyGraph[nodesVisited[vertex - 1]][nodesVisited[0]] == 1)
				return true;
			return false;
		}

		// from each node take all available paths one by one and check if
		// solution can be reached
		for (int i = 1; i < adjacencyGraph.length; i++) {
			if (isSafe(adjacencyGraph, nodesVisited, vertex, i)) {
				nodesVisited[vertex] = i;
				if (isHamiltonianCycle(adjacencyGraph, nodesVisited, vertex + 1))
					return true;
				nodesVisited[vertex] = -1;
			}
		}
		return false;
	}

	private static boolean isSafe(int[][] adjacencyGraph, int[] nodesVisited, int currentNode, int i) {
		// check if a path exists from last visited node to this node
		if (adjacencyGraph[nodesVisited[currentNode - 1]][i] == 0)
			return false;

		/*
		 * Check if the vertex has already been included. This step can be
		 * optimized by creating an array of size V
		 */
		for (int j = 0; j < currentNode; j++)
			if (nodesVisited[j] == i)
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
