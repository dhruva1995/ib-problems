package ib.two.pointers;

import java.util.ArrayList;
import java.util.Arrays;

public class ContainerWithMostWater {
	
	
	public static void main(String[] args) {
		System.out.println(new ContainerWithMostWater().maxArea(new ArrayList<>(Arrays.asList(1, 1, 2, 4))));
	}
	
	public int maxArea(ArrayList<Integer> A) {
		
		int start = 0, end = A.size() - 1;
		
		int champArea = (end - start) * Math.min(A.get(start), A.get(end)); 
		
		while(start < end) {
			if (A.get(start) < A.get(end)) {
				int sit = start;
				while (start < end && A.get(sit) >= A.get(start)) {
					start++;
				}
			} else {
				int sit = end;
				
				while (end > start && A.get(sit) >= A.get(end)) {
					end--;
				}
			}
			
			champArea = Math.max((end - start) * Math.min(A.get(start), A.get(end)), champArea);
		}
		return champArea;
		
    }
	

}
