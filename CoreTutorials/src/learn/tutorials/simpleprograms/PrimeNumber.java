package learn.tutorials.simpleprograms;

public class PrimeNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int input = 89;
		boolean result = isInputPrime(input);
		System.out.println("The number " + input + " is prime " + result);
	}

	private static boolean isInputPrime(int input) {
		int count = 0;
		for(int i = 1; i <= input/2; i++){
			if(input%i == 0){
				count++;
			}
		}
		if(count == 1){
			return true;
		} else 
			return false;
	}

}
