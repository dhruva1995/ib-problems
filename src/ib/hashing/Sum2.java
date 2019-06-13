package ib.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Sum2 {
	
	public static void main(String[] args) {
		System.out.println(new Sum2().twoSum(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8), 10));
	}
	

	public ArrayList<Integer> twoSum(final List<Integer> A, int target) {
		Map<Integer, Integer> numberIndexMap = IntStream.range(0, A.size())
				.boxed()
				.collect(Collectors.toMap(A::get, i -> i, Math::min));
		int champIndex1 = -1, champIndex2 = -1;
		for(int i = 0; i < A.size(); i++) {
			if(numberIndexMap.containsKey(target - A.get(i)) && numberIndexMap.get(target - A.get(i)) != i) {
				int j = numberIndexMap.get(target - A.get(i));
				int index1 = Math.min(i, j), index2 = Math.max(i, j);
				if(champIndex1 == -1) {
					champIndex1 = index1;
					champIndex2 = index2;
				} else if(champIndex2 > index2) {
					champIndex1 = index1;
					champIndex2 = index2;
				} else if(champIndex2 == index2) {
					champIndex1 = Math.min(champIndex1, index1);
				}
			}
		}
		return champIndex1 == -1 ? new ArrayList<>() : new ArrayList<>(Arrays.asList(champIndex1, champIndex2));
    }
	
}
