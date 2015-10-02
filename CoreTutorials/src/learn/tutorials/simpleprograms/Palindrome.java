package learn.tutorials.simpleprograms;

public class Palindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int input = 12321;
		String inputString = String.valueOf(input);
		char[] inputArray = inputString.toCharArray();
		String resultString = "";
		for(int i = 0; i < inputArray.length; i++){
			resultString += inputArray[inputArray.length - 1 - i];
		}
		System.out.println(resultString);
		int result = Integer.parseInt(resultString);
		if(result == input){
			System.out.println(true);
		} else {
			System.out.println(false);
		}
	}
}
