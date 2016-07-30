package learn.tutorials.singletondesignpattern;

import java.util.logging.Logger;

public class LazyInitialization {
	private static Logger log = Logger.getLogger(LazyInitialization.class
			.getSimpleName());

	public static void main(String[] args) {
		// Getting the instance of Singleton Class, setting a string and then
		// getting it through second reference variable
		SingletonClassLI1 object1 = SingletonClassLI1.getInstance();
		log.info("Object 1 : " + object1.hashCode());
		SingletonClassLI1 object2 = SingletonClassLI1.getInstance();
		log.info("Object 2 : " + object2.hashCode());

		SingletonClassLI2 object3 = SingletonClassLI2.getInstance();
		log.info("Object 3 : " + object3.hashCode());
		SingletonClassLI2 object4 = SingletonClassLI2.getInstance();
		log.info("Object 4 : " + object4.hashCode());

		SingletonClassLI3 object5 = SingletonClassLI3.getInstance();
		log.info("Object 5 : " + object5.hashCode());
		SingletonClassLI3 object6 = SingletonClassLI3.getInstance();
		log.info("Object 6 : " + object6.hashCode());
	}

}

/**
 * Class to be implemented as Singleton with Lazy Initialization for single
 * threaded environment
 * 
 * @author saurabh.kedia
 *
 */
class SingletonClassLI1 {
	private static SingletonClassLI1 singleton;
	private String stringVariable;

	/**
	 * Private constructor to restrict others from creating new objects of this
	 * class
	 */
	private SingletonClassLI1() {
	}

	/**
	 * Method to return the single instance created for this class
	 * 
	 * @return SingletonClassLI1
	 */
	public static SingletonClassLI1 getInstance() {
		// if the instance is null then create a new instance, happens only at
		// first call
		if (singleton == null)
			singleton = new SingletonClassLI1();
		return singleton;
	}

	public String getStringVariable() {
		return stringVariable;
	}

	public void setStringVariable(String stringVariable) {
		this.stringVariable = stringVariable;
	}
}

/**
 * Class to be implemented as Singleton with Lazy Initialization for
 * multi-threaded environment : First solution
 * 
 * @author saurabh.kedia
 *
 */
class SingletonClassLI2 {
	private static SingletonClassLI2 singleton;
	private String stringVariable;

	/**
	 * Private constructor to restrict others from creating new objects of this
	 * class
	 */
	private SingletonClassLI2() {
	}

	/**
	 * Synchronized Method to return the single instance created for this class
	 * : Inefficient as the complete method is synchronized and threads might
	 * wait while getting the already created instance
	 * 
	 * @return SingletonClassLI1
	 */

	public static synchronized SingletonClassLI2 getInstance() {
		if (singleton == null)
			singleton = new SingletonClassLI2();
		return singleton;
	}

	public String getStringVariable() {
		return stringVariable;
	}

	public void setStringVariable(String stringVariable) {
		this.stringVariable = stringVariable;
	}
}

/**
 * Class to be implemented as Singleton with Lazy Initialization for
 * multi-threaded environment : Second solution
 * 
 * @author saurabh.kedia
 *
 */
class SingletonClassLI3 {
	private static SingletonClassLI3 singleton;
	private String stringVariable;

	/**
	 * Private constructor to restrict others from creating new objects of this
	 * class
	 */
	private SingletonClassLI3() {
	}

	/**
	 * Synchronized Method to return the single instance created for this class
	 * using double checked locking
	 * 
	 * @return SingletonClassLI1
	 */

	public static SingletonClassLI3 getInstance() {
		// Check if the instance is null
		if (singleton == null)
			// write the initialization part in synchronized block
			synchronized (SingletonClassLI3.class) {
				// Re-check whether the instance is still null
				if (singleton == null)
					singleton = new SingletonClassLI3();
			}
		return singleton;
	}

	public String getStringVariable() {
		return stringVariable;
	}

	public void setStringVariable(String stringVariable) {
		this.stringVariable = stringVariable;
	}
}