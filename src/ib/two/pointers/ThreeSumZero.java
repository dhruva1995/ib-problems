package ib.two.pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ThreeSumZero {

	public static void main(String[] args) {

		new ThreeSumZero()
				.threeSum(new ArrayList<>(
						Arrays.asList(-31013930, -31013930, 9784175, 21229755)))
				.forEach(System.out::println);

	}

	public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {

		ArrayList<ArrayList<Integer>> results = new ArrayList<>();

		Collections.sort(A);

		for (int i = 0; i < A.size(); i++) {

			if (i != 0 && A.get(i).compareTo(A.get(i - 1)) == 0) {
				continue;
			}

			int j = i + 1, k = A.size() - 1;

			while (j < k) {

				long sum = (long) A.get(i) + A.get(j) + A.get(k);
				if (sum == 0) {
					results.add(new ArrayList<>(Arrays.asList(A.get(i), A.get(j), A.get(k))));
					while(j < k && A.get(j + 1) == A.get(j)) {
						j++;
					}
					j++;
				} else if (sum > 0) {
					while(k > j && A.get(k) == A.get(k - 1)) {
						k--;
					}
					k--;

				} else {
					while(j < k && A.get(j + 1) == A.get(j)) {
						j++;
					}
					j++;
				}
			}
		}

		return results;
	}

}
