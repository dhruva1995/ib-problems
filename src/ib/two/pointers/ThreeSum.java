package ib.two.pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ThreeSum {

	public static void main(String[] args) {
		System.out.println(new ThreeSum().threeSumClosest(new ArrayList<>(Arrays.asList(2, 1, -9, -7, -8, 2, -8, 2, 3, -8 )), -1));
	}

	public int threeSumClosest(ArrayList<Integer> srcs, int target) {
		Collections.sort(srcs);
		int champ = srcs.get(0) + srcs.get(1) + srcs.get(2);
		int champAbs = getAbsDiff(srcs.get(0), srcs.get(1), srcs.get(2), target);
		for (int i = 0; i < srcs.size(); i++) {
			int j = i + 1, k = srcs.size() - 1;
			while (j < k) {
				int temp = srcs.get(i) + srcs.get(j) + srcs.get(k);
				if (getAbsDiff(srcs.get(i), srcs.get(j), srcs.get(k), target) < champAbs) {
					champ = temp;
					champAbs = getAbsDiff(srcs.get(i), srcs.get(j), srcs.get(k), target);
				} 
				if(temp == target) {
					return target;
				} else if (temp > target) {
					k--;
				} else {
					j++;
				}
			}

		}
		return champ;
	}

	public int getAbsDiff(int a, int b, int c, int target) {
		return Math.abs(a + b + c - target);
	}

}
