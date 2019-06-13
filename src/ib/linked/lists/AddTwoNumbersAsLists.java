package ib.linked.lists;

public class AddTwoNumbersAsLists {

	
	public static void main(String[] args) {
		new AddTwoNumbersAsLists().addTwoNumbers(ListNode.makeLnkListOutOf(1), ListNode.makeLnkListOutOf(1, 0, 1)).print();
	}
	
	
	
	public ListNode addTwoNumbers(ListNode num1, ListNode num2) {
		
		if(num1 == null) {
			return num2;
		} else if (num2 == null) {
			return num1;
		}
		
		ListNode appender = new ListNode((num1.val + num2.val) % 10), result = appender;
		int carry = (num1.val + num2.val) / 10; 
		num1 = num1.next; num2 = num2.next;
		while (num1 != null && num2 != null) {
			int sum = num1.val + num2.val + carry;
			carry = sum / 10;
			appender.next = new ListNode(sum % 10);
			appender = appender.next;
			
			num1 = num1.next;
			num2 = num2.next;
		}
		
		while(num1 != null) {
			int sum = carry + num1.val;
			appender.next = new ListNode(sum % 10);
			appender = appender.next;
			carry = sum / 10;
			num1 = num1.next;
		}
		
		while(num2 != null) {
			int sum = carry + num2.val;
			appender.next = new ListNode(sum % 10);
			appender = appender.next;
			carry = sum / 10;
			num2 = num2.next;
		}
		
		if(carry != 0) {
			appender.next = new ListNode(carry);
		}
		
		removeSuffixingZeros(result);
		
		return result;
    }



	private void removeSuffixingZeros(ListNode sit) {
		while (sit != null) {
			ListNode run = sit.next;
			while(run != null && run.val == 0) {
				run = run.next;
			}
			if(run == null) {
				sit.next = null;
			}
			sit = sit.next;
		}

	}
	
	
}
