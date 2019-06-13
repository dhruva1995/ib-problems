package ib.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MagicianAndChocolates {

	public static void main(String[] args) {
		
		System.out.println(new MagicianAndChocolates().nchoc(3, new ArrayList<>(Arrays.asList(6, 5))));
		
	}
	
	
	public int nchoc(int K, ArrayList<Integer> A) {
		
		if(A.size() < 1) {
			return 0;
		}
		
		long numberOfChocolates = 0;
		
		PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
		
		heap.addAll(A);
		
		for(int i = 0; i < K; i++) {
			int max = heap.poll();
			
			if(max <= 0) {
				break;
			}
			
			numberOfChocolates += max;
			
			heap.add(max / 2);
			
		}
		
		return (int)(numberOfChocolates % 1_000_000_007);
		
    }
	
	
}
