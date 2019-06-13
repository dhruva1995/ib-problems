package ib.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class Equal {
	
	public static void main(String[] args) {
		System.out.println(new Equal().equal(new ArrayList<>(Arrays.asList(0, 0, 1, 0, 2, 1 ))));
	}

	public ArrayList<Integer> equal(ArrayList<Integer> A) {
		
		LinkedHashMap<Integer, ArrayList<Pair>> bank = new LinkedHashMap<>();
		
		for(int i = 0; i < A.size(); i++) {
			for(int j = i + 1; j < A.size(); j++) {
				int sum = A.get(i) + A.get(j);
				bank.computeIfAbsent(sum, key -> new ArrayList<>()).add(new Pair(i, j));
			}
		}
		
		for(ArrayList<Pair> pairs : bank.values()) {
			if(pairs.size() > 1) {
				for(int i = 0; i < pairs.size(); i++) {
					for(int j = i + 1; j < pairs.size(); j++) {
						if(satisfiesCondition(pairs.get(i), pairs.get(j))) {
							return new ArrayList<>(Arrays.asList(pairs.get(i).min, pairs.get(i).max, pairs.get(j).min, pairs.get(j).max));
						}
					}
				}
				
				
			}
		}
		return new ArrayList<>();
    }
	
	private boolean satisfiesCondition(Pair p1, Pair p2) {
		int a = p1.min, b = p1.max, c = p2.min, d = p2.max;
		return a < b && a < c  && a < c && b != c && b != d;
	}
	
	
	private class Pair {
		int min, max;

		public Pair(int min, int max) {
			super();
			this.min = min;
			this.max = max;
		}
		
	}
	
	
}
