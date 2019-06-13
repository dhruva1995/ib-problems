package ib.backtracking;

import java.util.ArrayList;

public class GenerateAllParenthesesII {

	public static void main(String[] args) {
		new GenerateAllParenthesesII().generateParenthesis(1).forEach(System.out::println);
	}
	
	
	public ArrayList<String> generateParenthesis(int count) {
		ArrayList<String> result = new ArrayList<>();
		generateParenthesisHelper(0, 0, 0, new char[count * 2], result);
		return result;
		
		
    }
	
	private void generateParenthesisHelper(int level, int open, int close, char[] prev, ArrayList<String> result) {
		if(level == open + close && level == prev.length) {
			result.add(new String(prev));
			return;
		} else {
			if(open < prev.length / 2) {
				prev[level] = '(';
				generateParenthesisHelper(level + 1, open + 1, close, prev, result);
			}
			if(open - close > 0 && close < prev.length / 2) {
				prev[level] = ')';
				generateParenthesisHelper(level + 1, open, close + 1, prev, result);
			}
		}
		
		
	}
	
}
