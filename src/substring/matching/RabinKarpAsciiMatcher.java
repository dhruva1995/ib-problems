package substring.matching;

import java.util.ArrayList;
import java.util.List;

public class RabinKarpAsciiMatcher extends SubStringMatcher {
	
	private static final int q = 1_000_000_000 + 7;
	
	private static final int d = 256;
	
	private int h;
	
	private int patternHash;

	RabinKarpAsciiMatcher() {}
	
	
	@Override
	public void preProcessCore() {
		h = powMod(d, m - 1, q);
		patternHash = calculateHashOfFirstMCharsIn(pattern);
	}
	
	
	private int calculateHashOfFirstMCharsIn(String x) {
		long hash = 0;
		long baseRaisedToPowerI = 1;
		for(int i = 0; i < m; i++) {
			char coefficient = x.charAt(m - 1 - i);
			hash += (coefficient * baseRaisedToPowerI) % q;
			hash %= q;
			baseRaisedToPowerI *= d;
			baseRaisedToPowerI %= q;
		}
		return (int)hash;
	}


	@Override
	public List<Integer> matchCore() {
		long hashAtShiftS = calculateHashOfFirstMCharsIn(text);
		List<Integer> allMatchingIndices = new ArrayList<>();
		int s = 0;
		while(s < n - m + 1) {
			if(hashAtShiftS == patternHash  && textContainsPattern(text, s)) {
				allMatchingIndices.add(s);
			}
			
			hashAtShiftS = (hashAtShiftS - ((long)text.charAt(s) * h) % q) % q;
			
			hashAtShiftS = (hashAtShiftS * d) % q;
			
			if(m + s != n) {
				hashAtShiftS = (hashAtShiftS + text.charAt(m + s)) % q;
			}
			
			s++;
		} 
		return allMatchingIndices;
	}
	
	private int powMod(int base, int power, int mod) {
		
		if(power == 0) {
			return 1;
		}
		long half = powMod(base, power / 2, mod); 
		
		long result = (half * half) % mod;
		
		return power % 2 == 0 ? (int)result : (int)(result * base) % mod;
	}

}
