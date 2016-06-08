package learn.tutorials.generics;

/**
 * Defining Generic methods
 * 
 * @author saurabh.kedia
 *
 */
public class Demo002 {

	public static void main(String[] args) {
		/*
		 * The method is generic not the class so we can use it for different
		 * objects using single Demo002 object.
		 */
		Demo002 obj = new Demo002();
		/*
		 * calling a method without specifying a type in angular brackets is
		 * called Type Inference
		 */
		obj.printContent("Hello World");
		obj.printContent(108);
		obj.printContent(11.0);
	}

	public <T> void printContent(T t) {
		System.out.println(t.toString());
	}
}
