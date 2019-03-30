package binary.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MatrixMedian {
	
	
	public static void main(String[] args) {
		int[][] input = new int[][] {{1, 1, 3, 3, 3}};
		
		ArrayList<ArrayList<Integer>> actualInput = Arrays.stream(input).map(MatrixMedian::convertToArrayList).collect(Collectors.toCollection(ArrayList::new));
		System.out.println(new MatrixMedian().findMedian(actualInput));
		
		
	}
	
	private int findMedian(ArrayList<ArrayList<Integer>> actualInput) {
		int min = actualInput.get(0).get(0), max = actualInput.get(0).get(0);
		int finalMid = actualInput.get(0).size() * actualInput.size() / 2;
		for(ArrayList<Integer> eachRow : actualInput) {
			
			for(int i : eachRow) {
				min = Math.min(i, min);
				max = Math.max(i, max);
				
			}
		}
		
		while(max >= min) {
			int mid = min + (max - min) / 2;
			
			Tuple startAndEnd = getTuple(mid, actualInput);
			
			if(startAndEnd.isValid && startAndEnd.liesInBetween(finalMid)) {
				return mid;
			}
			if(startAndEnd.firstPosition <= finalMid) {
				min = mid + 1;
			} else {
				max = mid - 1;
			}
			
			
		}
		
		
		return -1;
	}

	private static ArrayList<Integer> convertToArrayList(int numbers[]) {
		return Arrays.stream(numbers).boxed().collect(Collectors.toCollection(ArrayList::new));
	}
	
	
	
	private Tuple getTuple(int key, ArrayList<ArrayList<Integer>> a) {
    	
		
		
    	int first = a.stream()
    		.mapToInt(list -> getLeftMostPositionToInsert(list, key))
    		.sum();
    	
    	int countOfKey = a.stream()
    						.mapToInt(list -> getElementCount(list, key))
    						.sum();
    	
    	
    	
    	
		return new Tuple(first, first + countOfKey - 1, countOfKey > 0);
	}

	private class Tuple {
    	private final int firstPosition, lastPosition;
    	private final boolean isValid;
		public Tuple(int firstPosition, int lastPosition, boolean isValid) {
			this.firstPosition = firstPosition;
			this.isValid = isValid;
			this.lastPosition = lastPosition;
		}
    	
		public boolean liesInBetween(int position) {
			return firstPosition <= position && position <= lastPosition;
		}
    	
    }
    

	int getElementCount(List<Integer> space, int key) {
    	int first = getLeftMostPositionToInsert(space, key);
    	int end = getRightMostPositionToInsert(space, key);
    	return Math.max(end - first, 0);
    }
    
    int getRightMostPositionToInsert(List<Integer> input, int element) {
    	int low = 0, high = input.size() - 1;
    	while (low <= high) {
    		if(element < input.get(low)) {
    			return low;
    		} else if(input.get(high) <= element) {
    			return high + 1;
    		} else if(high - low == 1) {
    			return low + 1;
    		}
    		int mid = low + (high - low) / 2;
    		if(input.get(mid - 1) <= element && input.get(mid) > element) {
    			return mid;
    		} else if(input.get(mid) <= element) {
    			low = mid + 1;
    		} else {
    			high = mid - 1;
    		}
    	}
    	return -1;
    	
    	
    }
    
    
    int getLeftMostPositionToInsert(List<Integer> in, int elementTOInsert) {
    	int low = 0, high = in.size() - 1;
    	while(low <= high) {
    		
    		if(elementTOInsert <= in.get(low)) {
    			return low;
    		} else if(elementTOInsert > in.get(high)) {
    			return high + 1;
    		} else if(high - low == 1) {
    			return low + 1;
    		}
    		
    		int mid = low + (high - low) / 2;
    		if(in.get(mid - 1) < elementTOInsert && in.get(mid) >= elementTOInsert) {
    			return mid;
    		} else if(in.get(mid) >= elementTOInsert) {
    			high = mid - 1;
    		} else {
    			low = mid + 1;
    		}
    	}
    	return -1;
    }
    
}
