package ds.stack;

public class StackAlgortihms {

	/**
	 * Converts infix to postfix expression
	 * 
	 * @param infixExpression
	 * @return
	 * @throws Exception
	 */
	public static String infixToPostFixExpression(String infixExpression) throws Exception {
		String postfix = "";
		Stack<Character> stackOfChars = new Stack<>();
		int infixExpressionLength = infixExpression.length();
		// scan all the characters of the given infix expression
		for (int i = 0; i < infixExpressionLength; i++) {
			char current = infixExpression.charAt(i);
			// if it is an operand print it
			if (!isOperator(current)) {
				postfix += current;
			} else {
				// if current operator except ( or ) and the precedence is lower
				// than the top
				// of stack then pop the element
				while (current != ')' && current != '(' && stackOfChars.peek() != null && stackOfChars.peek() != '('
						&& precedence(stackOfChars.peek()) >= precedence(current)) {
					postfix += stackOfChars.pop();
				}
				// if current operator is ) and stack top is anything but (
				while (current == ')' && stackOfChars.peek() != '(') {
					postfix += stackOfChars.pop();
				}
				// if current operator is anything but ( push in the stack
				if (current != ')')
					stackOfChars.push(current);
				// else pop the stack
				else
					stackOfChars.pop();
			}
		}
		// pop the remaining characters from stack
		while (stackOfChars.peek() != null)
			postfix += stackOfChars.pop();
		return postfix;
	}

	public static int evaluatePostfixExpression(String postfixExpression) throws Exception {
		Stack<Integer> stackOfInt = new Stack<>();
		int result = 0;
		for (int i = 0; i < postfixExpression.length(); i++) {
			char op = postfixExpression.charAt(i);
			// if op is an operand push to stack
			if (!isOperator(op))
				stackOfInt.push(Character.getNumericValue(op));
			// if op is operator pop two values from stack perform the operation
			// and push the value back to stack
			else {
				int op1 = stackOfInt.pop();
				int op2 = stackOfInt.pop();
				result = performOperation(op2, op1, op);
				stackOfInt.push(result);
			}
		}
		return result;
	}

	public static <T extends Comparable<T>> Stack<T> sortStack(Stack<T> stack) throws Exception {
		if (stack.peek() == null)
			return stack;
		T t = stack.pop();
		Stack<T> stackSorted = sortStack(stack);
		stackSorted = sort(stackSorted, t);
		return stackSorted;
	}

	private static <T extends Comparable<T>> Stack<T> sort(Stack<T> stackSorted, T t) throws Exception {
		if (stackSorted.peek() == null)
			stackSorted.push(t);
		else if (t.compareTo(stackSorted.peek()) >= 0)
			stackSorted.push(t);
		else {
			T t2 = stackSorted.pop();
			stackSorted = sort(stackSorted, t);
			stackSorted.push(t2);
		}
		return stackSorted;
	}

	private static int performOperation(int op1, int op2, char op) {
		switch (op) {
		case '+':
			return op1 + op2;
		case '-':
			return op1 - op2;
		case '*':
			return op1 * op2;
		case '/':
			return op1 / op2;
		case '^':
			return op1 ^ op2;
		}
		return 0;
	}

	private static int precedence(Character op) {
		if (op == null)
			return -1;
		switch (op) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		case '(':
		case ')':
			return 4;
		default:
			return -1;
		}
	}

	private static boolean isOperator(Character op) {
		if (op == '+' || op == '-' || op == '*' || op == '/' || op == '^' || op == '(' || op == ')')
			return true;
		return false;
	}
}
