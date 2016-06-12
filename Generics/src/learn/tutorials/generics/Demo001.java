package learn.tutorials.generics;

/**
 * Defining a generic type
 * 
 * @author saurabh.kedia
 *
 * @param <T>
 */
public class Demo001<T> {

	public static void main(String[] args) {
		/*
		 * String is passed as the type parameter at the time of initializing
		 * the object of Demo001.
		 */
		Demo001<String> obj1 = new Demo001<>();
		obj1.printContent("Hello World");
		/*
		 * throws exception if we try to pass integer to the method.
		 */
		// obj1.printContent(1);
		/*
		 * Integer is passed as the type parameter at the time of initializing
		 * thus it will accept only integers.
		 */
		Demo001<Integer> obj2 = new Demo001<>();
		obj2.printContent(108);
	}

	/**
	 * Generic method to print any passed object to console.
	 * 
	 * @param t
	 *            : input object
	 */
	public void printContent(T t) {
		System.out.println(t.toString());
	}

}
