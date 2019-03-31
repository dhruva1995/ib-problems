package ib.bit.manipulations;

import java.util.Arrays;
import java.util.List;

public class SingleNumber {

	public int singleNumber(final List<Integer> A) {
		int[] bits = new int[32];
		
		for(int a : A) {
			for(int i = 0; i < 32; i++) {
				bits[i] += a & 1;
				a >>= 1;
			}
		}
		
		int result = 0;
		for(int i = 31; i >= 0; i--) {
			result |= bits[i] % 2;
			if(i > 0) {
				result <<= 1;
			}
			
		}
		return result;
    }
	
	public static void main(String[] args) {
		System.out.println(new SingleNumber().singleNumber(Arrays.asList(-1, 22, 33, 22, 33)));
	}
	
}
