package ib.two.pointers;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveDuplicatesfromSortedArrayII {

	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1, 1, 1, 2, 2, 2, 2, 3, 3, 3));
		
		new RemoveDuplicatesfromSortedArrayII().removeDuplicates(nums);
		
		System.out.println(nums);
	}
	
	
	public int removeDuplicates(ArrayList<Integer> a) {
		
		for(int i = 0; i + 1 < a.size(); i++) {
			if(a.get(i).intValue() == a.get(i + 1).intValue()) {
				int j = i + 2;
				while(j < a.size() && a.get(i).intValue() == a.get(j).intValue()) {
					j++;
				}
				
				a.subList(i+ 2, j).clear();
			}
		}
		return a.size();
    }
	
	
}
