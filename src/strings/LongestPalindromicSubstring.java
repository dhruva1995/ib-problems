package strings;

public class LongestPalindromicSubstring {
	
	
	private int champLength = 0;

	private int champStart = -1;

	private String input;


	public static void main(String[] args) {
		
		System.out.println(new LongestPalindromicSubstring().longestPalindrome("a"));
		
	}
	
	public String longestPalindrome(String input) {
		
		if(input.isEmpty()) {
			return "";
		}

		this.input = input;

		if (input.length() <= 1) {
			return input;
		}

		for (int i = 0; i < input.length(); i++) {

			checkWithMiddleAs(i);
			checkWithIthCharAsPrev(i);
		}
		return input.substring(champStart, champStart + champLength);

	}

	private void checkWithIthCharAsPrev(int i) {
		int prev = i, next = i + 1;
		int len = 0;
		while(prev >= 0 && next < input.length() && input.charAt(prev) == input.charAt(next)) {
			prev--;
			next++;
			len += 2;
		}
		if (len > champLength) {
			this.champLength = len;
			this.champStart = prev + 1;
		}
		
	}

	private void checkWithMiddleAs(int i) {
		int prev = i - 1, next = i + 1;
		int len = 1;

		while (prev >= 0 && next < input.length() && input.charAt(prev) == input.charAt(next)) {
			prev--;
			next++;
			len += 2;
		}

		if (len > champLength) {
			this.champLength = len;
			this.champStart = prev + 1;
		}

	}

}
