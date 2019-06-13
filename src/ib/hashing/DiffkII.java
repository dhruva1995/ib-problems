package ib.hashing;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DiffkII {
	
	public static void main(String[] args) {
		System.out.println(new DiffkII().diffPossible(Arrays.asList(1, 5, 3), 2));
	}

	public int diffPossible(final List<Integer> A, int target) {
		if(A.size() < 2) {
			return 0;
		}
		
		if((target & 1) == 0 && A.stream().filter(i -> i == target / 2).count() > 1) {
			return 1;
		}
		Map<Integer, Long> bank = A.stream().collect(Collectors.groupingBy(i -> i, Collectors.counting()));
		for(int i : A) {
			bank.compute(i, (key, old) -> old - 1);
			if(bank.containsKey(target + i) && bank.get(target + i) > 0) {
				return 1;
			}
			bank.compute(i, (key, old) -> old + 1);
			
			
		}
		return 0;
    }

	
	
	
}
