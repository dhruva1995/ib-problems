package binary.search;

import java.util.Arrays;
import java.util.List;

public class MedianOfMergedArrayNonRecursiveApproach {

	public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
		
		int median1Index = (int)Math.floor((a.size() + b.size() - 1) / 2.0);
		int median2Index = (int)Math.ceil((a.size() + b.size() - 1) / 2.0);
		int median1 = findTheElementWithRank(median1Index, a, b);
		int median2 = median2Index != median1Index ? findTheElementWithRank(median2Index, a, b) : median1;
		return (median1 + median2) / 2.0;
		
    }

	private int findTheElementWithRank(int reqMedianIndex, List<Integer> a, List<Integer> b) {
		int low = 0, high = a.size() - 1;
		while(low <= high) {
			
			int mid = low + (high - low) / 2;
			
			int startingAt = getElementsLessThan(a.get(mid), a) +getElementsLessThan(a.get(mid), b);
			int endingAt = startingAt - 1 +  getCountOfElement(a.get(mid), a) + getCountOfElement(a.get(mid), b);
			
			if(startingAt <= reqMedianIndex && reqMedianIndex <= endingAt) {
				return a.get(mid);
			} else if(reqMedianIndex < startingAt) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		
		low = 0; high = b.size() - 1;
		while(low <= high) {
			
			int mid = low + (high - low) / 2;
			
			int startingAt = getElementsLessThan(b.get(mid), a) + getElementsLessThan(b.get(mid), b);
			int endingAt = startingAt - 1 + getCountOfElement(b.get(mid), a) + getCountOfElement(b.get(mid), b);
			
			if(startingAt <= reqMedianIndex && reqMedianIndex <= endingAt) {
				return b.get(mid);
			} else if(reqMedianIndex < startingAt) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}
	
	
	private int getCountOfElement(int key, List<Integer> space) {
		int firstIndex = -1, lastIndex = -1;
		int low = 0, high = space.size() - 1;
		
		
		
		while(low <= high) {
			int mid = low + (high - low) / 2;
			if(space.get(mid) == key) {
				firstIndex = mid;
				high = mid - 1;
			} else if(space.get(mid) < key) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		
		low = 0; high = space.size() - 1;
		while(high >= low) {
			int mid = low + (high - low) / 2;
			if(space.get(mid) == key) {
				lastIndex = mid;
				low = mid + 1;
			} else if(space.get(mid) < key) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return lastIndex == -1 ? 0 : lastIndex - firstIndex + 1;
	}
	
	
	private int getElementsLessThan(int key, List<Integer> elements) {
		
		if(elements.isEmpty()) {
			return 0;
		}
		
		
		int low = 0, high = elements.size() - 1, result = high;

		if(key < elements.get(0)) {
			return 0;
		} else if(key > elements.get(high)) {
			return elements.size();
		}
		
		while(low <= high) {
			
			int mid = low + (high - low) / 2;
			if(elements.get(mid) >= key) {
				result = Math.min(result, mid);
				high = mid - 1;
			} else if(elements.get(mid) < key) {
				low = mid + 1;
			}
			
			
		}
		return result;
		
		
	}
	
	public static void main(String[] args) {
		System.out.println(new MedianOfMergedArrayNonRecursiveApproach().
				findMedianSortedArrays(Arrays.asList(1, 2, 3), Arrays.asList()));
	}
	
}
