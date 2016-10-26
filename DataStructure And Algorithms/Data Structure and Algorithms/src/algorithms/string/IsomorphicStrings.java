package algorithms.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Check if two given strings are isomorphic or not. Two strings are isomorphic
 * if characters in string1 can be replaced to get string 2. Ex :
 * 
 * "egg" and "add" -> isomorphic, "foo" and "bar" -> not isomorphic
 * 
 * @author KD
 *
 */
public class IsomorphicStrings {

	public static void main(String[] args) {
		String s = "foo";
		String t = "bar";
		boolean result = true;
		Map<Character, Character> charMap = new HashMap<>();
		if (s == null || t == null || s.length() != t.length())
			result = false;
		else {
			for (int i = 0; i < s.length(); i++) {
				char c1 = s.charAt(i);
				char c2 = t.charAt(i);
				if (charMap.containsKey(c1) && charMap.get(c1) != c2)
					result = false;
				else {
					charMap.put(c1, c2);
				}
			}
			System.out.println(result);
		}
	}

}
