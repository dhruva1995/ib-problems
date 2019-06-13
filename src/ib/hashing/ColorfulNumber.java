package ib.hashing;

import java.util.Arrays;
import java.util.HashSet;

public class ColorfulNumber {

	
	public static void main(String[] args) {
		System.out.println(new ColorfulNumber().colorful(3456));
	}
	
	
	public int colorful(int A) {
        int[] input = convertIntoArray(A);
        
        HashSet<Long> products = new HashSet<>();
        
        for(int len = 1; len < input.length; len++) {
        	long prevProduct = Arrays.stream(input, 0, len).asLongStream().reduce(1, (a, b) -> a * b);
        	if(products.contains(prevProduct)) {
    			return 0;
    		} else {
    			products.add(prevProduct);
    		}
        	for(int start = 1; start + len <= input.length; start++) {
        		if(input[start - 1] != 0) {
        			prevProduct /= input[start - 1];
        		}
        		prevProduct *= input[len + start - 1];
        		if(products.contains(prevProduct)) {
        			return 0;
        		} else {
        			products.add(prevProduct);
        		}
        	}
        }
        return 1;
        
        
    }

	private int[] convertIntoArray(int a) {
		return Integer.toString(a).chars().map(c -> c - '0').toArray();
	}
	
	
}
