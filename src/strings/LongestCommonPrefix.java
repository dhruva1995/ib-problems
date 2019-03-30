package strings;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestCommonPrefix {

	public static void main(String[] args) {

		System.out.println(new LongestCommonPrefix().longestCommonPrefix(new ArrayList<>(Arrays.asList("ab", "abc", "abb"

		)

		)));

	}

	public String longestCommonPrefix(ArrayList<String> A) {
		int maxLength = A.stream()
				.mapToInt(String::length)
				.min()
				.getAsInt();
		StringBuilder sb = new StringBuilder();
		sb.ensureCapacity(maxLength);
		for (int i = 0; i < maxLength; i++) {
			char testCharacter = A.get(0).charAt(i);
			boolean allGood = true;
			for (int s = 1; s < A.size(); s++) {
				if(A.get(s).charAt(i) != testCharacter) {
					allGood = false;
					break;
				}
			}
			if(allGood) {
				sb.append(testCharacter);
			} else {
				break;
			}

		}
		return sb.toString();
	}

}
