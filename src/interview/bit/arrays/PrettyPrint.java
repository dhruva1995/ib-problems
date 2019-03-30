package interview.bit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrettyPrint {

	public static void main(String[] args) {
		new PrettyPrint().prettyPrint(6).forEach(System.out::println);
	}
	
    public ArrayList<ArrayList<Integer>> prettyPrint(int A) {
    	int[][] result = new int[(2 * A) - 1][];
    	for(int i = 0; i < (A * 2) - 1; i++) {
    		result[i] = new int[(2 * A) - 1];
    	}
    	
    	
    	
    	
    	for(int i = 1; i <= A; i++) {
    		int top = i - 1, bottom = (2 * A) - 1 - 1 - top, left = top, right = bottom;
    		for(int c = left; c <= right; c++) {
    			result[top][c] =  A - top;
    			result[bottom][c] = A - top;
    		}
    		
    		for(int r = top; r <= bottom; r++) {
    			result[r][left] = A - left;
    			result[r][right] = A - left;
    		}
    		
    		
    		
    	}
		return Arrays.stream(result)
					.map(array -> conertIntArrayToArrayList(array))
					.collect(Collectors.toCollection(ArrayList::new));
    }

	private ArrayList<Integer> conertIntArrayToArrayList(int[] array) {
		return IntStream.of(array)
			.boxed()
			.collect(Collectors.toCollection(ArrayList::new));
	}
	
}
