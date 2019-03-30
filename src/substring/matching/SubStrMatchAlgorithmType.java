package substring.matching;

public enum SubStrMatchAlgorithmType {

	NAIVE(NaiveSubStringMatchAlgorithm.class),
	RABIN_KARP_ASCII(RabinKarpAsciiMatcher.class),
	FINITE_AUTOMATON_ASCII(FiniteStateAutomatonAsciiMatcher.class),
	KMP_MATCHER(KMPMatcher.class),
	BOYER_MOORE_ASCII(BoyerMooreAsciiMatcher.class)
	;
	
	
	
	@SuppressWarnings("unchecked")
	SubStrMatchAlgorithmType(Class<?> algoClass) {
		this.algoClass = (Class<SubStringMatcher>) algoClass;
	}
	
	
	final Class<? extends SubStringMatcher> algoClass;
}
