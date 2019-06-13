package ib.linked.lists;

public class SwapListNodesInPairs {

	public static void main(String[] args) {
		ListNode result = new SwapListNodesInPairs().swapPairs(ListNode.makeLnkListOutOf(1, 2, 3, 4));
		ListNode.printList(result);
		
	}
	
	
	public ListNode swapPairs(ListNode input) {
		
		if(input == null || input.next == null) {
			return input;
		}
		
		ListNode newHead = null, prevTail = null, a = input, b = input.next, nextHead;
		
		while(a != null && b != null) {
			nextHead = b.next;
			if(prevTail == null) {
				newHead = b;
			} else {
				prevTail.next = b;
			}
			b.next = a;
			prevTail = a;

			a = nextHead;
			if(a != null) {
				b = a.next;
			} else {
				b = null;
			}
		}
		
		if(a != null) {
			prevTail.next = a;
		} else {
			prevTail.next = null;
		}
		
		return newHead;
		
    }
	
	
}
