package ib.linked.lists;

public class RotateList {
	
	
	public static void main(String[] args) {
		ListNode head = new RotateList().rotateRight(ListNode.makeLnkListOutOf(1, 2), 57);
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
		System.out.println("Done");}
	

	public ListNode rotateRight(ListNode input, int elementsFixed) {
		
		int len = findLength(input);
		
		elementsFixed %= len;
		
		if(elementsFixed == 0) {
			return input;
		}
		
		ListNode trav = input, head = input;
		
		for (int i = len - 1; i > elementsFixed; i--) {
			trav = trav.next;
		}
		
		head = trav.next;
		
		trav.next = null;
		
		trav = head;
		while(trav.next != null) {
			trav = trav.next;
		}
		
		trav.next = input;
		
		return head;
    }

	private int findLength(ListNode input) {
		int counter = 1;
		while(input.next != null) {
			counter++;
			input = input.next;
		}
		return counter;
	}
	
}
