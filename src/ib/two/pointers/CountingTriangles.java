package ib.two.pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CountingTriangles {

	private static final int MOD = 1_000_000_007;
	
	
	public static void main(String[] args) {
		System.out.println(new CountingTriangles().nTriang(new ArrayList<Integer>(Arrays.asList(1, 1, 2, 3))));
	}
	
	public int nTriang(ArrayList<Integer> A) {
		//a < b < c; a + b > c
		long count = 0;
		Collections.sort(A);
        for(int a = 0; a < A.size() - 2; a++) {
        	int b = a + 1, c = A.size();
        	do {
        		c--;
        	} while(c > b &&A.get(a) + A.get(b) <= A.get(c));
        	count += c - b;
        	b++;
        	for(; b < A.size() - 1; b++) {
        		while(c < A.size() && A.get(a) + A.get(b) > A.get(c)) {
        			c++;
        		}
        		c--;
        		count += c - b;
        	}
        }
		return (int)(count % MOD);
		
    }
	
	
}
