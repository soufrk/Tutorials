package learn.tutorials.singletondesignpattern;

public class SingletonDesignPatternDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//create object of Singleton Class and set a message
		SingletonClass2 firstObject = SingletonClass2.getInstance();
		firstObject.setMessage("Setting message in First object");
		
		//get one more instance of Singleton Class, get the message and print it.
		SingletonClass2 secondObject = SingletonClass2.getInstance();
		System.out.println(secondObject.getMessage());

	}

}
