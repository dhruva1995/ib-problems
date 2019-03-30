package interview.bit.arrays;

import java.util.List;
import java.util.stream.IntStream;

public class MaxDistance {

	public int maximumGap(final List<Integer> A) {
		Integer[] sortedIndices = IntStream.range(0, A.size())
			.mapToObj(i -> new NumberAndItsIndex(A.get(i), i))
			.sorted()
			.map(pair -> pair.index)
			.toArray(len -> new Integer[len]);
		
		int maxTillNow = sortedIndices[sortedIndices.length - 1];
		int minDiff = 0;
		for(int i = sortedIndices.length - 2; i >= 0; i--) {
			maxTillNow = Math.max(maxTillNow, sortedIndices[i]);
			minDiff = Math.min(minDiff, sortedIndices[i] - maxTillNow);
		}
		
		return -minDiff;
		
	}
	
	public static class NumberAndItsIndex implements Comparable<NumberAndItsIndex> {
		private int number, index;
		public NumberAndItsIndex(int number, int index) {
			this.index = index;
			this.number = number;
		}
		@Override
		public int compareTo(NumberAndItsIndex that) {
			return Integer.compare(this.number, that.number);
		}
		
		
		
		
	}
	
	
}
