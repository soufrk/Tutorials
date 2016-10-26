package sort.algorithms;

import java.util.Arrays;

/**
 * <ol>
 * <li>algorithm quicksort(A, lo, hi)</li>
 * <li>if lo {@literal <} hi then</li>
 * <li>p := partition(A, lo, hi)</li>
 * <li>quicksort(A, lo, p – 1)</li>
 * <li>quicksort(A, p + 1, hi)</li>
 * </ol>
 * <ol>
 * <li>algorithm partition(A, lo, hi)</li>
 * <li>pivot = A[hi]</li>
 * <li>i = lo // place for swapping</li>
 * <li>for j = lo to hi – 1 do</li>
 * <li>if A[j] ≤ pivot then</li>
 * <li>swap A[i] with A[j]</li>
 * <li>i = i + 1</li>
 * <li>swap A[i] with A[hi]</li>
 * <li>return i</li>
 * </ol>
 * <ul>
 * <li>Best/Average case time complexity: O(nlog n)</li>
 * <li>Worst case time complexity: O(n^2)</li>
 * <li>Space complexity worse: O(nlog n)</li>
 * </ul>
 * 
 * @author saurabh.kedia
 *
 */
public class QuickSort {

	public static void main(String[] args) {
		// unsorted integer array
		int[] integerArray = new int[] { 41, 23, 54, 19, 10, 11, 92, 33, 99, 52, 46, 43 };
		System.out.println("Unsorted array : " + Arrays.toString(integerArray));

		// selection sort
		integerArray = qSort(integerArray, 0, integerArray.length - 1);

		// Sorted Array
		System.out.println("Sorted array : " + Arrays.toString(integerArray));
	}

	private static int[] qSort(int[] integerArray, int startIndex, int endIndex) {
		if (startIndex > endIndex)
			return integerArray;
		int pivot = partition(integerArray, startIndex, endIndex);
		integerArray = qSort(integerArray, startIndex, pivot - 1);
		integerArray = qSort(integerArray, pivot + 1, endIndex);
		return integerArray;
	}

	private static int partition(int[] integerArray, int startIndex, int endIndex) {
		int pivot = integerArray[endIndex];
		int pIndex = startIndex;
		for (int i = startIndex; i <= endIndex; i++) {
			if (integerArray[i] <= pivot) {
				integerArray = swap(integerArray, i, pIndex);
				pIndex++;
			}
		}
		System.out.println(Arrays.toString(integerArray));
		return pIndex - 1;
	}

	private static int[] swap(int[] integerArray, int i, int pIndex) {
		int temp = integerArray[i];
		integerArray[i] = integerArray[pIndex];
		integerArray[pIndex] = temp;
		return integerArray;
	}

}
