package algorithms.string;

import java.util.HashSet;
import java.util.Set;

public class StringPermutation {

	public static void main(String[] args) {
		String sample = "saurabh";
		System.out.println(findPermutations(sample));
	}

	private static Set<String> findPermutations(String sample) {
		Set<String> stringSet = new HashSet<>();
		if (sample == null)
			return null;
		else if (sample.length() == 0) {
			stringSet.add("");
			return stringSet;
		}
		char initial = sample.charAt(0);
		String substring = sample.substring(1);

		Set<String> words = findPermutations(substring);
		for (String word : words) {
			for (int i = 0; i <= word.length(); i++) {
				String begin = word.substring(0, i);
				String end = word.substring(i);
				stringSet.add(begin + initial + end);
			}
		}
		return stringSet;
	}

}
