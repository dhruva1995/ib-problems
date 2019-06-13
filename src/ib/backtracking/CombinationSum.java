package ib.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class CombinationSum {
	
	public static void main(String[] args) {
		new CombinationSum().combinationSum(new ArrayList<>(Arrays.asList(1)), 1).forEach(System.out::println);
		
	}
	

	public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
		ArrayList<Integer> input = A.stream().distinct().sorted().collect(Collectors.toCollection((ArrayList::new)));
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		
		combinationSumHelper(result, input, B, new LinkedList<>());
		
		return result;
	}

	private void combinationSumHelper(ArrayList<ArrayList<Integer>> result, List<Integer> numbersToChooseFrom,
			int target, LinkedList<Integer> prevSelection) {
		
		if(target == 0) {
			result.add(new ArrayList<>(prevSelection));
		} else {
			for(int i = 0; i < numbersToChooseFrom.size() && numbersToChooseFrom.get(i) <= target; i++) {
				int numSelected = numbersToChooseFrom.get(i);
				prevSelection.addLast(numSelected);
				combinationSumHelper(result, numbersToChooseFrom.subList(i, numbersToChooseFrom.size()), target - numSelected , prevSelection);
				prevSelection.removeLast();
			}
		}
		
		
	}

}
