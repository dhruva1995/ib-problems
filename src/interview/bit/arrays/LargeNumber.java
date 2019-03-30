package interview.bit.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LargeNumber {
	
	
	public static void main(String[] args) {
		System.out.println(new LargeNumber().largestNumber(
				Arrays.asList(0, 0, 0, 0)));
	}
	

	public String largestNumber(final List<Integer> A) {
		
		//Collections.sort(A, getComparator());
		
		String result = A.stream()
			.map(r -> r.toString())
			.sorted(getComparator())
			.collect(Collectors.joining(""));
			
		
		
		int firstNonZeroChar = IntStream.range(0, result.length())
			.boxed()
			.filter(index -> result.charAt(index) != '0')
			.findFirst()
			.orElse(result.length() - 1);
		
		
		
		return result.substring(firstNonZeroChar);
		
	}

	private Comparator<String> getComparator() {
		return (String aStr, String bStr) -> {
			int aIndex = 0, bIndex = 0;
			while (aIndex < aStr.length() && bIndex < bStr.length()) {
				char aChar = aStr.charAt(aIndex), bChar = bStr.charAt(bIndex);
				if (aChar > bChar) {
					return -1;
				} else if (bChar > aChar) {
					return 1;
				}
				aIndex++;
				bIndex++;
			}
			if (aStr.length() == bStr.length()) {
				return 0;
			} else {
				
				if(aIndex == aStr.length()) {
					return getComparator().compare(aStr, bStr.substring(bIndex));
				} else {
					return getComparator().compare(aStr.substring(aIndex), bStr);
				}
				
			}
		};
	}

}
