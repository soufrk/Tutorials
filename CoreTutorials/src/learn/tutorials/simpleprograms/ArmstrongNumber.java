package learn.tutorials.simpleprograms;

public class ArmstrongNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int input = 375;
		int dupinput = input;
		int armstrongNo = 0;
		while(input != 0){ 
			int temp = 0;
			temp = input%10;
			temp = temp*temp*temp;
			armstrongNo += temp;
			input = input/10;
		}
		if(armstrongNo == dupinput){
			System.out.println(true);
		} else {
			System.out.println(false);
		}
	}

}
