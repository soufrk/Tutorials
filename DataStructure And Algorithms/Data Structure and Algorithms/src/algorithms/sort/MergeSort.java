package algorithms.sort;

import java.util.Arrays;

/**
 * Merge sort is a sorting technique based on divide and conquer technique. With
 * worst-case time complexity being Ο(n log n),
 * 
 * @author KD
 *
 */
public class MergeSort {

	public static void main(String[] args) {
		// unsorted integer array
		int[] integerArray = new int[] { 4, 3, 5, 9, 0, 11, 44, 33, 99, 52, 56, 93 };
		System.out.println("Unsorted array : " + Arrays.toString(integerArray));

		// merge sort
		integerArray = mSort(integerArray);

		// Sorted Array
		System.out.println("Sorted array : " + Arrays.toString(integerArray));
	}

	/**
	 * <ul>
	 * <li>Algorithm</li>
	 * <li>if length of array sent in parameter is one return the array</li>
	 * <li>Implements merge sort, divides the array in 2 halves based on its
	 * length and call merge sort recursively on each part</li>
	 * <li>return the merged sorted array by calling merge on both the parts
	 * </li>
	 * </ul>
	 * 
	 * @param integerArray
	 * @return
	 */
	private static int[] mSort(int[] integerArray) {
		int length = integerArray.length;
		if (length == 1)
			return integerArray;
		int[] leftArray = subArray(0, length / 2, integerArray);
		int[] rightArray = subArray(length / 2, length, integerArray);
		leftArray = mSort(leftArray);
		rightArray = mSort(rightArray);

		return merge(leftArray, rightArray);
	}

	/**
	 * <ul>
	 * <li>Merge Function</li>
	 * <li>Merges the two arrays passed as input and return the merged array
	 * </li>
	 * <ol>
	 * <li>while array a and array b has elements</li>
	 * <li>if element e of array a is less than element f of array b set e to
	 * merged array's first position</li>
	 * <li>else do the inverse of above</li>
	 * <li>while elements are left in array a, set them to merged array in
	 * respective position</li>
	 * <li>while elements are left in array b, set them to merged array in
	 * respective position</li>
	 * </ol>
	 * </ul>
	 * 
	 * @param leftArray
	 * @param rightArray
	 * @return
	 */
	private static int[] merge(int[] leftArray, int[] rightArray) {
		int[] mergedArray = new int[leftArray.length + rightArray.length];
		int lIndex = 0;
		int rIndex = 0;
		int mergedIndex = 0;
		while (lIndex < leftArray.length && rIndex < rightArray.length) {
			if (leftArray[lIndex] < rightArray[rIndex]) {
				mergedArray[mergedIndex++] = leftArray[lIndex++];
			} else {
				mergedArray[mergedIndex++] = rightArray[rIndex++];
			}
		}
		while (lIndex < leftArray.length) {
			mergedArray[mergedIndex++] = leftArray[lIndex++];
		}
		while (rIndex < rightArray.length) {
			mergedArray[mergedIndex++] = rightArray[rIndex++];
		}
		return mergedArray;
	}

	/**
	 * Returns a sub array based on start and end index provided
	 * 
	 * @param start
	 * @param end
	 * @param integerArray
	 * @return
	 */
	private static int[] subArray(int start, int end, int[] integerArray) {
		int[] dummyArray = new int[end - start];
		for (int i = start, j = 0; i < end; i++, j++) {
			dummyArray[j] = integerArray[i];
		}
		return dummyArray;
	}

}
