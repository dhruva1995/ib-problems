package ib.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ValidSudoku {

	private static final int SIZE = 9;

	public static void main(String[] args) {
		System.out.println(new ValidSudoku().isValidSudoku(Arrays.asList("53..7....", "6..195...", ".98....6.",
				"8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79")));
	}

	public int isValidSudoku(final List<String> input) {
		return validateRows(input) && validateColumns(input) && ValidateBlocks(input) ? 1 : 0;

	}

	private boolean ValidateBlocks(List<String> input) {
		for (int i = 0; i < SIZE; i++) {
			ArrayList<Integer> nums = new ArrayList<>();
			int row = (i / 3) * 3, col = (i % 3) * 3;
			for (int r = row; r < row + 3; r++) {
				for (int c = col; c < col + 3; c++) {
					int test = input.get(r)
							.charAt(c);
					if (test != '.') {
						nums.add(test);
					}
				}
			}

			if (!isValid(nums.stream()
					.mapToInt(j -> j)
					.toArray())) {
				return false;
			}
		}
		return true;
	}

	private boolean validateRows(List<String> rows) {
		for (int i = 0; i < SIZE; i++) {
			if (!isValid(rows.get(i)
					.chars()
					.filter(c -> c != '.')
					.toArray())) {
				return false;
			}
		}
		return true;
	}

	private boolean validateColumns(List<String> rows) {
		for (int col = 0; col < SIZE; col++) {
			int i = col;
			if (!isValid(rows.stream()
					.mapToInt(s -> s.charAt(i))
					.filter(c -> c != '.')
					.toArray())) {
				return false;
			}
		}
		return true;
	}

	private boolean isValid(int... nums) {
		return (int) IntStream.of(nums)
				.distinct()
				.count() == nums.length;
	}

}
