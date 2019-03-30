package interview.bit.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Flip {
	
	
	public static void main(String[] args) {
		System.out.println(new Flip().flip("0011101"));
		
	}
	

    public ArrayList<Integer> flip(String input) {
        
        
        
        int i = 0;
        while(i < input.length() && input.charAt(i) == '1') {
            i++;
        }
        int champStart, champEnd, start;
        int champSum, temporarySum;
        
        if(i == input.length()) {
            return new ArrayList<>();
        }
        
        champStart = champEnd = start = i;
        champSum = temporarySum = 1;
        i++;
        while(i < input.length()) {
            int test = input.charAt(i) == '1' ? -1 : 1;
            
            if (temporarySum + test < test) {
                temporarySum = test;
                start = i;
                
            } else {
            	temporarySum += test;
            }
            
            
            if(temporarySum > champSum) {
                champSum = temporarySum;
                champStart = start;
                champEnd = i;
            }
            
            i++;
        }
            
            
        return new ArrayList<>(Arrays.asList(champStart + 1, champEnd + 1));
        
        
    }
	
	
}
