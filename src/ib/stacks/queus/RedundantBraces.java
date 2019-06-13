package ib.stacks.queus;

import java.util.Stack;

public class RedundantBraces {

	public static void main(String[] args) {
		
		System.out.println(new RedundantBraces().braces("(((a*b)+(b*c) + g))"));
		
	}
	
	
	public int braces(String input) {
		
		Stack<Boolean> stack = new Stack<>();
		
		for(char c : input.toCharArray()) {
			if(c == '(') {
				stack.push(false);
			}
			
			if(c == '+' || c == '-' || c == '*' || c == '/') {
				if(!stack.isEmpty()) {
					stack.pop();
					stack.push(true);
				}
				
			}
			
			
			if(c == ')') {
				if(stack.isEmpty()) {
					return 1;
				}
				boolean properExp = stack.pop();
				if(!properExp) {
					return 1;
				}
				
			}
			
		}
		
		return stack.isEmpty() ? 0 : 1;
		
    }
	
	
	
	
}
