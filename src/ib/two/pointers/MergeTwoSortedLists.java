package ib.two.pointers;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeTwoSortedLists {

	public static void main(String[] args) {

		ArrayList<Integer> src = new ArrayList<>(Arrays.asList(1, 3, 4, 5));

		new MergeTwoSortedLists().merge(src, new ArrayList<>(Arrays.asList(11, 13, 14, 14)));

		System.out.println(src);
	}

	public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {

		ArrayList<Integer> merge = new ArrayList<>(a.size() + b.size());
		int readA = 0, readB = 0;
		while (readA < a.size() && readB < b.size()) {
			if (a.get(readA) < b.get(readB)) {
				merge.add(a.get(readA));
				readA++;
			} else {
				merge.add(b.get(readB));
				readB++;
			}
		}
		if (readA < a.size()) {
			merge.addAll(a.subList(readA, a.size()));
		}

		if (readB < b.size()) {
			merge.addAll(b.subList(readB, b.size()));
		}
		a.clear();
		a.addAll(merge);
	}
}
