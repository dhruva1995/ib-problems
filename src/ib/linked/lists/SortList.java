package ib.linked.lists;

public class SortList {

	public static void main(String[] args) {
		new SortList().sortList(ListNode.makeLnkListOutOf(2, 1, 3, 0, -1)).print();
	}
	
	
	
	 public ListNode sortList(ListNode inputList) {
		 
		 if(inputList == null || inputList.next == null) {
			 return inputList;
		 }
		 
		 ListNode fast = inputList, slow = inputList, prevSlow = null;
		 
		 while(fast != null && fast.next != null) {
			 prevSlow = slow;
			 slow = slow.next;
			 fast = fast.next.next;
		 }
		 
		 prevSlow.next = null;
		 
		 ListNode firstHalf = sortList(inputList);
		 ListNode secondHalf = sortList(slow);
		 return mergeSortedLists(firstHalf, secondHalf);
		 
	 }
	 
	 private ListNode mergeSortedLists(ListNode list1, ListNode list2) {
		 ListNode resultHead = null, appender = null;
		 
		 if(list1 == null) {
			 return list2;
		 } 
		 if(list2 == null) {
			 return list1;
		 }
		 while(list1 != null && list2 != null) {
			 ListNode currentNode;
			 if(list1.val < list2.val) {
				 currentNode = list1;
				 list1 = list1.next;
			 } else {
				 currentNode = list2;
				 list2 = list2.next;
			 }
			 if(resultHead == null) {
				 resultHead = currentNode;
			 } else {
				 appender.next = currentNode;
			 }
			 appender = currentNode;
		 }
		 if(list1 != null) {
			 appender.next = list1;
		 } else {
			 appender.next = list2;
		 }
		 return resultHead;
		 
	 }
	
}
