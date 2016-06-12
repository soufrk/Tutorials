package learn.tutorials.generics;

/**
 * <li><b>Generic Methods and Bounded Type Parameters</b></li>
 * 
 * @author saurabh.kedia
 *
 */
public class Demo005 {

	public static void main(String[] args) {
		Class3[] arrayOfClass3 = new Class3[] { new Class3("Hello"),
				new Class3("World"), new Class3("I"), new Class3("am"),
				new Class3("Generics") };
		Class3 obj = new Class3("Java");
		int count = countGreaterThan(arrayOfClass3, obj);
		System.out.println(count);
	}

	/**
	 * Below method will throw compile error as the element can be anything but
	 * '>' operator will work only for numbers
	 */
	// public static <T> int countGreaterThan(T[] anArray, T elem) {
	// int count = 0;
	// for (T e : anArray)
	// if (e > elem) // compiler error
	// ++count;
	// return count;
	// }

	/**
	 * The way to overcome the compilation error is by bounding the type
	 * parameter with comparable objects of the same type
	 * 
	 * @param array
	 *            : array of elements of type T
	 * @param element
	 *            : element of type T
	 * @return count of elements greater than given element in the given array
	 */
	public static <T extends Comparable<T>> int countGreaterThan(T[] array,
			T element) {
		int count = 0;
		for (T e : array)
			if (e.compareTo(element) > 0)
				++count;
		return count;
	}
}

/**
 * Class implementing Comparable interface and overriding compareTo method
 * 
 * @author saurabh.kedia
 *
 */
class Class3 implements Comparable<Class3> {
	public String str;

	public Class3(String str) {
		this.str = str;
	}

	@Override
	public int compareTo(Class3 obj1) {
		return str.compareTo(obj1.str);
	}

}
