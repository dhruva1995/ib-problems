package ib.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class SubsetsII {

	public static void main(String[] args) {

		new SubsetsII().subsetsWithDup(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 4)))
				.forEach(System.out::println);

	}

	public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		A.sort(Comparator.naturalOrder());
		result.add(new ArrayList<>());
		subsetsWithDupHelper(result, A, new LinkedList<>());
		return result;
	}

	private void subsetsWithDupHelper(ArrayList<ArrayList<Integer>> result, List<Integer> available,
			LinkedList<Integer> prevChoosen) {

		if (!available.isEmpty()) {
			// System.out.println("available " + available + " choosen " + prevChoosen);
			int current = available.get(0);
			prevChoosen.addLast(current);
			result.add(new ArrayList<>(prevChoosen));

			subsetsWithDupHelper(result, available.subList(1, available.size()), prevChoosen);

			prevChoosen.removeLast();

			int i = 1;

			for (; i < available.size() && available.get(i) == current; i++)
				;

			if (i < available.size()) {
				subsetsWithDupHelper(result, available.subList(i, available.size()), prevChoosen);
			}

		}

	}

}
