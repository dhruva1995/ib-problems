package binary.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchForARange {

	
public static void main(String[] args) {
	System.out.println(new SearchForARange().searchRange(Arrays.asList(1), 1));
}
	
	
	
	public ArrayList<Integer> searchRange(final List<Integer> space, int key) {
		
		int low = 0, high = space.size() - 1, lowerIndex = -1, upperIndex = -1;
		
		while(low <= high) {
			int mid = low + (high - low) / 2;
			if(space.get(mid) == key) {
				lowerIndex = mid;
				high = mid - 1;
			} else if(space.get(mid) < key) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		
		low = 0; high = space.size() - 1;
		while(low <= high) {
			int mid = low + (high - low) / 2;
			
			if(space.get(mid) == key) {
				upperIndex = mid;
				low = mid + 1;
			} else if(space.get(mid) < key) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
			
			
		}
		
		return new ArrayList<>(Arrays.asList(lowerIndex, upperIndex));
		
		
    }
	
	
}
