package interview.bit.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaximumConsecutiveGap {
	
	
	public static void main(String[] args) {
		
		
		System.out.println(new MaximumConsecutiveGap().maximumGap(Arrays.asList(
				1, 10, 5
				)));
		
	}
	
	
	
	
	public int maximumGap(final List<Integer> input) {
		
		
		if(input.size() < 2) {
			return 0;
		}
		int min = Collections.min(input);
		int max = Collections.max(input);
		
		
		int gap = (max == min) ? 1 : (int)Math.ceil(((double)max - min)/(input.size() - 1));
		
		
		
		int[][] minsAndMaxs = new int[input.size()][]; 
				
		for(int i = 0; i < input.size(); i++) {
			int num = input.get(i);
			int position = (num - min) / gap;
			
			if(minsAndMaxs[position] == null) {
				minsAndMaxs[position] = new int[]{num, num};
			}
			
			minsAndMaxs[position][0] = Math.min(minsAndMaxs[position][0], num);
			minsAndMaxs[position][1] = Math.max(minsAndMaxs[position][1], num);
		}
		
		
		int maxDiff = 0;
		
		int prevMax = min;
		for(int i = 0; i < minsAndMaxs.length; i++) {
			if(minsAndMaxs[i] != null) {
				maxDiff = Math.max(maxDiff, minsAndMaxs[i][0] - prevMax);
				prevMax = minsAndMaxs[i][1];
			}
		}
		
		return maxDiff;
		
		
    }
	
	private static class Tuple<T, S> {
		private T first;
		
		private S second;
		
		public Tuple(T first, S second) {
			this.first = first;
			this.second = second;
		}
		
		public T first() {
			return this.first;
		}
		
		public S second() {
			return this.second;
		}
		
		@Override
		public String toString() {
			return "(" + this.first + ", " + this.second + ")";
		}
	}
	
}
