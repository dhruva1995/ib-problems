package binary.search;

import java.util.Arrays;
import java.util.List;

public class RotatedSortedArraySearch {

	public static void main(String[] args) {
		System.out.println(new RotatedSortedArraySearch().search(Arrays.asList(9, 10, 11, 12, 14, 15, 17, 19, 24, 25,
				30, 39, 40, 44, 46, 48, 51, 53, 54, 56, 59, 60, 69, 70, 73, 75, 80, 87, 88, 89, 92, 93, 97, 99, 104,
				107, 109, 110, 111, 117, 123, 124, 125, 126, 127, 128, 135, 136, 137, 141, 148, 153, 154, 161, 166, 167,
				169, 175, 177, 180, 181, 182, 185, 186, 189, 193, 198, 202, 1, 2, 6, 7), 198));
	}

	public int search(final List<Integer> space, int key) {

		int low = 0, high = space.size() - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (space.get(mid) == key) {
				return mid;
			} else if (space.get((mid - 1 + space.size()) % space.size()) > space.get(mid)
					&& space.get(mid) < space.get((mid + 1 + space.size()) % space.size())) {
				int resultOfBinarySearchInFirstHalf = noramlBinarySearch(space, low, mid, key);
				if (resultOfBinarySearchInFirstHalf == -1) {
					if (mid + 1 != space.size()) {
						int resultOfBinarySearchInSecondHalf = noramlBinarySearch(space, mid + 1, high + 1,
								key);
						return resultOfBinarySearchInSecondHalf == -1 ? -1 : resultOfBinarySearchInSecondHalf;
					}
					return -1;
				}
				return resultOfBinarySearchInFirstHalf;
			} else if (space.get(mid) > space.get(low)) {
				int binSearchResult = noramlBinarySearch(space, low, mid - 1, key);
				if (binSearchResult != -1) {
					return binSearchResult;
				}
				low = mid + 1;
			} else {
				int binSearchResult = noramlBinarySearch(space, mid + 1, high + 1, key);
				if (binSearchResult != -1) {
					return binSearchResult;
				}
				high = mid - 1;
			}
		}
		return -1;

	}

	private int noramlBinarySearch(List<Integer> space, int low, int high, int key) {
		if (0 <= low && 0 <= high && low <= space.size() - 1 && high <= space.size() - 1) {
			while (low <= high) {
				int mid = low + (high - low) / 2;
				if (space.get(mid) == key) {
					return mid;
				} else if (space.get(mid) > key) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
		}
		return -1;
	}
}
