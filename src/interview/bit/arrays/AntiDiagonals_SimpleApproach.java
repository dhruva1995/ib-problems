package interview.bit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AntiDiagonals_SimpleApproach {

	public static void main(String[] args) {
		
		
		
		
		
		 new AntiDiagonals_SimpleApproach().diagonal( 
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
		ArrayList<ArrayList<Integer>> result = 
				IntStream.range(0, noOfDiagonals)
					.mapToObj(i -> new ArrayList<Integer>())
					.collect(Collectors.toCollection(ArrayList::new));
										
		for(int i = 0;i < A.size(); i++) {
			
			for(int j = 0; j < A.get(i).size(); j++) {
				
				result.get(i + j).add(A.get(i).get(j));
				
			}
			
			
		}
		
		
		
		return result;
		
	}
	
}
