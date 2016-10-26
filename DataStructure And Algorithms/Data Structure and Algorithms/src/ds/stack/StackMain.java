package ds.stack;

public class StackMain {

	public static void main(String[] args) throws Exception {
		Stack<String> stack = new Stack<>();
		stack.push("Saurabh");
		stack.push("Kedia");
		stack.push("Implemented");
		stack.push("Stack");
		
		while(stack.peek() != null){
			System.out.println(stack.pop());
		}
	}

}
