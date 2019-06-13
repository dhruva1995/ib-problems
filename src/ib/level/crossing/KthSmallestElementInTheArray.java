package ib.level.crossing;

import java.util.Arrays;
import java.util.List;

public class KthSmallestElementInTheArray {

	
	public static void main(String[] args) {
		System.out.println(new KthSmallestElementInTheArray().kthsmallest(Arrays.asList(1, 2, 3,3, 2, -1, -1, 24, 5, 5, 5, 6), 7));
	}
	
	
	public int kthsmallest(final List<Integer> input, int k) {
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		for (int i : input) {
			max = Math.max(max, i);
			min = Math.min(min, i);
		}

		while (min <= max) {
			int mid = min + ((max - min) / 2);
			int lessCount = 0, equalCount = 0;
			for (int i : input) {
				if (i < mid) {
					lessCount++;
				} else if (i == mid) {
					equalCount++;
				}

			}
			
			if(lessCount == k - 1) {
				if(equalCount > 0) {
					return mid;
				} else {
					return findNextLargestElementThan(mid, input);
				}
			} else if(lessCount < k - 1) {
				if(lessCount + equalCount > k - 1) {
					return mid;
				}
				min = mid + 1;
			} else {
				max = mid - 1;
			}

		}
		
		return -1;

	}

	private int findNextLargestElementThan(int mid, List<Integer> input) {
		return input.stream().filter(e -> e > mid).sorted().findFirst().get();
		
	}

}
