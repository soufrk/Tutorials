package algorithms.sort;

import java.util.Arrays;

/**
 * <ul>
 * <li>The shell sort, sometimes called the “diminishing increment sort,”
 * improves on the insertion sort by breaking the original list into a number of
 * smaller sublists, each of which is sorted using an insertion sort. The unique
 * way that these sublists are chosen is the key to the shell sort. Instead of
 * breaking the list into sublists of contiguous items, the shell sort uses an
 * increment i, sometimes called the gap, to create a sublist by choosing all
 * items that are i items apart.</li>
 * <li>Complexity : O(n)</li>
 * </ul>
 * 
 * @author KD
 *
 */
public class ShellSort {

	public static void main(String[] args) {
		// unsorted integer array
		int[] integerArray = new int[] { 4, 3, 5, 9, 0, 11, 44, 33, 99, 52, 56, 93 };
		System.out.println("Unsorted array : " + Arrays.toString(integerArray));

		// shell sort
		integerArray = shellSortImpl(integerArray);

		// Sorted Array
		System.out.println("Sorted array : " + Arrays.toString(integerArray));
	}

	private static int[] shellSortImpl(int[] integerArray) {
		// Calculating h based on Knuth's formula; h = h * 3 + 1
		int interval = 1;
		while (interval < integerArray.length / 3)
			interval = interval * 3 + 1;
		// Create sublists based on interval
		while (interval > 0) {
			int valueToInsert = 0;
			int position = 0;
			for (int i = interval; i < integerArray.length; i++) {
				// select value to be inserted
				valueToInsert = integerArray[i];
				position = i;
				// shift elements towards right
				while (position > interval - 1 && integerArray[position - interval] >= valueToInsert) {
					integerArray[position] = integerArray[position - interval];
					position -= interval;
				}
				// insert number at hole position
				integerArray[position] = valueToInsert;
			}
			interval = (interval - 1) / 3;
		}
		return integerArray;
	}

}
