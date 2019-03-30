package binary.search;


public class BinarySearch<T extends Comparable<? super T>> {

	
	public static void main(String[] args) {
		
		Integer[] universe = new Integer[] {1, 2, 3, 4, 56, 78, 99, 121, 189, 567, 789, 900, 1234};
		System.out.println(new BinarySearch<Integer>().recursiveSearch(universe, 51));
		System.out.println(new BinarySearch<Integer>().recursiveSearch(universe, 900));
	}
	
	
	
	
	public int search(T[] array, T key) {
		int low = 0, high = array.length - 1;
		while(low <= high) {
			int mid = low + (high - low) / 2;
			T midElement = array[mid];
			int comparisionResult = key.compareTo(midElement);
			if(comparisionResult == 0) {
				return mid;
			} else if(comparisionResult < 0) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}
	
	
	public int recursiveSearch(T[] array, T key) {
		return recurseInternal(array, 0, array.length - 1, key);
	}
	
	public int recurseInternal(T[]array, int low, int high, T key) {
		if(low > high) {
			return -1;
		}
		int mid = low + (high - low) / 2;
		int comparisonResult = key.compareTo(array[mid]);
		if(comparisonResult == 0) {
			return mid;
		} else if(comparisonResult < 0) {
			return recurseInternal(array, low, mid - 1, key);
		} else {
			return recurseInternal(array, mid + 1, high, key);
		}
	}
	
	
	
}
