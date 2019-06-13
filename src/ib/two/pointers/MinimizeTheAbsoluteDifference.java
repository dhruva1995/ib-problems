package ib.two.pointers;

import java.util.ArrayList;
import java.util.Arrays;

public class MinimizeTheAbsoluteDifference {


	public static void main(String[] args) {
		System.out.println(new MinimizeTheAbsoluteDifference().solve(
				new ArrayList<>(Arrays.asList(1, 4, 8, 9, 10)),
				new ArrayList<>(Arrays.asList(6, 9, 15)),
				new ArrayList<>(Arrays.asList(2, 3, 6, 6, 9))
				
				
				
				
				));
		
	}
	
	public int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
		int a = 0, b = 0, c = 0;
		int champ = calculateMinAbsDiff(A.get(0), B.get(0), C.get(0));
		while(a < A.size() && b < B.size() && c < C.size()) {
			champ = Math.min(champ , calculateMinAbsDiff(A.get(a), B.get(b), C.get(c)));
			
			int minList = minIndex(A.get(a), B.get(b), C.get(c));
			if(minList == 0) {a++;}
			else if(minList == 1) {b++;}
			else {c++;}
			
			
		}
		
		return champ;
    }
	
	private int minIndex(int a, int b, int c) {
		if(a <= b && a <= c) {
			return 0;
		} else if(b <= a && b <= c) {
			return 1;
		}
		return 2;
		
	}
	
	
	private int calculateMinAbsDiff(int a, int b, int c) {
		return Math.max(a, Math.max(b, c)) - Math.min(a, Math.min(b, c));
	}
	
	
}
