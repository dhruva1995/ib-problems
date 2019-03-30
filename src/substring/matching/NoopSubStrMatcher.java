package substring.matching;

import java.util.List;

public class NoopSubStrMatcher extends SubStringMatcher {

	private static final NoopSubStrMatcher instance = new NoopSubStrMatcher();
	
	@Override
	public void preProcessCore() {
		throw new RuntimeException("This implementation suggests you have an issue");
	}
	
	
	@Override
	public List<Integer> matchCore() {
		throw new RuntimeException("This implementation suggests you have an issue");
	}


	public static SubStringMatcher instance() {
		return instance;
	}

}
