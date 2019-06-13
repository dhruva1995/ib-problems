package ib.linked.lists;

public class IntersectionOfLinkedLists {
	
	
	static class ListNode {
		      public int val;
		      public ListNode next;
		      ListNode(int x) { val = x; next = null; }
	}
	
	
	public static void main(String[] args) {
		ListNode[] nodes = new ListNode[8];
		for(int i = 0; i < nodes.length; i++) {
			nodes[i] = new ListNode(i);
		}
		nodes[0].next = nodes[1];
		nodes[1].next = nodes[2];
		nodes[2].next = nodes[3];
		nodes[4].next = nodes[5];
		
		
		System.out.println(new IntersectionOfLinkedLists().getIntersectionNode(nodes[0], nodes[4]).val);
	}
	
	public ListNode getIntersectionNode(ListNode a, ListNode b) {
		int aLen = findLength(a);
		int bLen = findLength(b);
		int largeLen, smallLen;
		ListNode large, small;
		if(aLen > bLen) {
			large = a;
			small = b;
			largeLen = aLen;
			smallLen = bLen;
		} else {
			small = a;
			large = b;
			largeLen = bLen;
			smallLen = aLen;
		}
		
		while (largeLen > smallLen) {
			large = large.next;
			largeLen--;
		}
		
		while(large != small) {
			large = large.next;
			small = small.next;
		}
		return large;
	
	}

	private int findLength(ListNode trav) {
		int count = 0;
		while(trav != null) {
			count++;
			trav = trav.next;
		}
		return count;
	}
	

}
