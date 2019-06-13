package ib.backtracking;

import java.util.ArrayList;

public class LetterPhone {

	public static void main(String[] args) {
		
		new LetterPhone().letterCombinations("230").forEach(System.out::println);
	}
	
	
	
	public ArrayList<String> letterCombinations(String A) {
		ArrayList<String> result = new ArrayList<>();
		letterCombinationsHelper(A, 0, result, new char[A.length()]);
		return result;
    }
	
	private void letterCombinationsHelper(String A, int currentIndex, ArrayList<String> buffer, char[] prev) {
		if(A.length() == currentIndex) {
			buffer.add(new String(prev));
		} else {
			for(char c : getAlphabetsCorrespondingToADigit(A.charAt(currentIndex))) {
				prev[currentIndex] = c;
				letterCombinationsHelper(A, currentIndex + 1, buffer, prev);
			}
		}
	}
	
	private char[] getAlphabetsCorrespondingToADigit(char digit) {
		switch (digit) {
		case '0':
		case '1':
			return new char[]{digit};
		case '2':
			return "abc".toCharArray();
		case '3':
			return "def".toCharArray();
		case '4':
			return "ghi".toCharArray();
		case '5':
			return "jkl".toCharArray();
		case '6':
			return "mno".toCharArray();
		case '7':
			return "pqrs".toCharArray();
		case '8':
			return "tuv".toCharArray();
		case '9':
			return "wxyz".toCharArray();
			
		}
		return new char[] {};
		
	}
	
	
}
