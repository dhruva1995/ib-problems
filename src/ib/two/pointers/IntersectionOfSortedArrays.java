package ib.two.pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfSortedArrays {

	public static void main(String[] args) {
		System.out.println(
				new IntersectionOfSortedArrays().intersect(Arrays.asList(10000000), Arrays.asList(10000000)));
	}

	public ArrayList<Integer> intersect(final List<Integer> a, final List<Integer> b) {

		int readA = 0, readB = 0;

		ArrayList<Integer> result = new ArrayList<>();

		while (readA < a.size() && readB < b.size()) {
			if (a.get(readA).intValue() == b.get(readB).intValue()) {
				result.add(a.get(readA));
				readA++;
				readB++;
			}

			else if (a.get(readA).intValue() < b.get(readB).intValue()) {
				readA++;
			} else {
				readB++;
			}

		}

		return result;

	}

}
