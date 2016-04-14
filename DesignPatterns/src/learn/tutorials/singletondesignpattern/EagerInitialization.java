package learn.tutorials.singletondesignpattern;

import java.util.logging.Logger;

public class EagerInitialization {
	private static Logger log = Logger.getLogger(EagerInitialization.class
			.getSimpleName());

	public static void main(String[] args) {
		// Getting the instance of Singleton Class, setting a string and then
		// getting it through second reference variable
		SingletonClassEI object1 = SingletonClassEI.getInstance();
		log.info("Object 1 : " + object1.hashCode());
		SingletonClassEI object2 = SingletonClassEI.getInstance();
		log.info("Object 2 : " + object2.hashCode());
	}

}

/**
 * Class to be implemented as Singleton with Eager Initialization
 * 
 * @author saurabh.kedia
 *
 */
class SingletonClassEI {
	// Only instance which will be created when the class is loaded.
	private static SingletonClassEI singleton = new SingletonClassEI();
	private String stringVariable;

	// Private constructor to restrict others from creating new objects of this
	// class
	private SingletonClassEI() {
	}

	// Method to return the single instance created for this class
	public static SingletonClassEI getInstance() {
		return singleton;
	}

	public String getStringVariable() {
		return stringVariable;
	}

	public void setStringVariable(String stringVariable) {
		this.stringVariable = stringVariable;
	}
}