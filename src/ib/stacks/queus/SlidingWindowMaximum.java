package ib.stacks.queus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class SlidingWindowMaximum {

	public static void main(String[] args) {
		
		System.out.println(new SlidingWindowMaximum().slidingMaximum(new ArrayList<>(
				Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)
				
				), 1));
		
	}
	
	
	public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
		ArrayList<Integer> result = new ArrayList<>();
		if(B >= A.size()) {
			result.add(A.get(findMaxsIndex(A, 0, A.size())));
		} else {
			int[] nextMax = new int[A.size()];
			Arrays.fill(nextMax, -1);
			
			Stack<Integer> stack = new Stack<>();
			stack.push(A.size() - 1);
			for(int i = A.size() - 2; i >= 0; i--) {
				while(!stack.isEmpty() && A.get(stack.peek()) < A.get(i)) {
					stack.pop();
				}
				if(!stack.isEmpty()) {
					nextMax[i] = stack.peek();
				}
				stack.push(i);
			}
			
			int maxPointer = findMaxsIndex(A, 0, B);
			result.add(A.get(maxPointer));
			for(int i = 1; i + B <= A.size(); i++) {
				if(maxPointer < i) {
					maxPointer = findMaxsIndex(A, i, i + B);
				} else {
					if(nextMax[maxPointer] < i + B && nextMax[maxPointer] >= i) {
						maxPointer = nextMax[maxPointer];
					}
				}
				result.add(A.get(maxPointer));
			}
			
		}
		return result;
    }
	
	private int findMaxsIndex(List<Integer> nums, int startInc, int endExc) {
		int minIndex = startInc;
		for(int i = startInc + 1; i < endExc; i++) {
			if(nums.get(i) > nums.get(minIndex)) {
				minIndex = i;
			}
		}
		return minIndex;
	}
	
}
