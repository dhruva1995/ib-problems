package binary.search;

import java.util.Arrays;
import java.util.List;


public class MedianOfMergedArrayProperNonRecursive {

	//Sedwick's course 2nd approach refer time complexity is O(m + n) 
	public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
		List<Integer> lessSized = a.size() > b.size() ? b : a;
		List<Integer> moreSized = a.size() > b.size() ? a : b;
		int splitBeforeLow = 0, slitBeforeMax = lessSized.size();
		boolean isAvgCase = (lessSized.size() + moreSized.size()) % 2 == 0;
		while(splitBeforeLow <= slitBeforeMax) {
			int splitBeforeInSmaller = splitBeforeLow + (slitBeforeMax - splitBeforeLow) / 2;
			int l1 = splitBeforeInSmaller == 0 ? Integer.MIN_VALUE : lessSized.get(splitBeforeInSmaller - 1);
			int h1 = splitBeforeInSmaller == lessSized.size() ? Integer.MAX_VALUE : lessSized.get(splitBeforeInSmaller);
			
			
			int splitBeforeInLarger = (int)((lessSized.size() + moreSized.size() - 1) / 2) - splitBeforeInSmaller + 1;
			int l2 = splitBeforeInLarger == 0 ? Integer.MIN_VALUE : moreSized.get(splitBeforeInLarger - 1);
			int h2 = splitBeforeInLarger == moreSized.size() ? Integer.MAX_VALUE : moreSized.get(splitBeforeInLarger);
			
			
			if(l1 <= h2 && l2 <= h1) {
				return isAvgCase ? (Math.max(l1, l2) + Math.min(h1, h2)) / 2.0 : Math.max(l1, l2);
			} else if (l1 <= h2) {
				splitBeforeLow = splitBeforeInSmaller + 1;
			} else {
				slitBeforeMax = splitBeforeInSmaller - 1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		
		System.out.println(new MedianOfMergedArrayProperNonRecursive().
				findMedianSortedArrays(Arrays.asList(1, 2, 3), Arrays.asList(1, 2)));

		
	}
	
	
}
