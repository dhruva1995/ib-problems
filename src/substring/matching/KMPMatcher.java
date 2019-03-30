package substring.matching;

import java.util.ArrayList;
import java.util.List;

public class KMPMatcher extends SubStringMatcher {

	private int pi[];
	
	KMPMatcher() {}
	
	
	@Override
	public void preProcessCore() {
		pi = new int[m];
		pi[0] = -1;
		int k = -1;
		for(int q = 1; q < m; q++) {
			while(k >= -1 && pattern.charAt(k + 1) != pattern.charAt(q)) {
				if(k == -1) {
					break;
				}
				k = pi[k];
			}
			
			if(pattern.charAt(k + 1) == pattern.charAt(q)) {
				k = k + 1;
			}
			
			pi[q] = k;
			
		}
		
		
	}
	
	@Override
	public List<Integer> matchCore() {
		List<Integer> result = new ArrayList<>();
		int q = -1;
		for(int i = 0; i < n; i++) {
			while(q >= -1 && pattern.charAt(q + 1) != text.charAt(i)) {
				if(q == -1) {
					break;
				}
				q = pi[q];
			}
			
			if(pattern.charAt(q + 1) == text.charAt(i)) {
				q = q + 1;
			}
			
			if(q == m - 1) {
				result.add(i - m + 1);
				q = pi[q];
			}
			
		}
		
		
		return result;
	}

}
