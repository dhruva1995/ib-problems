package interview.bit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AntiDiagonals {

	

	public static void main(String[] args) {
		
		
		
		
		
		 new AntiDiagonals().diagonal( 
				 Arrays.asList(
						 Arrays.asList(1, 2, 3, 4),
						 Arrays.asList(5, 6, 7, 8),
						 Arrays.asList(9, 10, 11, 12),
						 Arrays.asList(13, 14, 15, 16)
				 )
			).forEach(System.out::println);
	}
	
	public ArrayList<ArrayList<Integer>> diagonal(List<List<Integer>> A) {
		
		int noOfDiagonals = (2 * A.size()) - 1;
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		
		for(int i = 0; i < noOfDiagonals; i++) {
			ArrayList<Integer> row = new ArrayList<>();
			
			for(int r = Math.max(0, i - (A.size() - 1)); r <= Math.min(A.size() - 1, i); r++) {
				int c = i - r;
				row.add(A.get(r).get(c));
			}
			
			result.add(row);
		}
		return result;
		
		
    }
	
	
}
