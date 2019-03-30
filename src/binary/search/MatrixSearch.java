package binary.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MatrixSearch {

	public static void main(String[] args) {

		int[][] space = {
				{22, 32, 67}
		};



		System.out.println(new MatrixSearch().searchMatrix(Arrays.stream(space).
															map(ary -> Arrays.stream(ary).boxed().collect(Collectors.toCollection(ArrayList::new)))
															.collect(Collectors.toCollection(ArrayList::new)), 
															93));
	}

	public int searchMatrix(ArrayList<ArrayList<Integer>> a, int key) {
		int maxRows = a.size();
		int maxColumns = a.get(0)
				.size();
		int low = 0, high = maxRows - 1;
		int possibleRow = -1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (a.get(mid)
					.get(maxColumns - 1) == key) {
				return 1;
			} else if (a.get(mid)
					.get(maxColumns - 1) < key) {
				low = mid + 1;
			} else {
				possibleRow = mid;
				high = mid - 1;
			}
		}
		if (0 <= possibleRow && possibleRow <= maxRows) {
			List<Integer> space = a.get(possibleRow);
			low = 0;
			high = space.size() - 1;
			while (low <= high) {
				int mid = low + (high - low) / 2;
				if (space.get(mid) == key) {
					return 1;
				} else if (space.get(mid) < key) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}
		return 0;
	}
}
