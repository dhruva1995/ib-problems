package ib.linked.lists;

public class RemoveNthNodeFromListEndUsing2Pointers {
	
	public static void main(String[] args) {
		ListNode head = new RemoveNthNodeFromListEndUsing2Pointers().removeNthFromEnd(null, 0);
		while(head != null) {
			System.out.println(head.val);
			head = head.next;
		}
		System.out.println("Done");
	}
	
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		
		ListNode ahead = head;
		
		if(head == null || n <= 0) {
			return head;
		}
		
		
		for(int i = 0; i < n; i++) {
			if(ahead == null) {
				return head.next;
			}
			ahead = ahead.next;
		}
		
		ListNode behind = head, behindPrev = null;
		
		while(ahead != null) {
			behindPrev = behind;
			behind = behind.next;
			ahead = ahead.next;
		}
		
		if(ahead == null && behindPrev == null) {
			return head.next;
		}
		
		behindPrev.next = behind.next;
		behind.next = null;
		
		return head;
	}
    
	


	
	
}
