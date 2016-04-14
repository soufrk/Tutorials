package sort.algorithms;

import java.util.Arrays;

/**
 * <ul>
 * <li>Implementation of algorithm of Selection sort</li>
 * <li>Complexity : O(n^2)</li>
 * </ul>
 * 
 * @author KD
 *
 */
public class SelectionSort {

	public static void main(String[] args) {
		// unsorted integer array
		int[] integerArray = new int[] { 4, 3, 5, 9, 0, 11, 44, 33, 99, 52, 56, 93 };
		System.out.println("Unsorted array : " + Arrays.toString(integerArray));

		// selection sort
		integerArray = sSort(integerArray);

		// Sorted Array
		System.out.println("Sorted array : " + Arrays.toString(integerArray));
	}

	public static int[] sSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int position = 0;
			int largest = array[0];
			for (int j = 0; j < array.length - i; j++) {
				if (largest < array[j]) {
					position = j;
					largest = array[j];
				}
			}
			int temp = array[array.length - 1 - i];
			array[array.length - 1 - i] = array[position];
			array[position] = temp;
		}
		return array;
	}
}
