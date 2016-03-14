package learn.tutorials.creational.singleton;

import java.lang.reflect.Constructor;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BillPughSingletonImplementation {
	private static Logger log = Logger
			.getLogger(BillPughSingletonImplementation.class.getSimpleName());

	public static void main(String[] args) {
		// Getting the instance of Singleton Class, setting a string and then
		// getting it through second reference variable
		SingletonClassBP object1 = SingletonClassBP.getInstance();
		log.info("Object 1 : " + object1.hashCode());
		SingletonClassBP object2 = SingletonClassBP.getInstance();
		log.info("Object 2 : " + object2.hashCode());
		
		
		//trying to get a new instance using class loader
		ClassLoader load = BillPughSingletonImplementation.class.getClassLoader();
		SingletonClassBP instance2 = null;
		try {
			Class<?> singletonClass = load.loadClass("learn.tutorials.creational.singleton.SingletonClassBP");
			Constructor<?>[] constructors = singletonClass
					.getDeclaredConstructors();
			for (Constructor<?> constructor : constructors) {
				// Below code will destroy singleton feature
				constructor.setAccessible(true);
				if(constructor.getParameterCount() == 0){
					instance2 = (SingletonClassBP) constructor.newInstance();
					break;
				}
			}
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
		}
		System.out.println("ClassLoader instance " + instance2.hashCode());
	}

}

/**
 * Class to be implemented as Singleton using Bill Pugh Singleton Implementation
 * 
 * @author saurabh.kedia
 *
 */
class SingletonClassBP {
	private String stringVariable;

	/**
	 * Private constructor to restrict others from creating new objects of this
	 * class
	 */
	private SingletonClassBP() {
	}

	private static class SingletonClassBPInstance {
		private static SingletonClassBP INSTANCE = new SingletonClassBP();
	}

	/**
	 * Method to return the single instance created for this class which
	 * internally calls the private static class to get the INSTANCE, no
	 * synchronization is required and it eill be called only once when the
	 * first call is made
	 * 
	 * @return SingletonClassLI1
	 */

	public static SingletonClassBP getInstance() {
		return SingletonClassBPInstance.INSTANCE;
	}

	public String getStringVariable() {
		return stringVariable;
	}

	public void setStringVariable(String stringVariable) {
		this.stringVariable = stringVariable;
	}
}