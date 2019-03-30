package interview.bit.arrays;

import java.util.Arrays;
import java.util.List;

public class MaxAbsDiff {
	
	
	public static void main(String[] args) {
		
		System.out.println(new MaxAbsDiff().maxArr(Arrays.asList(-39, -24, 82, 95, 91, -65, 16, -76, -56, 70)));
		
		
	}
	
	
	
	public int maxArr(List<Integer> A) {
        
        
        int aPlusiMin = A.get(0);
        int aPlusiMax = A.get(0);
        int aMinusiMax = A.get(0);
        int aMinusiMin = A.get(0);

        for (int i = 1; i < A.size(); i++) {
            aPlusiMax = Math.max(aPlusiMax, A.get(i) + i);
            aPlusiMin = Math.min(aPlusiMin, A.get(i) + i);
            aMinusiMax = Math.max(aMinusiMax, A.get(i) - i);
            aMinusiMin = Math.min(aMinusiMax, A.get(i) - i);
        }
        
        
        
        
        
        return Math.max(Math.abs(aPlusiMax - aPlusiMin), Math.abs(aMinusiMax - aMinusiMin));
        
    }
}
