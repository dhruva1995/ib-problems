package ib.hashing;


public class CopyListBestSolution {

	private static class RandomListNode {
		int label;
		RandomListNode next, random;
		RandomListNode(int x) { this.label = x; }
	};
	

	public static void main(String[] args) {
		
	}
	
	
	public RandomListNode copyRandomList(RandomListNode head) {
		
		RandomListNode trav = head;
		
		while(trav != null) {
			RandomListNode prev = trav;
			
			trav = trav.next;
			
			RandomListNode newNode = new RandomListNode(prev.label);
			
			prev.next = newNode;
			
			newNode.next = trav;
			
		}

		trav = head;
		
		while(trav != null) {
			RandomListNode origin = trav;
			RandomListNode duplicate = origin.next;
			if(origin.random != null) {
				duplicate.random = origin.random.next;
			}
			trav = duplicate.next;
		}
		
		RandomListNode newHead = head.next;
		
		RandomListNode prevOriginal = head, prevDuplicate = newHead;
		head.next = null;
		trav = prevDuplicate.next;
		
		while(trav != null) {
			prevOriginal.next = trav;
			prevDuplicate.next = trav.next;
			
			prevOriginal = prevOriginal.next;
			prevDuplicate = prevDuplicate.next;
			
			trav = trav.next.next;
			
			prevOriginal.next = null;
			prevDuplicate.next = null;
			
			
		}
		
		return newHead;
	}
	
}
