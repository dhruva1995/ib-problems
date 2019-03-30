package substring.matching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoyerMooreAsciiMatcher extends SubStringMatcher {

	private static final int d = 256;
	
	private final int[] skipTable = new int[d];
	
	
	@Override
	protected void preProcessCore() {
		Arrays.fill(skipTable, -1);
		for(int i = 0; i < m; i++) {
			skipTable[pattern.charAt(i)] = i;
		}
		
	}
	
	
	
	@Override
	public List<Integer> matchCore() {
		List<Integer> result = new ArrayList<>();
		int skip;
		for(int i = 0; i < n - m + 1; i += skip) {
			skip = 0;
			for(int j = m - 1; j >= 0; j--) {
				if(pattern.charAt(j) != text.charAt(i + j)) {
					skip = Math.max(1, j - skipTable[text.charAt(i + j)]);
				}
			}
			if(skip == 0) {
				result.add(i);
				skip = 1;
			}
			
			
		}
		
		return result;
	}

}
