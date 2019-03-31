package ib.bit.manipulations;

import java.util.ArrayList;
import java.util.Arrays;

public class DifferentBitsSumPairwise {
	
	
	public int cntBits(ArrayList<Integer> A) {
		final int MOD = 1_000_000_007;
        int[] countOfNumsWhoseBitIsSet = new int[32];
        for(int a : A) {
        	for(int i = 0; i < 31; i++) {
        		if((a & 1) == 1) {
        			countOfNumsWhoseBitIsSet[i]++;
        		}
        		a >>= 1;
        	}
        	
        	
        }
        
        return (int)((Arrays.stream(countOfNumsWhoseBitIsSet)
        	.asLongStream()
        	.map(i -> (i * (A.size() - i)) % MOD)
        	.sum() * 2) % MOD);
    }
	
	public static void main(String[] args) {
		
		System.out.println(new DifferentBitsSumPairwise().cntBits(new ArrayList<> (Arrays.asList(Integer.MAX_VALUE, -2147483648 ))));
		
	}

}
