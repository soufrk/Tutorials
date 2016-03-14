package learn.tutorials.creational.singleton;

import java.lang.reflect.Constructor;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReflectionDestroyingSingleton {
	private static Logger log = Logger
			.getLogger(ReflectionDestroyingSingleton.class.getSimpleName());

	public static void main(String[] args) {
		// Get the instance of Singleton Class
		SingletonClass instance1 = SingletonClass.getInstance();
		SingletonClass instance2 = null;
		try {
			Constructor<?>[] constructors = SingletonClass.class
					.getDeclaredConstructors();
			for (Constructor<?> constructor : constructors) {
				// Below code will destroy singleton feature
				constructor.setAccessible(true);
				if(constructor.getParameterCount() == 0){
					instance2 = (SingletonClass) constructor.newInstance();
					break;
				}
			}
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
		}
		log.info("Object 1 : " + instance1.hashCode());
		log.info("Getting msg through second reference");
		log.info("Object 2 : " + instance2.hashCode());
	}
}

/**
 * Class to be implemented as Singleton using Bill Pugh Singleton Implementation
 * 
 * @author saurabh.kedia
 *
 */
class SingletonClass {
	private String stringVariable;

	/**
	 * Private constructor to restrict others from creating new objects of this
	 * class
	 */
	private SingletonClass() {
	}

	private static class SingletonClassInstance {
		private static SingletonClass INSTANCE = new SingletonClass();
	}

	/**
	 * Method to return the single instance created for this class which
	 * internally calls the private static class to get the INSTANCE, no
	 * synchronization is required and it eill be called only once when the
	 * first call is made
	 * 
	 * @return SingletonClassLI1
	 */

	public static SingletonClass getInstance() {
		return SingletonClassInstance.INSTANCE;
	}

	public String getStringVariable() {
		return stringVariable;
	}

	public void setStringVariable(String stringVariable) {
		this.stringVariable = stringVariable;
	}
}