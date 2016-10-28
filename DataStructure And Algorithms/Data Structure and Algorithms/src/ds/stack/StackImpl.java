package ds.stack;

public class StackImpl {

	public static void main(String[] args) throws Exception {
		// Simple stack Implementation
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(4);
		stack.push(2);
		stack.push(8);
		stack.push(3);
		stack.push(6);
		stack.push(9);
		stack.push(7);

		// while (stack.peek() != null) {
		// System.out.println(stack.pop());
		// }
		// System.out.println();

		// Infix to Postfix expression.
		String infix = "a+b*(c^d-e)^(f+g*h)-i";
		System.out.println("Infix : " + infix);
		System.out.println("Postfix : " + StackAlgortihms.infixToPostFixExpression(infix));
		System.out.println();

		// Evaluate postfix expression
		String postfix = "231*+9-";
		System.out.println("Postfix : " + postfix);
		System.out.println("Result : " + StackAlgortihms.evaluatePostfixExpression(postfix));

		// recursive stack sort
		Stack<Integer> sortStack = StackAlgortihms.emptyStack(stack);
		System.out.println(sortStack);
	}

}
