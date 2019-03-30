package interview.bit.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CityTour {

	private static class LenPair {

		public LenPair(int smallLen, int largeLen) {
			super();
			this.smallLen = smallLen;
			this.largeLen = largeLen;
		}

		private int smallLen;

		private int largeLen;

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + largeLen;
			result = prime * result + smallLen;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			LenPair other = (LenPair) obj;
			if (largeLen != other.largeLen)
				return false;
			if (smallLen != other.smallLen)
				return false;
			return true;
		}

	}

	private final long ROUND = 1_000_000_007;

	private final Map<LenPair, Long> counts = new HashMap<>();

	public int solve(int A, ArrayList<Integer> B) {

		return 0;
	}

	public static void main(String[] args) {
		System.out.println(new CityTour().getCountOfAllPossibleCombinationsInOrder(3, 5) + 1);
	}

	private long getCountOfAllPossibleCombinationsInOrder(int list1, int list2) {
		
		int small = Math.min(list1, list2);
		int large = Math.max(list1, list2);
		
		
		if(small == 0) {
			return 1;
		}
		if(small == 1) {
			return large;
		}
		
		LenPair pair = new LenPair(small, large);
		
		if(!counts.containsKey(pair)) {

			long count = getCountOfAllPossibleCombinationsInOrder(small - 1, large);

			for(int i = 1; i <= large; i++) {
				count += getCountOfAllPossibleCombinationsInOrder(small, large - i);
			}
			
			counts.put(pair, count);
		}
		return counts.get(pair);
		
		
	}

}
