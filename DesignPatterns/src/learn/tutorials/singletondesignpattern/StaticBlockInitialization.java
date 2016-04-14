package learn.tutorials.singletondesignpattern;

import java.util.logging.Logger;

public class StaticBlockInitialization {
	private static Logger log = Logger
			.getLogger(StaticBlockInitialization.class.getSimpleName());

	public static void main(String[] args) {
		// Getting the instance of Singleton Class, setting a string and then
		// getting it through second reference variable
		SingletonClassSBI object1 = SingletonClassSBI.getInstance();
		log.info("Object 1 : " + object1.hashCode());
		SingletonClassSBI object2 = SingletonClassSBI.getInstance();
		log.info("Getting the String Variable in second Instance");
		log.info("Object 2 : " + object2.hashCode());
	}

}

/**
 * Class to be implemented as Singleton with Static Block Initialization
 * 
 * @author saurabh.kedia
 *
 */
class SingletonClassSBI {
	private static SingletonClassSBI singleton;
	private String stringVariable;

	//static block
	static {
		try{
			singleton = new SingletonClassSBI();
		} catch (Exception ex){
			System.out.println(ex.getMessage() + "\n" + ex.getStackTrace());
		}
	}
	
	// Private constructor to restrict others from creating new objects of this
	// class
	private SingletonClassSBI() {
	}

	// Method to return the single instance created for this class
	public static SingletonClassSBI getInstance() {
		return singleton;
	}

	public String getStringVariable() {
		return stringVariable;
	}

	public void setStringVariable(String stringVariable) {
		this.stringVariable = stringVariable;
	}
}