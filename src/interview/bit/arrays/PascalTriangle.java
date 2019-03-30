package interview.bit.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class PascalTriangle {

	
	public static void main(String[] args) {
		
		new PascalTriangle().solve(5)
					.forEach(System.out::println);
		
	}
	
	public ArrayList<ArrayList<Integer>> solve(int A) {
		
		if(A == 0) {
			return new ArrayList<>();
		}
		
		if(A == 1) {
			ArrayList<ArrayList<Integer>> core = new ArrayList<>();
			core.add(new ArrayList<>(Arrays.asList(1)));
			return core;
		}
		
		ArrayList<ArrayList<Integer>> base = solve(A - 1);
		
		ArrayList<Integer> prev = base.get(base.size() - 1);
		
		ArrayList<Integer> currentRow = new ArrayList<>();
		currentRow.add(1);
		for(int i = 1; i < A - 1; i++) {
			currentRow.add(prev.get(i) + prev.get(i - 1));
		}
		currentRow.add(1);
		
		base.add(currentRow);
		
		return base;
		
    }
	
}
