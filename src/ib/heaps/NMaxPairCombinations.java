package ib.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class NMaxPairCombinations {

	
	public static void main(String[] args) {
		
		System.out.println(new NMaxPairCombinations().solve(new ArrayList<>(Arrays.asList(3, 2, 4, 2)), new ArrayList<>(Arrays.asList(2,5,1,6))));
		
	}
	
	
	public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        
		PriorityQueue<Integer> heap = new PriorityQueue<>(A.size());
		
		Collections.sort(A);
		Collections.sort(B);
		
		
		for(int i = A.size() - 1; i >= 0; i--) {
			
			int ai = A.get(i);
			boolean addedAny = false;
			for(int j = B.size() - 1; j >= 0; j--) {
				int currentSum = ai + B.get(j);
				
				if(heap.size() < A.size()) {
					heap.add(currentSum);
					addedAny = true;
				} else {
					if(heap.peek() < currentSum) {
						addedAny = true;
						heap.poll();
						heap.add(currentSum);
					}
				}
				
				if(!addedAny) {
					break;
				}
				
			}
		}
		
		ArrayList<Integer> result = new ArrayList<>();
		
		while(!heap.isEmpty()) {
			
			result.add(heap.poll());
			
		}
		
		Collections.reverse(result);
		
		return result;
    }
	
}
