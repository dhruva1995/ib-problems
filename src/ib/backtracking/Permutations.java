package ib.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutations {
	
	public static void main(String[] args) {
		
		new Permutations().permute(new ArrayList<>(Arrays.asList(1, 2))).forEach(System.out::println);
		
	}
	

	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		permuteHelper(result, nums, new ArrayList<>());
		
		return result;
		
	}

	private void permuteHelper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> available,
			ArrayList<Integer> prevChoosen) {
		if (available.isEmpty()) {
			result.add(new ArrayList<>(prevChoosen));
			return;
		} else {

			for (int i = 0; i < available.size(); i++) {
				int current = available.remove(i);

				prevChoosen.add(current);

				permuteHelper(result, available, prevChoosen);
				
				prevChoosen.remove(prevChoosen.size() - 1);
				
				available.add(i, current);

			}
		}

	}

}
