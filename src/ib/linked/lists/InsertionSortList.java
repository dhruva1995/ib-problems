package ib.linked.lists;

public class InsertionSortList {
	
	public static void main(String[] args) {
		new InsertionSortList().insertionSortList(ListNode.makeLnkListOutOf(1, -3, 3, -0)).print();
		
	}
	

	public ListNode insertionSortList(ListNode input) {
		ListNode head = input;
		while (input != null) {
			ListNode next = input.next;
			input.next = null;
			head = insert(head, input);
			input = next;
		}
		
		
		return head;
		
		
    }
	
	
	private ListNode insert(ListNode list, ListNode newNode) {
		
		if(newNode.val < list.val) {
			newNode.next = list;
			return newNode;
		} else {
			ListNode prev = list, trav = list.next;
			while(trav != null && trav.val < newNode.val) {
				prev = trav;
				trav = trav.next;
			}
			prev.next = newNode;
			newNode.next = trav;
			return list;
		}
		
		
	}
	
}
