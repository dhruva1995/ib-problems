package ib.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Sum4 {

	public static void main(String[] args) {
		new Sum4().fourSum(new ArrayList<>(Arrays.asList(0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4, 4, 4, 5, 6)), 6)
				.forEach(System.out::println);
	}

	public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> input, int target) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		Collections.sort(input);
		for (int a = 0; a < input.size() - 3; a = getNextIndexWhereElementChanges(input, a)) {
			for (int b = a + 1; b < input.size() - 2; b = getNextIndexWhereElementChanges(input, b)) {
				int c = b + 1, d = input.size() - 1;
				while (c < d) {
					int computation = checkIfABCDSumsToTarget(input, a, b, c, d, target);
					if (computation == 0) {
						result.add(
								new ArrayList<>(Arrays.asList(input.get(a), input.get(b), input.get(c), input.get(d))));
						c = getNextIndexWhereElementChanges(input, c);
					} else if (computation > 0) {
						d = getPrevIndexWhereElementChanges(input, d);
					} else {
						c = getNextIndexWhereElementChanges(input, c);
					}
				}
			}
		}
		return result;
	}

	private int checkIfABCDSumsToTarget(ArrayList<Integer> input, int a, int b, int c, int d, int target) {
		return input.get(a) + input.get(b) + input.get(c) + input.get(d) - target;
	}

	private int getNextIndexWhereElementChanges(ArrayList<Integer> universe, int startIndex) {
		int value = universe.get(startIndex);
		while (startIndex < universe.size() && value == universe.get(startIndex)) {
			startIndex++;
		}
		return startIndex;
	}

	private int getPrevIndexWhereElementChanges(ArrayList<Integer> universe, int start) {
		int value = universe.get(start);
		while(start >= 0 && universe.get(start) == value) {
			start--;
		}
		return start;
	}
	
	
}
