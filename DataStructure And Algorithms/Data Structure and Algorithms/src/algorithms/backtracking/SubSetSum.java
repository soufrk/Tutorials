package algorithms.backtracking;

import algorithms.sort.QuickSort;

public class SubSetSum {

	public static void main(String[] args) {
		int[] noArray = { 10, 7, 5, 18, 12, 20, 15 };
		noArray = QuickSort.qSort(noArray, 0, noArray.length - 1);
		int target = 53;
		findSubSet(noArray, target, 0, 0);
	}

	private static boolean findSubSet(int[] noArray, int target, int sum, int i) {
		if (sum == target)
			return true;
		if (i >= noArray.length && sum != target)
			return false;
		if (sum > target)
			return false;

		// with the number
		int current = noArray[i];
		if (findSubSet(noArray, target, sum + current, ++i)) {
			System.out.print(current + "\t");
			return true;
			// without the number
		} else if (findSubSet(noArray, target, sum, i)) {
			return true;
		}
		return false;
	}

}
