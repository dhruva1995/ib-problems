package ib.hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class WindowString {

	
	public static void main(String[] args) {
		
		System.out.println(new WindowString().minWindow("qwaasfasfdfffffffffffffffffffffffffcwwasfafsfddqddae", "abcd"));
		
	}
	
	
	public String minWindow(String text, String patternsChars) {
		
		
		Map<Character, Long> patternCharCount = patternsChars.chars().mapToObj(i -> (char)i).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		HashMap<Character, Long> textCharCount = new HashMap<>();
		int count = 0, champStart = 0, champEnd = - 1, start = champStart;
		for(int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			textCharCount.computeIfAbsent(c, key -> 0L);
			textCharCount.compute(c, (key, old) -> old + 1);
			count++;
			
			while (arePatternCharsInText(textCharCount, patternCharCount)) {
				if(i - start + 1 < champEnd - champStart + 1 || champEnd == -1) {
					champStart = i - (count - 1);
					champEnd = i;
				}
				
				start++;
				count--;
				textCharCount.compute(text.charAt(start - 1), (key, old) -> old - 1);
				
			}
			
		}
		
		
			return champEnd == -1 ? "" : text.substring(champStart, champEnd + 1);
		
		
		
    }
	
	private boolean arePatternCharsInText(Map<Character, Long> text, Map<Character, Long> pattern) {
		
		for(Entry<Character, Long> e : pattern.entrySet()) {
			
			if(text.containsKey(e.getKey()) && text.get(e.getKey()).longValue() >= pattern.get(e.getKey()).longValue()) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}
	
	
}
