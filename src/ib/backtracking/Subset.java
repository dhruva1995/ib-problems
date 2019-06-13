package ib.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Subset {

	
	public static void main(String[] args) {
		new Subset().subsets(new ArrayList<>(Arrays.asList(3, 1, 4, 4, 2))).forEach(System.out::println);
	}
	
	
	public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		Collections.sort(A);
		result.add(new ArrayList<>());
		addSubSet(result, new LinkedList<>(A), new LinkedList<>());
		return result;
	}

	public void addSubSet(ArrayList<ArrayList<Integer>> result, LinkedList<Integer> available,
			LinkedList<Integer> prev) {
		if (!available.isEmpty()) {
			int current = available.removeFirst();

			prev.addLast(current);

			result.add(new ArrayList<>(prev));
			
			addSubSet(result, available, prev);
			
			prev.removeLast();
			
			addSubSet(result, available, prev);
			
			available.addFirst(current);
		}
	}

}
