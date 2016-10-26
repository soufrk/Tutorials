package algorithms.string;

/**
 * Reverse a string without using in-built methods
 * 
 * @author KD
 *
 */
public class ReverseString {

	public static void main(String[] args) {
		String source = "This is sample string";
		String destination = "";
		for (int i = source.length() - 1; i >= 0; i--) {
			destination += String.valueOf(source.charAt(i));
		}
		System.out.println("Source String: " + source);
		System.out.println("Destination String: " + destination);
	}

}