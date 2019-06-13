package ib.linked.lists;

public class RemoveDuplicatesFromSortedListII {

	public static void main(String[] args) {
		ListNode list = new RemoveDuplicatesFromSortedListII().deleteDuplicates(ListNode.makeLnkListOutOf(1, 1, 1, 1, 1,
				1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 6, 7, 7, 7, 7, 8, 8, 8, 9, 9, 9, 9, 9,
				10, 10, 10, 10, 10, 10, 11, 11, 11, 11, 11, 11, 11, 12, 12, 12, 13, 13, 13, 14, 14, 14, 15, 15, 15, 15,
				15, 16, 16, 16, 16, 17, 18, 18, 19, 19, 19, 19, 19, 19, 19, 19, 20, 20, 20, 20, 20, 20, 20, 20, 20));

		while (list != null) {
			System.out.println(list.val);
			list = list.next;
		}
	}

	public ListNode deleteDuplicates(ListNode A) {

		ListNode head = null, sit = null, read = A;

		while (read != null) {

			if (!hasDuplicate(read)) {
				if (sit == null) {
					sit = head = read;
				} else {
					sit.next = read;
					sit = sit.next;
				}
				read = read.next;
			} else {
				ListNode test = read;
				while (read != null && read.val == test.val) {
					read = read.next;
				}
			}

		}
		if(sit != null) {
			sit.next = null;
		}
		return head;

	}

	private boolean hasDuplicate(ListNode read) {
		if (read.next != null) {
			return read.val == read.next.val;
		}
		return false;
	}

}
