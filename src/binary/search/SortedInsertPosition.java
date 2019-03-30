package binary.search;

import java.util.ArrayList;

public class SortedInsertPosition {

    public int searchInsert(ArrayList<Integer> space, int key) {
    	
    	int low = 0, high = space.size() - 1;
    	int insertionIndex = -1;
    	
    	while(low <= high) {
    		
    		int mid = low + (high - low) / 2;
    		
    		if(space.get(mid) == key) {
    			return mid;
    		} else if(space.get(mid) < key) {
    			low = mid + 1;
    		} else {
    			high = mid - 1;
    			insertionIndex = mid;
    		}
    		
    		
    	}
    	return insertionIndex;
    	
    }
	
}
