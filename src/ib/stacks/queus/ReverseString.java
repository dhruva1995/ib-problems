package ib.stacks.queus;

import java.util.Stack;

public class ReverseString {
	public String reverseString(String A) {
		
		Stack<Character> stack = new Stack<>();
		
		char[] result = new char[A.length()];
		
		for(char c : A.toCharArray()) {
			stack.push(c);
		}
		
		for(int i = 0; i < A.length(); i++) {
			result[i] = stack.pop();
		}
		
		return new String(result);
    }

}
