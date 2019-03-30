package math;

import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class SortedPermutationRank {

	public static void main(String[] args) {
		System.out.println(new SortedPermutationRank().findRank("DTNGJPURFHYEW"));
	}
	
	
	public int findRank(String A) {
		TreeSet<Character> allChars = 
				A.chars()
				.mapToObj(i -> new Character((char)i))
				.collect(Collectors.toCollection(TreeSet::new));
		
		long count = 1;
		for(int examIndex = 0; examIndex < A.length() - 1; examIndex++) {
			final int currIndex = examIndex;
			long noOfPreNums = allChars.stream()
				.filter(exam -> exam < A.charAt(currIndex))
				.count();
			count += (noOfPreNums * factorial(A.length() - examIndex - 1)) % 1000003;
			count %= 1000003;
			allChars.remove(A.charAt(currIndex));	
		}
		return (int)count;
		
    }

	private int factorial(int i) {
		return (int)(LongStream.rangeClosed(1, i)
			.reduce(1, (a, b) -> (a * b) % 1000003) % 1000003);
	}
	
	
}
