package code.forces;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ServalAndParenthesisSequence {

	private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception {
		
		int n = Integer.parseInt(reader.readLine());
		
		char[] s = reader.readLine().toCharArray();
		
		if(n % 2 != 0 || s[s.length - 1] == '(') {
			System.out.println(":(");
			return;
		}
		
		int openCount = 0, closeCount = 0;
		for(char c : s) {
			if(c == '(') {
				openCount++;
			} else if(c == ')') {
				closeCount++;
			}
		}
		
		if(openCount > n / 2 || closeCount > n / 2) {
			System.out.println(":(");
			return;
		}
		int open = 0, close = 0;
		for(int i = 0; i < n; i++) {
			if(s[i] == '?') {
				if(openCount < n / 2) {
					s[i] = '(';
					openCount++;
					open++;
				} else {
					s[i] = ')';
					closeCount++;
					close++;
				}
				
			} else if(s[i] == '(') {
				open++;
			} else {
				close++;
			}
			if(open == close && i != n -1) {
				System.out.println(":(");
				return;
			}
			
		}
		
		System.out.println(new String(s));
	}
	
	
}
