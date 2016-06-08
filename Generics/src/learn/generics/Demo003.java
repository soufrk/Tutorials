package learn.tutorials.generics;

/**
 * <ul>
 * <b> Bounded Type Parameters</b>
 * <li>
 * Used to restrict the types that can be used as type arguments in a
 * parameterized type.</li>
 * <li>
 * To declare a bounded type parameter, list the type parameter's name, followed
 * by the extends keyword, followed by its upper bound, which in this example is
 * Number. Note that, in this context, extends is used in a general sense to
 * mean either "extends" (as in classes) or "implements" (as in interfaces).</li>
 * </ul>
 * 
 * @author saurabh.kedia
 *
 */
public class Demo003 {

	public static void main(String[] args) {
		Demo003 obj = new Demo003();
		/*
		 * method will accept integers and floats as they are subclasses of
		 * Number but it will throw compile time exception for string.
		 */
		obj.printNumbers(108);
		obj.printNumbers(11.0);
		//obj.printNumbers("Hello World");
	}

	/**
	 * Method that will operate only on numbers so we have to restrict the type
	 * arguments passed to it.
	 * 
	 * @param t
	 */
	public <T extends Number> void printNumbers(T t) {
		System.out.println(t.toString());
	}

}
