package ib.linked.lists;

public class RemoveDuplicatesFromSortedList {

	public static void main(String[] args) {
			ListNode list = new RemoveDuplicatesFromSortedList().deleteDuplicates(ListNode.makeLnkListOutOf(1, 2, 2, 3));
			
			while(list != null) {
				System.out.println(list.val);
				list = list.next;
			}
		
	}
	
	
	public ListNode deleteDuplicates(ListNode input) {
		
		ListNode sit = input, run = input.next;
		
		while(sit != null) {
			
			run = sit.next;
			
			while(run != null && sit.val == run.val) {
				run = run.next;
			}
			
			sit.next = run;
			sit = sit.next;
			
		}
		return input;
		
		
    }
	
	
}
