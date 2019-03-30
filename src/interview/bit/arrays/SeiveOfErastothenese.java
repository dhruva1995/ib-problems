package interview.bit.arrays;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class SeiveOfErastothenese {
	
	
	public static void main(String[] args) {
		System.out.println(new SeiveOfErastothenese().sieve(2));
	}
	
	
    public ArrayList<Integer> sieve(int A) {
    	ArrayList<Integer> allNums = new ArrayList<>(A - 1);
    	
    	if(A < 2) {
    		return allNums;
    	}
    	
    	for(int i = 2; i <= A; i++) {
    		allNums.add(i);
    	}
    	
    	int limit = (int) Math.sqrt(allNums.size());
    	
    	for(int i = 0; i <= limit && i < allNums.size(); i++) {
    		
    		if(allNums.get(i) == -1) {
    			continue;
    		}
    		
    		int number = allNums.get(i);
    		
    		for(int j = i + number; j < allNums.size(); j += number) {
    			allNums.set(j, -1);
    		}
    	}
    	
    	return allNums.stream()
    		.filter(i -> i != -1)
    		.collect(Collectors.toCollection(ArrayList::new));
    	
    }
}
