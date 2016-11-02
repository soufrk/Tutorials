package algorithms.sort;

import java.util.Arrays;

/**
 * <ul>
 * <li>Implementation of insertion sort</li>
 * <li>Complexity : O(n^2)</li>
 * <ul>
 * 
 * @author KD
 *
 */
public class InsertionSort {

	public static void main(String[] args) {
		// unsorted integer array
		int[] integerArray = new int[] { 4, 3, 5, 9, 0, 11, 44, 33, 99, 52, 56, 93 };
		System.out.println("Unsorted array : " + Arrays.toString(integerArray));

		// insertion sort
		integerArray = iSort(integerArray);

		// Sorted Array
		System.out.println("Sorted array : " + Arrays.toString(integerArray));
	}

	/**
	 * Insertion sort algo :- swap the value at the current position until it is
	 * lower than its previous value
	 * 
	 * @param integerArray
	 * @return
	 */
	private static int[] iSort(int[] integerArray) {
		for (int i = 1; i < integerArray.length; i++) {
			int position = i;
			int current = integerArray[i];
			while (position > 0 && integerArray[position - 1] > current) {
				integerArray[position] = integerArray[position - 1];
				integerArray[position - 1] = current;
				position--;
			}
		}
		return integerArray;
	}

}
