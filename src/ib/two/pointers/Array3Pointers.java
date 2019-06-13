package ib.two.pointers;

import java.util.Arrays;
import java.util.List;

public class Array3Pointers {

	public static void main(String[] args) {
		System.out.println(new Array3Pointers().minimize(Arrays.asList(1, 4, 10), Arrays.asList(2, 15, 20),
				Arrays.asList(10, 12)));
	}

	public int minimize(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
		int i = 0, j = 0, k = 0;

		int result = caculateAbsValues(A.get(0), B.get(0), C.get(0));

		while (i < A.size() && j < B.size() && k < C.size()) {

			int tempResult = caculateAbsValues(A.get(i), B.get(j), C.get(k));
			result = Math.min(result, tempResult);
			switch (getMin(A.get(i), B.get(j), C.get(k))) {
			case 0:
				i++;
				break;
			case 1:
				j++;
				break;
			default:
				k++;
				break;

			}

		}
		return result;

	}

	private int getMin(int a, int b, int c) {
		if (a <= b && a <= c) {
			return 0;
		} else if (b <= a && b <= c) {
			return 1;
		} else {
			return 2;
		}
	}

	private int caculateAbsValues(int a, int b, int c) {
		return Math.max(Math.abs(a - b), Math.max(Math.abs(b - c), Math.abs(a - c)));
	}

}
