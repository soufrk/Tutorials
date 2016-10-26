package algorithms.string;

import java.util.Arrays;
import java.util.Stack;

import javax.naming.OperationNotSupportedException;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another
 * expression. For example:
 * 
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9; ["4", "13", "5", "/", "+"]
 * -> (4 + (13 / 5)) -> 6
 * 
 * @author KD
 *
 */
public class EvaluatePolishNotation {

	/**
	 * Stack is the simplest implementation of this problem. Whenever you
	 * encounter anything other than operator just push it in on the stack, if
	 * any operator comes pop top two elements and apply the operation on them.
	 * push the result back on the stack.
	 * 
	 * @param args
	 * @throws OperationNotSupportedException
	 */
	public static void main(String[] args) throws OperationNotSupportedException {
		String[] sourceStringArray = { "2", "1", "+", "3", "*" };
		String operators = "*+-/";
		Stack<String> stackOfString = new Stack<>();
		for (String element : sourceStringArray) {
			// anything other than operators push on the stack
			if (!operators.contains(element))
				stackOfString.push(element);
			// if any operator comes apply the appropriate operation and push
			// the resultant on the stack
			else {
				switch (element) {
				case "+":
					stackOfString.push(String
							.valueOf(Integer.valueOf(stackOfString.pop()) + Integer.valueOf(stackOfString.pop())));
					break;
				case "*":
					stackOfString.push(String
							.valueOf(Integer.valueOf(stackOfString.pop()) * Integer.valueOf(stackOfString.pop())));
					break;
				case "/":
					stackOfString.push(String
							.valueOf(Integer.valueOf(stackOfString.pop()) / Integer.valueOf(stackOfString.pop())));
					break;
				case "-":
					stackOfString.push(String
							.valueOf(Integer.valueOf(stackOfString.pop()) - Integer.valueOf(stackOfString.pop())));
					break;
				default:
					throw new OperationNotSupportedException();
				}
			}
		}
		System.out.println(Arrays.toString(sourceStringArray));
		System.out.println("Result: " + stackOfString.pop());
	}

}
