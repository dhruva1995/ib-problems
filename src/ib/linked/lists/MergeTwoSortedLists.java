package ib.linked.lists;

public class MergeTwoSortedLists {

	public static void main(String[] args) {
		ListNode a = ListNode.makeLnkListOutOf(1, 2, 2, 3);
		ListNode b = ListNode.makeLnkListOutOf(2);
		
		ListNode list = new MergeTwoSortedLists().mergeTwoLists(a, b);
				while(list != null) {
					System.out.println(list.val);
					list = list.next;
				}
		
	}
	
	
	
	
	public ListNode mergeTwoLists(ListNode A, ListNode B) {
		
		ListNode head = null, prev = null;
		
		if(A == null) {
			return B;
		} else if(B == null) {
			return A;
		}
		
		while(A != null && B != null) {
			ListNode currentNode;
			if(A.val < B.val) {
				currentNode = A;
				A = A.next;
			} else {
				currentNode = B;
				B = B.next;
			}
			if(head == null) {
				head = prev = currentNode;
			} else {
				prev.next = currentNode;
				prev = prev.next;
			}
		}
		
		if(A != null) {
			prev.next = A;
		} else {
			prev.next = B;
		}
		return head;
    }
	
	
}
