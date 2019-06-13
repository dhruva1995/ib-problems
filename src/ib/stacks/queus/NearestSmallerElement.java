package ib.stacks.queus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerElement {

	public static void main(String[] args) {

		System.out.println(new NearestSmallerElement().prevSmaller(new ArrayList<>(
					Arrays.asList(
							6, 5, 3, 9, 2, 0, 7
					)
				)));

	}

	public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {

		Stack<Integer> stack = new Stack<>();

		ArrayList<Integer> result = new ArrayList<>();

		for (int i : A) {

			while (!stack.isEmpty() && stack.peek() >= i) {
				stack.pop();
			}

			if (!stack.isEmpty()) {
				result.add(stack.peek());
			} else {
				result.add(-1);
			}
			stack.push(i);
		}
		return result;
	}

}
