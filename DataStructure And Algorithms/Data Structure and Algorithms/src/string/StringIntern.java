package algorithms.string;

public class StringIntern {

	public static void main(String[] args) {
		String x = "Saurabh";
		char[] chars = { 'S', 'a', 'u', 'r', 'a', 'b', 'h' };
		String y = new String(chars);
		System.out.println(x == y);
		y.intern();
		System.out.println(x == y);
		System.out.println(x == y.intern());
	}

}
