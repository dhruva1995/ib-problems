package ib.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;

public class Combinations {

	
	public static void main(String[] args) {
		
		new Combinations().combine(1, 1).forEach(System.out::println);
	}
	
	
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		
		combineHelper(result, 1, k, n, new LinkedList<>());
		return result;
	}

	private void combineHelper(ArrayList<ArrayList<Integer>> result, int startAt, int moreRequired, int end,
			LinkedList<Integer> selection) {
		if(moreRequired == 0) {
			result.add(new ArrayList<>(selection));
		} else {
			for(int i = startAt; i <= end - moreRequired + 1; i++) {
				selection.addLast(i);
				combineHelper(result, i + 1, moreRequired - 1, end, selection);
				selection.removeLast();
			}
		}
	}

}
