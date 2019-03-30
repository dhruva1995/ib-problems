package substring.matching;

import java.util.ArrayList;
import java.util.List;

public class FiniteStateAutomatonAsciiMatcher extends SubStringMatcher {

	private static final int d = 256;
	
	private int[][] transition;
	
	
	@Override
	public void preProcessCore() {
		transition = new int[d][];
		for(int i = 0; i < d; i++) {
			transition[i] = new int[m + 1];
		}
		StringBuffer pqa = new StringBuffer();
		for(int q = 0; q <= m; q++) {
			if (q > 0) {
				pqa.append(pattern.charAt(q - 1));
			}
			for(char a = 0; a < d; a++) {
				pqa.append(a);
				int k = Math.min(m + 1, q + 2);
				do {
					k--;
				} while(k > 0 && !pqa.toString().endsWith(pattern.substring(0, k)));
				transition[a][q] = k;
				pqa.deleteCharAt(pqa.length() - 1);
			}
		}
	}
	
	
	@Override
	public List<Integer> matchCore() {
		int q = 0;
		List<Integer> result = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			char c = text.charAt(i);
			q = transition[c][q];
			if(q == m) {
				result.add(i - m + 1);
			}
		}
		return result;
	}
}
