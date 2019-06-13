package ib.linked.lists;

public class ReverseLinkedList {
	/**
	 * Definition for singly-linked list.
	 */
	static class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static void main(String[] args) {
		ListNode nodes = new ListNode(0);
		ListNode temp = nodes;
		for(int i = 10; i < 10; i++) {
			temp.next = new ListNode(i);
			temp = temp.next;
		}
		
		temp = new ReverseLinkedList().reverseList(nodes);
		while(temp != null) {
			System.out.println(temp.val + ", ");
			temp = temp.next;
		}
		
	}

	public ListNode reverseList(ListNode head) {

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
