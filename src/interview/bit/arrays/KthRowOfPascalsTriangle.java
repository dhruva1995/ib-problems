package interview.bit.arrays;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class KthRowOfPascalsTriangle {

	
	public static void main(String[] args) {
		System.out.println(new KthRowOfPascalsTriangle().getRow(0));
	}
	
	public ArrayList<Integer> getRow(int A) {

		int[] result = new int[A + 1];
		
		for(int i = 0; i <= A; i++) {
			process(result, i);
		}
		
		return IntStream.of(result).boxed().collect(Collectors.toCollection(ArrayList::new));
	
	}

	private void process(int[] result, int i) {
		
		result[i--] = 1;
		
		for(;i > 0; i--) {
			result[i] = result[i] + result[i - 1];
		}
		
	}
	
	
	
}
