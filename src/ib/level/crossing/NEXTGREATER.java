package ib.level.crossing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

public class NEXTGREATER {

	public ArrayList<Integer> nextGreater(ArrayList<Integer> A) {
		int[] result = new int[A.size()];
		result[A.size() - 1] = -1;
		Stack<Integer> stack = new Stack<>();
		stack.push(A.get(A.size() - 1));
		
		for(int i = A.size() - 2; i >= 0; i--) {
			while(!stack.isEmpty() && stack.peek() <= A.get(i)) {
				stack.pop();
			}
			if(stack.isEmpty()) {
				result[i] = -1;
			} else {
				result[i] = stack.peek();
			}
			stack.push(A.get(i));
		}
		
		return Arrays.stream(result).boxed().collect(Collectors.toCollection(ArrayList::new));
    }
	
	
}
