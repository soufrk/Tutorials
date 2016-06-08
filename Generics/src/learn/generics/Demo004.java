package learn.tutorials.generics;

/**
 * <ul>
 * <b>Multiple bounds</b>
 * <li><T extends B1 & B2 & B3></li>
 * <li>A type variable with multiple bounds is a subtype of all the types listed
 * in the bound.</li>
 * <li>If one of the bounds is a class, it must be specified first. For example:
 * Class A { } interface B { } interface C { } class D &lt;T extends A & B &
 * C&gt; { } If bound A is not specified first, you get a compile-time error:
 * class D &lt;T extends B & A & C&gt; { } // compile-time error</li>
 * <li>You can provide only one class in the bound</li>
 * </ul>
 * 
 * @author saurabh.kedia
 *
 */
public class Demo004<T extends Class1 & Interface1 & Interface2> {

	public static void main(String[] args) {
		/*
		 * Create object of Demo004 passing Class2 as type argument
		 */
		Demo004<Class2> obj1 = new Demo004<>();
		/*
		 * Create object of Class2 and pass it to the method of obj1
		 */
		Class2 obj2 = new Class2();
		obj2.str = "Hello World";
		obj1.printObject(obj2);
	}

	public void printObject(T t) {
		System.out.println(t.toString());
	}

}

/**
 * Class2 extends Class1 and implements Interface1 and Interface2 so it is the
 * ideal type argument for Demo004 class which takes multiple bound type
 * argument
 * 
 * @author saurabh.kedia
 *
 */
class Class2 extends Class1 implements Interface1, Interface2 {
	public String str;

	@Override
	public String toString() {
		return "Class2 [str=" + str + "]";
	}
}

class Class1 {
}

interface Interface1 {
}

interface Interface2 {
}