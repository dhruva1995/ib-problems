package ib.linked.lists;

public class KReverseLinkedList {
	
	
	public static void main(String[] args) {
		ListNode result = new KReverseLinkedList().reverseList(ListNode.makeLnkListOutOf(1, 2, 3, 4 ,5 ,6), 3);
		
		ListNode.printList(result);
		
		
	}
	
	
	public ListNode reverseList(ListNode inputList, int k) {
		
		ListNode newHead = null, appender = null;
		
		while(inputList != null) {
			int counter = 1;
			
			ListNode sit = inputList, run = sit, nextSit;
			
			while(counter < k) {
				counter++;
				run = run.next;
			}
			nextSit = run.next;
			run.next = null;
			
			ListNode kRevList = reverse(sit);
			if(newHead == null) {
				appender = newHead = kRevList;
			} else {
				appender.next = kRevList;
				
			}
			while(appender.next != null) {
				appender = appender.next;
			}
			
			inputList = nextSit;
		}
		
		return newHead;
		
    }
	
	
	private ListNode reverse(ListNode list) {
		if(list == null || list.next == null) {
			return list;
		}
		ListNode p = null, q = list, r = q.next;
		
		while(q != null) {
			q.next = p;
			p = q;
			q = r;
			if(r != null) {
				r = r.next;
			}
			
		}
		return p;
	}
}
