package learn.tutorials.generics;

/**
 * <ul>
 * <b>Generics, Inheritance, and Subtypes</b>
 * <li>On providing upper bound to the type argument we can pass its sub-types
 * as well</li>
 * <li>For ex :- T extends Number then T will accept numbers and its subclasses
 * <br/>
 * public <T extends Number> void print(T t)</li>
 * <li>But the case like Box<Number> box = new Box<>() will not accept</li>
 * </ul>
 * 
 * @author saurabh.kedia
 *
 */
public class Demo006 {

	public static void main(String[] args) {
		printObject(1);
		printObject(1.0);
//		Below statement will give compilation error even though integer is subclass of Number
		//Subtype<Number> subType = new Subtype<Integer>();
	}

	public static <T extends Number> void printObject(T t) {
		System.out.println(t.toString());
	}
}

class Subtype<T> {
	T t;
}
