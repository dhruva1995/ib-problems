package interview.bit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class FirstMissingInteger {

	public static void main(String[] args) {
		FirstMissingInteger fmi = new FirstMissingInteger();
		System.out.println(fmi.firstMissingPositive(new ArrayList<>(Arrays.asList(-8, -7, -6))));

	}

	public int firstMissingPositive(ArrayList<Integer> A) {
		int sit = 0, run = 0;

		for (int i = 0; i < A.size(); i++) {
			int value = A.get(i);
			if (value < 0 || value > A.size()) {
				A.set(i, 0);
			}
		}

		while (sit < A.size()) {
			run = sit;
			boolean fromIn = false;
			while (run < A.size()) {
				
				int value = A.get(run);

				if(fromIn) {
					A.set(run, -1);
					
				}
				
				if (value == 0 || value == -1) {
					break;
				}
				
				fromIn = true;
				
				run = value - 1;
			}
			sit++;
		}

		return IntStream.range(0, A.size())

				.filter(i -> A.get(i) != -1)
				.map(i -> i + 1)
				.findFirst()
				.orElse(A.size() + 1);

	}

}
