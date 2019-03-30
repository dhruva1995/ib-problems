package interview.bit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralOrder_MyApproach {

	public static void main(String[] args) {

		System.out.println(new SpiralOrder_MyApproach().spiralOrder(Arrays.asList(Arrays.asList(1), Arrays.asList(2),
				Arrays.asList(3), Arrays.asList(4), Arrays.asList(5))));

	}

	public ArrayList<Integer> spiralOrder(final List<List<Integer>> A) {
		int rows = A.size(), cols = A.get(0)
				.size();
		ArrayList<Integer> result = new ArrayList<>(rows * cols);
		int x = 0, y = 0;
		while (cols > 0 && rows > 0) {
			for (int i = 0; i < cols; i++) {
				result.add(A.get(x)
						.get(y + i));
			}
			for (int j = 1; j < rows; j++) {
				result.add(A.get(y + j)
						.get(x + cols - 1));
			}
			if (rows > 1) {
				for (int i = cols - 2; i >= 0; i--) {
					result.add(A.get(x + rows - 1)
							.get(y + i));
				}
			}
			if (cols > 1) {
				for (int j = rows - 2; j >= 1; j--) {
					result.add(A.get(x + j)
							.get(y));
				}
			}
			x++;
			y++;
			rows -= 2;
			cols -= 2;
		}

		return result;
	}

}
