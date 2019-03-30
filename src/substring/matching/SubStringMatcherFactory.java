package substring.matching;

public class SubStringMatcherFactory {

	
	public static SubStringMatcher getMatcher(SubStrMatchAlgorithmType algoType) {
		try {
			return algoType.algoClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			return NoopSubStrMatcher.instance();
		} 
	} 
	
	
}
