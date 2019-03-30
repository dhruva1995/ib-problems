package substring.matching;

public class TestClass {

	public static void main(String[] args) {

		String text = "ayyapa swamy is a good and fair looking boy ";
		//String text = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		String pattern = "y";
		//String pattern = "air";
		//String pattern = "aaaa";

		SubStringMatcher matcher = SubStringMatcherFactory.getMatcher(SubStrMatchAlgorithmType.BOYER_MOORE_ASCII);

		matcher.preProcess(pattern);
		
		System.out.println(matcher.findIn(text));
		
		
	}

}
