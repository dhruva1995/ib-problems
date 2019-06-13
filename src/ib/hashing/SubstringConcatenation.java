package ib.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class SubstringConcatenation {

	
	public static void main(String[] args) {
		System.out.println(new SubstringConcatenation().findSubstring("barfoothefoobarman", Arrays.asList("foo", "bar")));
		
	}
	
	
	public ArrayList<Integer> findSubstring(String mainString, final List<String> subStrings) {
		if(subStrings.isEmpty()) {
			return new ArrayList<>();
		}
		
		ArrayList<Integer> result = new ArrayList<>();
		
		int wordLength = subStrings.get(0).length();
		
		int sentenceLength = wordLength * subStrings.size();
		
		HashMap<String, Long> masterCopy = subStrings.stream().collect(Collectors.groupingBy(s -> s, HashMap::new, Collectors.counting()));
		
		for(int i = 0; i <= mainString.length() - sentenceLength; i++) {
			
			@SuppressWarnings("unchecked")
			HashMap<String, Long> copy = (HashMap<String, Long>) masterCopy.clone();
			
			String currentSentence = mainString.substring(i, i + sentenceLength);
			
			int currentSubStringConsumption = sentenceLength;
			
			for(int j = 0; j < currentSentence.length(); j += wordLength) {
				String word = currentSentence.substring(j, j + wordLength);
				if(copy.containsKey(word) && copy.get(word) > 0) {
					copy.compute(word, (key, old) -> old - 1);
					currentSubStringConsumption -= wordLength;
				} else {
					break;
				}
			}
			
			if(currentSubStringConsumption == 0) {
				result.add(i);
			}
		}
		
		
		return result;
		
    }
	
}
