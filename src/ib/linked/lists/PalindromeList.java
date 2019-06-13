package ib.linked.lists;


public class PalindromeList {
	
	public static void main(String[] args) {
		ListNode list = ListNode.makeLnkListOutOf(1, 4, 2, 4, 1);
		System.out.println(new PalindromeList().lPalin(list));
		
	}
	
	

	public int lPalin(ListNode input) {
		
		if(input == null || input.next == null) {
			return 1;
		}
		
		
		ListNode fast = input, slow = input, slowsPrev = input;
		
		while(fast != null && fast.next != null) {
			slowsPrev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		
		ListNode reversedTail = reverseList(slowsPrev.next);
		slowsPrev.next = null;
		
		while(input != null) {
			if(input.val != reversedTail.val) {
				return 0;
			}
			input = input.next;
			reversedTail = reversedTail.next;
		}
		
		return 1;
        
    }
	
	
	private ListNode reverseList(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		}

		ListNode p = null, q, r;

		r = head.next;
		q = head;

		while (q != null) {
			q.next = p;
			p = q;
			q = r;
			if (r != null) {
				r = r.next;
			}

		}
		return p;

	}
}
