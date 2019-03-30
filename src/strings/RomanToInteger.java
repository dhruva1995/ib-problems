package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RomanToInteger {

	private static final Map<Character, Integer> lookup = new HashMap<>();
	
	static {
		lookup.put('I', 1);
		lookup.put('V', 5);
		lookup.put('X', 10);
		lookup.put('L', 50);
		lookup.put('C', 100);
		lookup.put('D', 500);
		lookup.put('M', 1000);
	}
	
	
	public int romanToInt(String input) {
		List<String> tokens = new ArrayList<>();
		int read = 0;
		
		while(read < input.length()) {
			int start = read;
			
			while(read < input.length() && input.charAt(start) == input.charAt(read)) {
				
				read++;
			}
			
			tokens.add(input.substring(start, read));
			
		}
		
		LinkedList<Integer> allTokens = tokens.stream().map(this::convertSimpleTokens).collect(Collectors.toCollection(LinkedList::new));
		
		while(allTokens.size() > 1) {
			
			int right = allTokens.removeLast();
			int left = allTokens.removeLast();
			
			int result = right > left ? right - left : right + left;
			allTokens.addLast(result);
		}
		
		return allTokens.isEmpty() ? 0 : allTokens.removeFirst();
    }
	
	
	
	
	
	
	private int convertSimpleTokens(String input) {
		
		int valuePerChar = lookup.get(input.charAt(0));
		
		return valuePerChar * input.length();
	}
	
	
}
