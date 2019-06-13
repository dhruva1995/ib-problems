package ib.linked.lists;

public class ReverseLinkListII {

	
	public static void main(String[] args) {
		ListNode result = new ReverseLinkListII().reverseBetween(ListNode.makeLnkListOutOf(1), 1, 1);
		ListNode.printList(result);
	}
	
	
	
	public ListNode reverseBetween(ListNode input, int startIndex, int endIndex) {
		ListNode preStart = null, start = input, end, run, nextToRun;
		int counter = 1;
		while(counter < startIndex) {
			preStart = start;
			start = start.next;
			counter++;
		}
		
		end = start;
		counter = endIndex - startIndex;
		
		if(counter == 0) {
			return input;
		}
		
		run = start.next;
		nextToRun = run.next;
		
		while(counter > 0) {
			counter--;
			end.next = nextToRun;
			run.next = start;
			start = run;
			run = nextToRun;
			if(nextToRun != null) {
				nextToRun = nextToRun.next;
			}
		}
		
		if(preStart == null) {
			return start;
		}
		preStart.next = start;
		
		return input;
    }
	
	
}
