package algorithms.string;

public class LongestPalindrome {

	public static void main(String[] args) {
		String str = "abcdaaabbbcccbbbaaa";
		String longest = str.substring(0, 1);
		for (int i = 0; i < str.length(); i++) {
			// for odd cases
			String palindrome = findLongestPalindrome(str, i, i);
			if (palindrome.length() > longest.length())
				longest = palindrome;
			// for even cases
			palindrome = findLongestPalindrome(str, i, i);
			if (palindrome.length() > longest.length())
				longest = palindrome;
		}
		System.out.println(longest);
	}

	private static String findLongestPalindrome(String s, int left, int right) {
		if (left > right)
			return null;
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return s.substring(left + 1, right);
	}

}
