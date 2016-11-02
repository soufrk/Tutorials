package algorithms.search;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <ul>
 * <ol>
 * <li>Implementing the algorithm of Linear Search.</li>
 * <li>PseudoCode</li>
 * <li>DECLARE INTEGER i, srch = 72</li>
 * <li>DECLARE INTEGER x [] = [ 20, 15, 12, 30, -5, 72, 456 ]</li>
 * <li>FOR i = 0 TO LENGTH (x) - 1</li>
 * <li>IF x [i] IS srch THEN</li>
 * <li>PRINT "Found ", srch
 * <li>END</li>
 * <li>END IF</li>
 * <li>NEXT i</li>
 * <li>PRINT "Did not find ", srch</li>
 * <li>END</li>
 * </ol>
 * <ul>
 * <li>Pros : simplicity and the ability to search either sorted or unsorted
 * one-dimensional arrays.</li>
 * <li>Cons : time spent examining elements. The average number of elements to
 * examine is half the one-dimensional array's length, and the maximum number of
 * elements to examine is the entire length.</li>
 * <li>Complexity : The worst-case and average-case time complexity is O(n). The
 * best-case is O(1).</li>
 * </ul>
 * </ul>
 * 
 * @author saurabh.kedia
 *
 */
public class LinearSearch {

	public static void main(String[] args) {
		// one-dimensional integer array
		int[] integerArray = new int[] { 3, 5, 2, 9, 12, 44, 54, 8, 6, 11, 0 };
		// flag found
		boolean isFound = false;
		// found at position
		int position = 0;
		System.out.println(Arrays.toString(integerArray));
		int search = 0;
		try (Scanner in = new Scanner(System.in)) {
			// take user input which no to search
			search = in.nextInt();
		}
		// use linear search to find the number
		for (int i = 0; i < integerArray.length - 1; i++) {
			if (integerArray[i] == search) {
				// if found print 'Found' with its position
				position = i + 1;
				isFound = true;
				break;
			}
		}
		if (isFound)
			System.out.println("Found at position : " + (position));
		else
			System.out.println("Not Found");
	}
}
