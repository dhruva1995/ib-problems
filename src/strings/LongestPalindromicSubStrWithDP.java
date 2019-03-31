package strings;

public class LongestPalindromicSubStrWithDP {

	public static void main(String[] args) {
		System.out.println(new LongestPalindromicSubStrWithDP().longestPalindrome("abaghfuilhellollow"));
	}
	
	
	
	public String longestPalindrome(String input) {
		
		int n = input.length();
		
		if(input.isEmpty()) {
			return "";
		}
		
		String champ = input.substring(0, 1);
		
		boolean[][] matcher = new boolean[n][];
		
		for(int i = 0; i < n; i++) {
			matcher[i] = new boolean[n];
		}
		
		
		for(int i = 0; i < n; i++) {
			matcher[i][i] = true;
			
		}
		
		
		for(int i = 0; i < n - 1; i++) {
			if(input.charAt(i) == input.charAt(i + 1)) {
				champ = input.substring(i, i + 2);
				matcher[i][i + 1] = true;
			}
		}
		
		for(int len = 3; len <= n; len++) {
			for(int i = 0; i + len <= n; i++) {
				int j = i + len - 1;
				if(input.charAt(i) == input.charAt(j) && matcher[i + 1][j - 1]) {
					matcher[i][j] = true;
					if(champ.length() < len) {
						champ = input.substring(i, i + len);
					}
				}
				
			}
			
		} 
		return champ;
	}
	
	
}
