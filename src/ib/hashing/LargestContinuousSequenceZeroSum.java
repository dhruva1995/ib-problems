package ib.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LargestContinuousSequenceZeroSum {

	public static void main(String[] args) {
		new LargestContinuousSequenceZeroSum().lszero(new ArrayList<Integer>(Arrays.<Integer>asList(1, 2, 4, 0, -4, -1, 0, -2))).forEach(System.out::println);
	}



	public ArrayList<Integer> lszero(ArrayList<Integer> A) {
		HashMap<Long, Integer> sumTillThatIndexMap = new HashMap<>();
		long prevSum = 0;
		int champStart = -1, champEnd = -1; 
		for(int i = 0; i <= A.size(); i++) {
			if(sumTillThatIndexMap.containsKey(prevSum)) {
				int startIndex = sumTillThatIndexMap.get(prevSum);
				int endIndex = i;
				
				if(endIndex - startIndex > champEnd - champStart) {
					champEnd = endIndex;
					champStart = startIndex;
				}
				
				
			} else {
				sumTillThatIndexMap.put(prevSum, i);
			}
			if(i < A.size()) {
				prevSum += A.get(i);
			}
		}
		
		return champEnd == -1 ? new ArrayList<>() : new ArrayList<>(A.subList(champStart, champEnd)); 
		
	}

}
