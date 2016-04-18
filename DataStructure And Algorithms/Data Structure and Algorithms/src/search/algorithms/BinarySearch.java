package search.algorithms;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <ul>
 * <li>Implementing the algorithm of Binary Search</li>
 * <li>PseudoCode :</li>
 * <ol>
 * <li>DECLARE INTEGER x [] = [ -5, 12, 15, 20, 30, 72, 456 ]</li>
 * <li>DECLARE INTEGER loIndex = 0</li>
 * <li>DECLARE INTEGER hiIndex = LENGTH (x) - 1</li>
 * <li>DECLARE INTEGER midIndex, srch = 72</li>
 * <li>WHILE loIndex <= hiIndex</li>
 * <li>midIndex = (loIndex + hiIndex) / 2</li>
 * <li>IF srch > x [midIndex] THEN</li>
 * <li>loIndex = midIndex + 1</li>
 * <li>ELSE</li>
 * <li>IF srch < x [midIndex] THEN</li>
 * <li>hiIndex = midIndex - 1</li>
 * <li>ELSE</li>
 * <li>EXIT WHILE</li>
 * <li>END IF</li>
 * <li>END WHILE</li>
 * <li>IF loIndex > hiIndex THEN</li>
 * <li>PRINT srch, " not found"</li>
 * <li>ELSE</li>
 * <li>PRINT srch, " found"</li>
 * <li>END IF</li>
 * <li>END</li>
 * </ol>
 * </ul>
 * <ul>
 * <li>Pros : Reduced time spent examining elements</li>
 * <li>Cons : Increased complexity and the need to sort the one-dimensional
 * array before starting the search.</li>
 * <li>Time Complexity : The worst-case and average-case time complexity for
 * binary search is O(log n). The best-case is O(1).</li>
 * </ul>
 * 
 * @author saurabh.kedia
 *
 */
public class BinarySearch {

	public static void main(String[] args) {
		// one-dimensional integer array
		int[] integerArray = new int[] { 3, 5, 2, 9, 12, 44, 54, 8, 6, 11, 0 };
		System.out.println(Arrays.toString(integerArray));
		int search = 0;
		try (Scanner in = new Scanner(System.in)) {
			// take user input which no to search
			search = in.nextInt();
		}
		// Binary Search Code -- it needs sorted Array
		Arrays.sort(integerArray);
		System.out.println(Arrays.toString(integerArray));
		int position = binarySearch(0, integerArray.length, search,
				integerArray);

		if (position != -1)
			System.out.println("Found at position : " + (position));
		else
			System.out.println("Not Found");
	}

	private static int binarySearch(int lowIndex, int highIndex,
			int noToSearch, int[] srcArray) {
		// calculate the mid index of the array
		int result = 0;
		int midIndex = (highIndex + lowIndex) / 2;
		// if low index becomes greater than high index return -1
		if (lowIndex > highIndex) {
			result = -1;
		}
		if (noToSearch > srcArray[midIndex]) {
			// no to search is greater than number present at mid index call
			// binary
			// search recursively and replace low index with mid index + 1
			result = binarySearch(midIndex + 1, highIndex, noToSearch, srcArray);
		} else if (noToSearch < srcArray[midIndex]) {
			// no to search is less than number present at mid index call binary
			// search recursively and replace high index with mid index - 1
			result = binarySearch(lowIndex, midIndex - 1, noToSearch, srcArray);
		} else {
			// else the number is present at the mid index
			result = midIndex + 1;
		}

		return result;
	}
}
