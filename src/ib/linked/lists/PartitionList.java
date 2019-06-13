package ib.linked.lists;

public class PartitionList {

	
	public static void main(String[] args) {
		
		ListNode result = new PartitionList().partition(ListNode.makeLnkListOutOf(4), 3);
		ListNode.printList(result);
		
		
	}
	
	public ListNode partition(ListNode list, int key) {
		
		ListNode firstHalf = null, secondHalf = null, firstHalfAppender = null, secondHlfAppender = null;
		
		while(list != null) {
			if(list.val < key) {
				if(firstHalf == null) {
					firstHalf = list;
				} else {
					firstHalfAppender.next = list;
				}
				firstHalfAppender = list;
			} else {
				if(secondHalf == null) {
					secondHalf  = list;
				} else {
					secondHlfAppender.next = list;
				}
				secondHlfAppender = list;
			}
			list = list.next;
		}
		ListNode head = null, appender = null;
		if(firstHalf != null) {
			head = firstHalf;
			appender = firstHalfAppender;
		} 
		
		
		if(secondHalf != null) {
			head = head == null ? secondHalf : head;
			if(appender != null) {
				appender.next = secondHalf;
				secondHlfAppender.next = null;
			}
			
		}
		
		
		
		return head;
		
    }
	
}
