package ib.hashing;

import java.util.HashMap;

public class CopyList {

	private static class RandomListNode {
		int label;
		RandomListNode next, random;
		RandomListNode(int x) { this.label = x; }
	};
	
	
    public RandomListNode copyRandomList(RandomListNode head) {
    	
    	if(head == null) {
    		return null;
    	}
    	
    	HashMap<RandomListNode, RandomListNode> mapper = new HashMap<>();
    	
    	RandomListNode trav = head;
    	
    	while(trav != null) {
    		mapper.put(trav, new RandomListNode(trav.label));
    		trav = trav.next;
    	}
    	
    	RandomListNode newHead = mapper.get(head);
    	RandomListNode read = head, write = newHead;
    	while(read != null) {
    		if(read.next != null) {
    			write.next = mapper.get(read.next);
    		}
    		
    		if(read.random != null) {
    			write.random = mapper.get(read.random);
    		}
    		
    		read = read.next;
    		write = write.next;
    	}
    	
    	return newHead;
    }
	
	
}
