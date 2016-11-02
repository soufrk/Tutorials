package algorithms.search;

/**
 * Optimal block size for jump search is square root of length of array. Jump
 * the array by block size and find the index of element less than and more than
 * the key. perform a linear search on it to find the key
 * 
 * @author saurabh.kedia
 *
 */
public class JumpSearch {

	public static void main(String[] args) {
		int[] sortedIntArray = { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610 };
		int key = 55;
		int blockSize = (int) Math.floor(Math.sqrt(sortedIntArray.length));
		int startIndex = -1;
		int endIndex = -1;
		for (int i = 0; i < sortedIntArray.length; i += blockSize) {
			if (sortedIntArray[i] < key)
				startIndex = i;
			if (sortedIntArray[i] >= key)
				endIndex = i;
		}
		if (startIndex == -1 || endIndex == -1) {
			System.out.println("Key not found");
		}

		int position = -1;
		for (int j = startIndex; j <= endIndex; j++) {
			if (sortedIntArray[j] == key) {
				position = j;
			}
		}
		System.out.println((position != -1) ? "Key found at position " + position : "Key not found");
	}

}
