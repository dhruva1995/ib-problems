package ib.level.crossing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AllUniquePermutations {

	public static void main(String[] args) {
		new AllUniquePermutations().permute(new ArrayList<>(Arrays.asList(1, 1, 2, 2))).forEach(System.out::println);
		
	}
	
	
	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
		
		Collections.sort(A);
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		
		addNewPermutation(A, result, new ArrayList<>());
		
		return result;
		
    }
	
	private void addNewPermutation(ArrayList<Integer> available, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> prevChoosen) {
		
		if(available.isEmpty()) {
			result.add(new ArrayList<>(prevChoosen));
		} else {
			for(int i = 0; i < available.size();) {
				int choosen = available.remove(i);
				prevChoosen.add(choosen);
				
				addNewPermutation(available, result, prevChoosen);
				
				prevChoosen.remove(prevChoosen.size() - 1);
				available.add(i, choosen);
				
				while(i < available.size() && available.get(i) == choosen) {
					i++;
				}
				
			}
			
			
			
			
		}
		
		
	}
}
