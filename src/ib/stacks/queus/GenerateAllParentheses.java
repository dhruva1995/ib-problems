package ib.stacks.queus;

import java.util.Stack;

public class GenerateAllParentheses {

	
	public static void main(String[] args) {
		System.out.println(new GenerateAllParentheses().isValid("(){}[][][{}{}()]"));
	}
	
	
	public int isValid(String input) {
		
		Stack<Character> stack = new Stack<>();
		
		for(char c : input.toCharArray()) {
			
			if(isOpen(c)) {
				stack.push(c);
			} else if(isClose(c)) {
				if(stack.isEmpty() || !isValidPair(stack.peek(), c)) {
					return 0;
				} else {
					stack.pop();
				}
			}
		}
		return stack.isEmpty() ? 1 : 0;
    }
	
	private boolean isOpen(char c) {
		return c == '(' || c == '{' || c == '[';
	}
	
	private boolean isClose(char c) {
		return c == ')' || c == ']' || c == '}';
	}
	
	private boolean isValidPair(char open, char close) {
		switch(open) {
		case '(' :
			return close == ')';
		case '[' :
			return close == ']';
		case '{' :
			return close == '}';
		}
		return false;
	}
}
