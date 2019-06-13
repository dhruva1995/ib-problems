package ib.two.pointers;

import java.util.ArrayList;
import java.util.Arrays;

public class Diffk {

	
	public static void main(String[] args) {
		
		System.out.println(new Diffk().diffPossible(new ArrayList<>(Arrays.asList(1, 2, 3)), 0));
		
	}
	
	public int diffPossible(ArrayList<Integer> input, int targetDiff) {
		int i = 0, j = 1;
		
		while (i < input.size() && j < input.size()) {

			while (j < input.size() && input.get(j) - input.get(i) < targetDiff) {
				j++;
			}
			if(j == input.size()) {return 0;}
			if (input.get(j) - input.get(i) == targetDiff) {
				return 1;
			} else {
				i++;
				if(i == j) {
					j++;
				}
			}

		}
		return 0;
		
		
    }
	
}
