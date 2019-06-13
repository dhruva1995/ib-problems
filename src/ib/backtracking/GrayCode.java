package ib.backtracking;

import java.util.ArrayList;
import java.util.BitSet;

public class GrayCode {

	public static void main(String[] args) {

		new GrayCode().grayCode(2)
				.forEach(System.out::println);

	}

		public ArrayList<Integer> grayCode(int a) {
	
			ArrayList<Integer> result = new ArrayList<>();
	
			BitSet validator = new BitSet((int) Math.pow(2, a));
	
			if (a < 1) {
				return result;
			} else {
				result.add(0);
				validator.set(0);
				while (result.size() < Math.pow(2, a)) {
					grayCodeHelper(0, a, result, result.get(result.size() - 1), validator);
				}
	
			}
			return result;
		}
	
		private void grayCodeHelper(int level, int max, ArrayList<Integer> result, int number, BitSet validator) {
			int newNumber = number ^ (1 << level);
	
			if (!validator.get(newNumber)) {
				result.add(newNumber);
				validator.set(newNumber);
			} else {
				grayCodeHelper(level + 1, max, result, number, validator);
			}
	
		}
	}
