package ib.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumII {
	
	public static void main(String[] args) {
		new CombinationSumII().combinationSum(new ArrayList<>(Arrays.asList(10,1,2,7,6,1,5)), 8).forEach(System.out::println);
	}

	public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
		Collections.sort(a);
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		combinationSumHelper(result, a, b, new LinkedList<>());
		return result;
	}

	private void combinationSumHelper(ArrayList<ArrayList<Integer>> result, List<Integer> available, int target,
			LinkedList<Integer> choosen) {
		if (target == 0) {
			result.add(new ArrayList<>(choosen));
		} else {
			int i = 0; 
			while (i < available.size() && available.get(i) <= target) {
				int current = available.get(i);
				choosen.addLast(current);
				combinationSumHelper(result, available.subList(i + 1, available.size()), target - current, choosen);
				choosen.removeLast();
				while(i < available.size() && available.get(i) == current) {
					i++;
				}
			}
		}
	}

}
