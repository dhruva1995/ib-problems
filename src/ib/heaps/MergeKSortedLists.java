package ib.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeKSortedLists {

	
	public static void main(String[] args) {
		
		new MergeKSortedLists()
			.mergeKLists(new ArrayList<>(Arrays.asList(
						ListNode.makeLnkListOutOf(1, 10, 20),
						ListNode.makeLnkListOutOf(4, 11, 13),
						ListNode.makeLnkListOutOf(3, 8, 9)
					))).print();
		
	}
	
	
	public ListNode mergeKLists(ArrayList<ListNode> input) {
		
		
		PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
		
		heap.addAll(input);
		
		ListNode head = null, trav = null;
		
		while(!heap.isEmpty()) {
			
			ListNode min = heap.poll();
			
			if(head == null) {
				head = min;
			} else {
				trav.next = min;
			}
			if(min.next != null) {
				heap.add(min.next);
			}
			trav = min;
		}
		
		return head;
		
    }
	
	
}
