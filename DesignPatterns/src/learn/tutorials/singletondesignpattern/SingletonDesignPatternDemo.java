package learn.tutorials.singletondesignpattern;

public class SingletonDesignPatternDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//create object of Singleton Class and set a message
		SingletonClass firstObject = SingletonClass.getInstance();
		firstObject.setMessage("Setting message in First object");
		
		//get one more instance of Singleton Class, get the message and print it.
		SingletonClass secondObject = SingletonClass.getInstance();
		System.out.println(secondObject.getMessage());

	}

}
