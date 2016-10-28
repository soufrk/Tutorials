package ds.stack;

public class StackImpl {

	public static void main(String[] args) throws Exception {
		// Simple stack Implementation
		Stack<String> stack = new Stack<>();
		stack.push("Hello");
		stack.push("There");
		stack.push("I");
		stack.push("Am");
		stack.push("Stack");
		stack.push("A");
		stack.push("LIFO");
		stack.push("DataStructure");

		while (stack.peek() != null) {
			System.out.println(stack.pop());
		}
		System.out.println();

		// Infix to Postfix expression.
		String infix = "a+b*(c^d-e)^(f+g*h)-i";
		System.out.println("Infix : " + infix);
		System.out.println("Postfix : " + StackAlgortihms.infixToPostFixExpression(infix));
		System.out.println();

		// Evaluate postfix expression
		String postfix = "231*+9-";
		System.out.println("Postfix : " + postfix);
		System.out.println("Result : " + StackAlgortihms.evaluatePostfixExpression(postfix));
	}

}
