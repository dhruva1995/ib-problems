package strings;

import java.util.stream.IntStream;

public class AmazingSubarrays {

	private static final int MOD = 10003;
	
	
	public static void main(String[] args) {
		
		System.out.println(new AmazingSubarrays().solve("ABEC"));
	}
	
	
	public int solve(String A) {
		 
		return IntStream.range(0, A.length())
			.filter(index -> isVowel(A.charAt(index)))
			.mapToObj(index -> A.length() - index)
			.reduce(0, (a, b) -> (a + b) % MOD)
			.intValue() % MOD;
		
		
		
    }
	
	private boolean isVowel(char charToBeExamined) {
		return charToBeExamined == 'a' || charToBeExamined == 'A' 
				|| charToBeExamined == 'e' || charToBeExamined == 'E' 
				|| charToBeExamined == 'i' || charToBeExamined == 'I' 
				|| charToBeExamined == 'o' || charToBeExamined == 'O' 
				|| charToBeExamined == 'u' || charToBeExamined == 'U';
	}
	
}
