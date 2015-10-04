package learn.tutorial.threads;

import java.util.Scanner;

public class ThreadTutorial2 {
	/**
	 * Explains the use of volatile keyword :- Declaring a volatile Java variable
	 * means: The value of this variable will never be cached thread-locally:
	 * all reads and writes will go straight to "main memory"; Access to the
	 * variable acts as though it is enclosed in a synchronised block,
	 * Synchronised on itself.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		InfiniteRunner infiniteRunner = new InfiniteRunner();
		infiniteRunner.start();
		
		try(Scanner scanner = new Scanner(System.in)){
			scanner.nextLine();
		}catch (Exception e){
			e.printStackTrace();
		}
		
		infiniteRunner.shutdown();
	}

}
