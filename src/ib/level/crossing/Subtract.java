package ib.level.crossing;

import ib.linked.lists.ListNode;

public class Subtract {

	public static void main(String[] args) {
		
		new Subtract().subtract(ListNode.makeLnkListOutOf(1, 7)).print();
		
	}
	
	public ListNode subtract(ListNode A) {
		
		if(A == null || A.next == null) {
			return A;
		}
		
		ListNode fast = A, slow = A, prevSlow = A;
		while(fast != null && fast.next != null) {
			prevSlow = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		
		prevSlow.next = null;
		ListNode revSecondHalf = reverseLnkList(slow);
		ListNode firstHalfTrav = A, secondHalfTrav = revSecondHalf;
		while(firstHalfTrav != null) {
			firstHalfTrav.val = secondHalfTrav.val - firstHalfTrav.val;
			firstHalfTrav = firstHalfTrav.next;
			secondHalfTrav = secondHalfTrav.next;
		}
		
		prevSlow.next = reverseLnkList(revSecondHalf);
		return A;
		
    }
	
	private ListNode reverseLnkList(ListNode head) {
		
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
