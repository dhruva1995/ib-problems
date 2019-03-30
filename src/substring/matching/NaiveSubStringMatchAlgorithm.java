package substring.matching;

import java.util.ArrayList;
import java.util.List;

public class NaiveSubStringMatchAlgorithm extends SubStringMatcher {

	NaiveSubStringMatchAlgorithm() {
	}


	@Override
	public List<Integer> matchCore() {
		List<Integer> allMatchingIndices = new ArrayList<>();
		for (int shift = 0; shift < n - m + 1; shift++) {
			if (super.textContainsPattern(text, shift)) {
				allMatchingIndices.add(shift);
			}
		}
		return allMatchingIndices;
	}

}
