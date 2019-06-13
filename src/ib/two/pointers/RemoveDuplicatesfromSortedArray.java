package ib.two.pointers;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveDuplicatesfromSortedArray {

	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1,2));
		new RemoveDuplicatesfromSortedArray().removeDuplicates(nums);
		System.out.println(nums);
		
	}
	
	
	public int removeDuplicates(ArrayList<Integer> a) {

		
		for(int i = 0; i < a.size(); i++) {
			int j = i + 1;
			for(; j < a.size() && (int)a.get(j) == (int)a.get(i); j++);
			
			a.subList(i + 1, j).clear();
			
			
			
			
		}
		return a.size();
		
	}

}
