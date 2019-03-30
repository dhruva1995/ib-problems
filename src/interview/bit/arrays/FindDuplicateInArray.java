package interview.bit.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicateInArray {

	public static void main(String[] args) {
		System.out.println(new FindDuplicateInArray().repeatedNumber(Arrays.asList(3, 4, 1, 4, 1, 5, 5)));
	}
	
	public int repeatedNumber(final List<Integer> input) {
		int width = (int)Math.ceil(Math.sqrt(input.size() - 1));
		TreeMap<Integer, Long> count = input.stream()
			.collect(Collectors.groupingBy(n -> (n - 1) / width, TreeMap::new, Collectors.counting())); 
		
		Optional<Entry<Integer, Long>> key = count.entrySet()
			.stream()
			.limit(count.size() - 1)
			.filter(e -> e.getValue() > width)
			.findAny();
		
		if(key.isPresent()) {
			int noOfCount = key.get().getKey();
			int start = (noOfCount * width) + 1, end = start + width - 1;
			return findTheRepeatedElementInWidthOf(start, end, input);
		} else {
			return findTheRepeatedElementInWidthOf(((count.size() - 1) * width) + 1, input.size() - 1, input);
		}
    }

	private int findTheRepeatedElementInWidthOf(int start, int end, List<Integer> input) {
		 Optional<Entry<Integer, Long>> result = input.stream()
			.filter(num -> num >= start && num <= end)
			.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
			.entrySet()
			.stream()
			.filter(e -> e.getValue() > 1)
			.findAny();
		 
		return result.isPresent() ? result.get().getKey() : -1;
	}
	
	
}
