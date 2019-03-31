package ib.bit.manipulations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MinXORvalue {
	
	public static void main(String[] args) {
		System.out.println(new MinXORvalue().findMinXor(new ArrayList<>(Arrays.asList(0, 4, 9, 7))));
	}

	public int findMinXor(ArrayList<Integer> A) {
		Collections.sort(A);
		int min = A.get(0) ^ A.get(1);
		for(int i = 1; i < A.size() - 1; i++) {
			min = Math.min(min, A.get(i) ^ A.get(i + 1));
		}
		return min;
    }
	
}
