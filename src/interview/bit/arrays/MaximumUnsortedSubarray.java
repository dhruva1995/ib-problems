package interview.bit.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumUnsortedSubarray {
	
	public static void main(String[] args) {
		System.out.println(new MaximumUnsortedSubarray().subUnsort(new ArrayList<>(
				Arrays.asList(
						
						3, 5, 5, 6, 5, 10, 6, 7
						
						
						)
				
				
				
				)));
	}
	
	public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
		int i = 0, j = A.size() - 1;
		
		while((i + 1) < A.size() && A.get(i + 1) >= A.get(i)) {
			i++;
		}
		
		while((j - 1) >= 0 && A.get(j) >= A.get(j - 1)) {
			j--;
		}
		
		if(i >= j) {
			return new ArrayList<>(Arrays.asList(-1));
		}
		
		
		int max = A.get(i), min = max;
		
		for(int walk = i + 1; walk <= j; walk++) {
			max = Math.max(max, A.get(walk));
			min = Math.min(min, A.get(walk));
		}
		
		
		
		while(i >= 0 && A.get(i) > min) {
			i--;
		}
		
		while(j < A.size() && A.get(j) < max) {
			j++;
		}
		
		return new ArrayList<>(Arrays.asList(++i, --j));
		
    }
}
