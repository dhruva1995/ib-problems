package ib.linked.lists;

public class ListCycle {

	
	public static void main(String[] args) {
		
		ListNode head = new ListNode(1);
		head.next = head;
		
		System.out.println(new ListCycle().detectCycle(head).val);
		
		
		
		
		
	}
	
	
	
	public ListNode detectCycle(ListNode input) {
		
		ListNode fast = input, slow = input;
		
		boolean start = true;
		
		while ((fast != null && fast.next != null) && (start || fast != slow)) {
			start = false;
			fast = fast.next.next;
			slow = slow.next;
		}
		
		if(fast == null || fast.next == null) {
			return null;
		}
		
		ListNode trav = input;
		
		while(trav != slow) {
			trav = trav.next;
			slow = slow.next;
		}
		
		return trav;
		
    }
	
	
}
