package ib.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;

public class PalindromePartitioning {

	public static void main(String[] args) {
		
		new PalindromePartitioning().partition("a").forEach(System.out::println);
		
	}
	
	
	public ArrayList<ArrayList<String>> partition(String a) {
		
		ArrayList<ArrayList<String>> result = new ArrayList<>();
		partitionHelper(result, a, new LinkedList<>());
		return result;
		
		
		
    }
	
	private void partitionHelper(ArrayList<ArrayList<String>> result, String strToOperateOn, LinkedList<String> prev) {
		if(strToOperateOn.isEmpty()) {
			result.add(new ArrayList<>(prev));
		} else {
			for(int i = 1; i <= strToOperateOn.length(); i++) {
				if(isPalindrome(strToOperateOn.substring(0, i))) {
					prev.addLast(strToOperateOn.substring(0, i));
					partitionHelper(result, strToOperateOn.substring(i), prev);
					prev.removeLast();
				}
			}
		}
	}
	
	private boolean isPalindrome(String test) {
		int front = 0, back = test.length() - 1;
		while(front < back) {
			if(test.charAt(front) != test.charAt(back)) {
				return false;
			} 
			front++;
			back--;
		}
		return true;
	}
	
	
}
