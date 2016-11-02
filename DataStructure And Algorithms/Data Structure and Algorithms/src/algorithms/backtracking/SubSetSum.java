package algorithms.backtracking;

import sort.algorithms.QuickSort;

public class SubSetSum {

	public static void main(String[] args) {
		int[] noArray = { 10, 7, 5, 18, 12, 20, 15 };
		noArray = QuickSort.qSort(noArray, 0, noArray.length - 1);
		int target = 53;
		findSubSet(noArray, target, noArray.length);
	}

	private static void findSubSet(int[] noArray, int target, int n) {
		if ()
			return;
		int currentSum = 0;
		for (int j = i; j < noArray.length; j++) {
			int no = noArray[i++];
			findSubSet(noArray, target, i);
			currentSum += no;
			System.out.println(currentSum);
		}
		return;
	}

}
