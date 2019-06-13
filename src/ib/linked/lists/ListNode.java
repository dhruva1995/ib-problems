package ib.linked.lists;


public class ListNode {
	public int val;
	public ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}

	public static ListNode makeLnkListOutOf(int... num) {

		if (num.length == 0) {
			return null;
		}

		ListNode head = new ListNode(num[0]), trav = head;
		for (int i = 1; i < num.length; i++) {
			trav.next = new ListNode(num[i]);
			trav = trav.next;
		}
		return head;
	}

	public static void printList(ListNode list) {
		while (list != null) {
			System.out.print(list.val);
			if (list.next != null) {
				System.out.print(" -> ");
			}
			list = list.next;
		}

	}
	@Override
	public String toString() {
		if(this.next == null) {
			return this.val + "";
		} else {
			return this.val + " -> " + this.next.toString();
		}
	}
	
	public void print() {
		System.out.println(toString());
	}
}