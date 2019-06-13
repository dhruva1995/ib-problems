package ib.level.crossing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		System.out.println(
				new LongestConsecutiveSequence().
					longestConsecutive(Arrays.asList(1, 3, 7, 10))
				
				
				
				
				
				);
		
		
	}
	
	
    public int longestConsecutive(final List<Integer> A) {
    	HashSet<Integer> nums = new HashSet<>(A);
    	
    	int champConsecutiveLen = 0;
    	
    	while(!nums.isEmpty()) {
    		int currentConsecutivelEn = removeTheConsecutiveNumsForTheHashSet(nums, nums.iterator().next());
    		champConsecutiveLen = Math.max(champConsecutiveLen, currentConsecutivelEn);
    		
    	}
    	return champConsecutiveLen;
    	
    }
	
    private int removeTheConsecutiveNumsForTheHashSet(HashSet<Integer> nums, int num) {
    	
    	if(!nums.contains(num)) {
    		return 0;
    	} else {
    		long count = 1, left = num - 1, right = num + 1;
    		nums.remove(num);
    		while(left >= Integer.MIN_VALUE && nums.contains((int)left)) {
    			nums.remove((int)left);
    			left -= 1;
    			count++;
    		}
    		while(right <= Integer.MAX_VALUE && nums.contains((int)right)) {
    			nums.remove((int)right);
    			right += 1;
    			count++;
    		}
    		
    		return (int)count;
    	}
    	
    	
    	
    }
    
}
