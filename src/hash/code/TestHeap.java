package hash.code;

import java.util.Arrays;
import java.util.PriorityQueue;

public class TestHeap {

	
	public static void main(String[] args) {
		PriorityQueue<Integer> integers = new PriorityQueue<>(Arrays.asList(1, 2, 3, 4));
		
		while(!integers.isEmpty()) {
			System.out.println(integers.poll());
		}
		
		
		
	}
	
}
