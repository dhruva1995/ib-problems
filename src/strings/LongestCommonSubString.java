package strings;

public class LongestCommonSubString {

	public String findLongestCommonSubString(String str1, String str2) {

		int n = str1.length();
		int m = str2.length();
		int[][] matches = new int[n][];

		for (int i = 0; i < n; i++) {
			matches[i] = new int[m];
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (str1.charAt(i) != str2.charAt(j)) {
					continue;
				}

				int prev;
				if (i == 0 || j == 0) {
					prev = 0;
				} else {
					prev = matches[i - 1][j - 1];
				}
				matches[i][j] = prev + 1;
			}

		}

		int champI = 0;
		int maxLength = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (maxLength < matches[i][j]) {
					maxLength = matches[i][j];
					champI = i;
				}
			}
		}
		//System.out.println(maxLength);

		return str1.substring(champI - (maxLength - 1), champI + 1);

	}

	public static void main(String[] args) {

		System.out.println(new LongestCommonSubString().
				findLongestCommonSubString("aegghell", "bcdegahelp"));

	}

}
