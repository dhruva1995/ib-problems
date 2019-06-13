package ib.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DistinctNumbersInWindow {

	public static void main(String[] args) {
		
		System.out.println(new DistinctNumbersInWindow().dNums(new ArrayList<>(Arrays.asList(1, 2, 1, 3, 4, 3)), 3));
	}
	
	public ArrayList<Integer> dNums(ArrayList<Integer> input, int k) {
		if(k > input.size()) {
			return new ArrayList<>();
		} else {
			ArrayList<Integer> result = new ArrayList<>();
			Map<Integer, Long> count = IntStream.range(0, k).mapToObj(input::get).collect(Collectors.groupingBy(i -> i, Collectors.counting()));
			result.add(count.size());
			for(int i = k; i < input.size(); i++) {
				int insert = input.get(i), remove = input.get(i - k);
				if(count.containsKey(insert)) {
					count.compute(insert, (key, old) -> old + 1);
				} else {
					count.put(insert, 1L);
				}
				
				
				if(count.get(remove) == 1) {
					count.remove(remove);
				} else {
					count.compute(remove, (key, old) -> old - 1);
				}
				result.add(count.size());
				
				
			}
			
			return result;
			
			
		}
		
    }
	
	
	
}
