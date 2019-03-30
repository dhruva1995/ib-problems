package strings;

public class ImplementStrStr {

	public int strStr(final String text, final String pattern) {

		if (pattern.length() == 0 || text.length() < pattern.length()) {
			return -1;
		}

		int m = pattern.length();
		int n = text.length();

		int[] pi = computePi(pattern);
		int q = -1;
		for(int j = 0; j < n; j++) {
			
			while(q >= -1 && pattern.charAt(q + 1) != text.charAt(j)) {
				if(q == -1) {
					break;
				}
				q = pi[q];
			}
			
			if(pattern.charAt(q + 1) == text.charAt(j)) {
				q += 1;
			}
			
			if(q == m - 1) {
				return j - m + 1;
			}
		}
		return -1;

	}

	private int[] computePi(String pattern) {
		int m = pattern.length();
		int[] pi = new int[m];
		int k = -1;
		pi[0] = -1;
		for (int q = 1; q < m; q++) {

			while (k >= -1 && pattern.charAt(k + 1) != pattern.charAt(q)) {
				if (k == -1) {
					break;
				}
				k = pi[k];
			}

			if (pattern.charAt(k + 1) == pattern.charAt(q)) {
				k += 1;
			}

			pi[q] = k;

		}

		return pi;
	}

}
