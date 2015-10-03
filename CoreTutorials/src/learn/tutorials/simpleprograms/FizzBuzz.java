package learn.tutorials.simpleprograms;

/**
 * Java program to print from number 1 to 50 where for each multiple of 3 it
 * should print "Fizz", for each multiple of 5 it should print "Buzz" and for
 * each multiple of 3 & 5 it should print "FizzBuzz"
 * 
 * @author KD
 * 
 */
public class FizzBuzz {

	public static void main(String[] args) {
		for (int i = 0; i <= 50; i++) {
			if (i % 3 == 0 && i % 5 == 0)
				System.out.println("FizzBuzz\t");
			else if (i % 3 == 0)
				System.out.println("Fizz\t");
			else if (i % 5 == 0)
				System.out.println("Buzz\t");
			else
				System.out.println(i + "\t");
		}

	}

}
