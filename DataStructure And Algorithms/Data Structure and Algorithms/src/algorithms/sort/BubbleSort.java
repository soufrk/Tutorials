package algorithms.sort;

import java.util.Arrays;

/**
 * <ul>
 * <li>Implementing the algorithm of Bubble Sort</li>
 * <li>Pseudo Code :</li>
 * <ol>
 * <li>DECLARE INTEGER i, pass</li>
 * <li>DECLARE INTEGER x [] = [ 20, 15, 12, 30, -5, 72, 456 ]</li>
 * <li>FOR pass = 0 TO LENGTH (x) - 2</li>
 * <li>FOR i = 0 TO LENGTH (x) - pass - 2</li>
 * <li>IF x [i] > x [i + 1] THEN</li>
 * <li>SWAP x [i], x [i + 1]</li>
 * <li>END IF</li>
 * <li>NEXT i</li>
 * <li>NEXT pass</li>
 * <li>END</li>
 * </ol>
 * <li>Pros : simplest sorting algorithm</li>
 * <li>Cons : slowest sorting algorithm</li>
 * <li>Complexity : Bubble sort is not efficient, with complexity of O(n2).</li>
 * </ul>
 * 
 * @author saurabh.kedia
 *
 */
public class BubbleSort {

	public static void main(String[] args) {
		// one-dimensional integer array
		int[] integerArray = new int[] { 3, 5, 2, 9, 12, 44, 54, 8, 6, 11, 0 };
		System.out.println("Unsorted Array : " + Arrays.toString(integerArray));
		// Apply Bubble Sort on one dimensional array
		integerArray = BubbleSortImplementation(integerArray);
		// print the sorted array
		System.out.println("Sorted Array : " + Arrays.toString(integerArray));
	}

	// bubble sort code
	private static int[] BubbleSortImplementation(int[] integerArray) {
		for (int j = 0; j < integerArray.length - 1; j++) {
			for (int i = 0; i < integerArray.length - 1 - j; i++) {
				if (integerArray[i] > integerArray[i + 1]) {
					int temp = integerArray[i];
					integerArray[i] = integerArray[i + 1];
					integerArray[i + 1] = temp;
				}
			}
		}
		return integerArray;
	}

}
