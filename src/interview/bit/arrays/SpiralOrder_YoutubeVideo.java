package interview.bit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralOrder_YoutubeVideo {

	public static void main(String[] args) {

		System.out.println(new SpiralOrder_YoutubeVideo()
				.spiralOrder(Arrays.asList(Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(1, 2, 3, 4, 5),
						Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(1, 2, 3, 4, 5))));

	}

	private static enum Direction {
		RIGHT, BOTTOM, LEFT, TOP,;

		private Direction next() {
			return Direction.values()[(this.ordinal() + 1) % Direction.values().length];
		}

	}

	public ArrayList<Integer> spiralOrder(final List<List<Integer>> list) {
		ArrayList<Integer> result = new ArrayList<Integer>();

		int top = 0, bottom = list.size() - 1, left = 0, right = list.get(0)
				.size() - 1;
		Direction currentTravDir = Direction.RIGHT;

		while (bottom >= top && left <= right) {

			if (currentTravDir == Direction.RIGHT) {
				for (int i = left; i <= right; i++) {
					result.add(list.get(top)
							.get(i));
				}
				top++;
			}
			if (currentTravDir == Direction.BOTTOM) {
				for (int i = top; i <= bottom; i++) {
					result.add(list.get(i)
							.get(right));
				}
				right--;
			}
			if (currentTravDir == Direction.LEFT) {
				for (int i = right; i >= left; i--) {
					result.add(list.get(bottom)
							.get(i));
				}
				bottom--;
			}
			if (currentTravDir == Direction.TOP) {
				for (int i = bottom; i >= top; i--) {
					result.add(list.get(i)
							.get(left));
				}
				left++;
			}
			currentTravDir = currentTravDir.next();
		}
		return result;
	}

}
