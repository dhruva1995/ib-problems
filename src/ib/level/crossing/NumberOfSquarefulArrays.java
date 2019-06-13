package ib.level.crossing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class NumberOfSquarefulArrays {
	
	
	public static void main(String[] args) {
		
		System.out.println(
				
				new NumberOfSquarefulArrays()
					.solve(new ArrayList<>(Arrays.asList(428, 56, 88, 12)))
				
				
				
				
				
				
				
				);
		
		
	}
	
	

	private int count = 0;
	
    public int solve(ArrayList<Integer> A) {
    	
    	if(A.size() < 2) {
    		return 0;
    	}
    	
    	Collections.sort(A);
    	
    	solveHelper(A, 0, true);
    	
    	return count;
    	
    }
    
    private void solveHelper(ArrayList<Integer> avaiable, int prevSelection, boolean isStart) {
    	if(avaiable.isEmpty()) {
    		count++;
    	} else {
    		for(int i = 0; i < avaiable.size();) {
    			int choosen = avaiable.remove(i);
    			if(formsPerfectSquare(prevSelection + choosen) || isStart) {
    				solveHelper(avaiable, choosen, false);
    			} 
    			avaiable.add(i, choosen);
    			while (i < avaiable.size() && avaiable.get(i) == choosen) {
					i++;
				}
    		}
    	}
    } 
	
	private boolean formsPerfectSquare(int num) {
		int result = (int)Math.sqrt(num);
		return result * result == num;
		
	}
    
    
}
