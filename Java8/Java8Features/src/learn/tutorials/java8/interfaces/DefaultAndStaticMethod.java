package learn.tutorials.java8.interfaces;

/**
 * Interface 1 having default method
 * 
 * @author KD
 *
 */
interface DefaultInterface1 {

	public void setString(String str);

	default void log(String str) {
		System.out.println("default interface 1 : Logging :: " + str);
	}
}

/**
 * Interface 2 having same default method
 * 
 * @author KD
 *
 */
interface DefaultInterface2 {

	public void setString(String str);

	default void log(String str) {
		System.out.println("default interface 2 : Logging :: " + str);
	}
}

/**
 * Class implementing single Interface having default method. No need to
 * override default method
 * 
 * @author KD
 *
 */
class SingleImplementationClass implements DefaultInterface1 {
	String str;

	@Override
	public void setString(String str) {
		this.str = str;
	}

}

/**
 * Class implementing two Interfaces having same default method. Have to
 * override default method to avoid diamond problem
 * 
 * @author KD
 *
 */
class DoubleImplementationClass implements DefaultInterface1, DefaultInterface2 {
	String str;

	@Override
	public void setString(String str) {
		this.str = str;
	}

	@Override
	public void log(String str) {
		System.out.println("Implementation Class : Logging :: " + str);
	}

}

/**
 * Interface to demonstrate static method
 * 
 * @author KD
 *
 */
interface StaticInterface1 {

	public static String isNullString(String str) {
		if (str == null) {
			return "String is null";
		} else {
			return "String is not null";
		}
	}

	default void printString(String str) {
		String nullCheckResult = isNullString(str);
		System.out.println("Printing in static interface 1 :: " + nullCheckResult);
	}
}

/**
 * Class implementing interface having static method. Not compulsory to override
 * 
 * @author KD
 *
 */
class ClassImplementingStaticInterface implements StaticInterface1 {
}

/**
 * Interface having only one abstract method : Funtional Interface
 * 
 * @author KD
 *
 */
@FunctionalInterface
interface FunctionalInterfaceDemo {
	public void method1();
}

/**
 * Demo class
 * 
 * @author KD
 *
 */
public class DefaultAndStaticMethod {
	public static void main(String[] args) {
		// testing first class implementing only one interface having default
		// method
		SingleImplementationClass object1 = new SingleImplementationClass();
		object1.setString("Test String one");
		object1.log(object1.str);

		// testing second class implementing two interfaces having same default
		// method
		DoubleImplementationClass object2 = new DoubleImplementationClass();
		object2.setString("Test String two");
		object2.log(object2.str);

		// testing third class implementing interface having static method
		ClassImplementingStaticInterface object3 = new ClassImplementingStaticInterface();
		object3.printString("");
		
		//testing functional interface with lambda expression, no prior implementation required 
		printString(() -> System.out.println("functional Interface Test String"));
		
		FunctionalInterfaceDemo fid = () -> { System.out.println("functional Interface Test String"); };
		fid.method1();
	}
	
	public static void printString(FunctionalInterfaceDemo fid){
		fid.method1();
	}
}