package ib.stacks.queus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram {

	public static void main(String[] args) {
		System.out.println(
				
				new LargestRectangleInHistogram()
					.largestRectangleArea(new ArrayList<>(
							
							Arrays.asList(2,1,5,6,2,3)
							
							
							))
				
				
				
				);
		
	}
	
	
	public int largestRectangleArea(ArrayList<Integer> A) {
		A.add(0, -1);
		A.add(-1);
		int champArea = 0;
		int[] nextMins = new int[A.size()], prevMins = new int[A.size()];
		prevMins[0] = -1;
		nextMins[nextMins.length - 1] = nextMins.length;
		
		Stack<Integer> prevMinIndices = new Stack<>();
		prevMinIndices.push(0);
		for(int i = 1; i < A.size() - 1; i++) {
			while(A.get(prevMinIndices.peek()) >= A.get(i)) {
				prevMinIndices.pop();
			}
			prevMins[i] = prevMinIndices.peek();
			prevMinIndices.push(i);
		}
		
		Stack<Integer> nextMinIndices = new Stack<>();
		nextMinIndices.push(A.size() - 1);
		for(int i = A.size() - 2; i > 0; i--) {
			while(A.get(nextMinIndices.peek()) >= A.get(i)) {
				nextMinIndices.pop();
			}
			nextMins[i] = nextMinIndices.peek();
			nextMinIndices.push(i);
		}
		for(int i = 1; i < A.size() - 1; i++) {
			champArea = Math.max(champArea, (nextMins[i] - prevMins[i] - 1) * A.get(i));
		}
		return champArea;
	}
}
