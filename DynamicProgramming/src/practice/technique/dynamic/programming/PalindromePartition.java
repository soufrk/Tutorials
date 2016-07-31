package practice.technique.dynamic.programming;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PalindromePartition {

	public static void main(String[] args) {
		String str = "geek";
		Set<String> strSet = partitionString(str);
		System.out.println("Raw String Set ::: " + strSet);
		Iterator<String> strSetIterator = strSet.iterator();

		while(strSetIterator.hasNext()){
			String current = strSetIterator.next();
			if(!isPalindrome(current)){
				strSetIterator.remove();
			}
		}
		System.out.println("Palindrome substrings ::: " + strSet);
	}

	public static Set<String> partitionString(String s){
		Set<String> strSet = new HashSet<>();
		int length = s.length();
		for(int l = 1; l <= length; l++){
			for(int i = 0; i < l; i++){
				String subStr = s.substring(i, l);
				strSet.add(subStr);
			}
		}
		return strSet;
	}

	public static boolean isPalindrome(String s) {
		int length = s.length();
		if (length == 1) {
			return true;
		} else {
			for (int i = 0; i < length; i++) {
				if (s.charAt(i) != s.charAt(length - 1 - i))
					return false;
			}
			return true;
		}
	}
}
