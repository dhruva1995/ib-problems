package ib.stacks.queus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class EvaluateExpression {
	
	
	public static void main(String[] args) {
		System.out.println(new EvaluateExpression().evalRPN(new ArrayList<>(
				Arrays.asList(
						"4", "13", "5", "/", "+"
						
						)
				
				)));
	}

	public int evalRPN(ArrayList<String> A) {
		
		Stack<Integer> stack = new Stack<>();
		
		for(String token : A) {
			
			if(isOperand(token)) {
				int num2 = stack.pop();
				int num1 = stack.pop();
				stack.push(evaluate(num1, num2, token));
			} else {
				stack.push(Integer.parseInt(token));
			}
		}
		return stack.pop();
    }

	private boolean isOperand(String token) {
		switch(token) {
		case "*" :
		case "+" :
		case "-" :
		case "/" :
			return true;
		}
		return false;
	}
	
	private int evaluate(int num1, int num2, String operation) {
		switch(operation) {
		case "*" :
			return num1 * num2;
		case "+" :
			return num1 + num2;
		case "-" :
			return num1 - num2;
		case "/" :
			return num1 / num2;
		}
		return -1;
	}
	
}
