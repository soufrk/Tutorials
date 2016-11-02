package algorithms.backtracking;

public class StringPermutation {

	public static void main(String[] args) {
		String src = "abcdefghi";
		int permArrayLength = factorial(src.length());
		System.out.println(permArrayLength);
		permuteString(src, 0, src.length());
	}

	private static void permuteString(String str, int start, int end) {
		// if start index == length of string then print the permutation
		if (start == end)
			System.out.print(str + "\t");
		else {
			// for each character in the string from start to end index
			for (int i = start; i < end; i++) {
				// swap the characters start and i
				str = swap(str, start, i);
				// fix the start character by passing the next index to permute
				// on
				permuteString(str, start + 1, end);
				// backtrack
				str = swap(str, i, start);
			}
		}
	}

	private static String swap(String str, int start, int i) {
		char[] charArray = str.toCharArray();
		char temp = charArray[start];
		charArray[start] = charArray[i];
		charArray[i] = temp;
		return new String(charArray);
	}

	/**
	 * Returns factorial of the given number
	 * 
	 * @param n
	 * @return
	 */
	public static int factorial(int n) {
		if (n == 1)
			return 1;
		return n * factorial(n - 1);
	}

}
