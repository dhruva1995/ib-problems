package strings;

public class MinimumCharactersRequiredToMakeAStringPalindromic {

	
	public static void main(String[] args) {
		System.out.println(new MinimumCharactersRequiredToMakeAStringPalindromic().solve("caabaaac"));
		
	}
	
	
	public int solve(String A) {
		
		if(A.length() <= 1) {
			return 0;
		}
		
		int halfWay = A.length() / 2;
		
		String pattern = A.substring(0, halfWay);
		
		String text = new String(reverse(A.toCharArray()));
		
		int[] pi = computePi(pattern);
		
		int q = -1;
		int m = pattern.length();
		int n = text.length();
		for(int j = 0; j < n; j++) {
			
			while (q >= -1 && pattern.charAt(q + 1) != text.charAt(j)) {
				if(q == -1) {
					break;
				}
				q = pi[q];
			}
			
			if(pattern.charAt(q + 1) == text.charAt(j)) {
				q = q + 1;
			}
			
			if(q == pattern.length() - 1) {
				return j - m + 1;
			}
			
		}
		
		return n - (q + 1);
		
    }
	
	
	
	private int[] computePi(String pattern) {
		int[] pi = new int[pattern.length()];
		pi[0] = -1;
		int k = -1;
		for(int q = 1; q < pi.length; q++) {
			
			while(k >= -1 && pattern.charAt(k + 1) != pattern.charAt(q)) {
				if(k == -1) {break;}
				k = pi[k];
			}
			
			if(pattern.charAt(k + 1) == pattern.charAt(q)) {
				k++;
			}
			pi[q] = k;
			
		}
		
		return pi;
	}



	private char[] reverse(char[] input) {
		int i = 0, j = input.length - 1;
		while(i < j) {
			char temp = input[i];
			input[i] = input[j];
			input[j] = temp;
			i++;
			j--;
		}
		return input;
	}
	
}
