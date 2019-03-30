package substring.matching;

import java.util.List;

public abstract class SubStringMatcher {

	protected String pattern;
	
	protected int m;
	
	protected String text;
	
	protected int n;
	
	public final void preProcess(String subStringToMatchFor) {
		if(subStringToMatchFor == null || subStringToMatchFor.isEmpty()) {
			throw new IllegalArgumentException("Sub-string patter shouldn't be empty");
		}
		this.pattern = subStringToMatchFor;
		this.m = pattern.length();
		this.preProcessCore();
	}
	
	public final List<Integer> findIn(String text) {
		this.text = text;
		this.n = text.length();
		return matchCore();
	}
	
	public abstract List<Integer> matchCore();
	
	protected void preProcessCore() {}
	
	protected boolean textContainsPattern(String text, int at) {
		int m = pattern.length();
		for(int j = 0; j < m; j++) {
			if(text.charAt(at + j) != pattern.charAt(j)) {
				return false;
			}
		}
		return true;
	}
	
}
