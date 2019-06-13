package ib.linked.lists;

public class ReorderList {

	
	public static void main(String[] args) {
		ListNode result = new ReorderList().reorderList(ListNode.makeLnkListOutOf(1, 2, 3, 4, 5));
		ListNode.printList(result);
		
	}
	
	
	public ListNode reorderList(ListNode input) {
		
		if(input == null || input.next == null || input.next.next == null) {
			return input;
		}
		
		ListNode slow = input, fast = input, slowPrev = null, secondHalf;
		
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slowPrev = slow;
			slow = slow.next;
		}
		
		
		
		if(fast == null) {
			slowPrev.next = null;
			secondHalf = slow;
		} else {
			secondHalf = slow.next;
			slow.next = null;
		}
		
		secondHalf = reveseLnkList(secondHalf);
		
		ListNode firstNext, secondNext, newHead = null, appender = null;
		
		while(input != null && secondHalf != null) {
			if(newHead == null) {
				newHead = appender = input;
			} else {
				appender.next = input;
				appender = appender.next;
			}
			
			firstNext = input.next;
			secondNext = secondHalf.next;
			appender.next = secondHalf;
			appender = appender.next;
			input = firstNext;
			secondHalf = secondNext;
			
		}
		if(input != null) {
			appender.next = input;
		}
		
		return newHead;
		
		
    }


	private ListNode reveseLnkList(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		
		ListNode p = null, q = head, r = head.next;
		while(q != null) {
			q.next = p;
			p = q;
			q = r;
			if(r != null) {
				r = r.next;
			}
			
		}
		return p;
		
	}
	
	
}
