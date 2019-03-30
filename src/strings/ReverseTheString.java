package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class ReverseTheString {

		public String reverseWords(String input) {
			
			ArrayList<String> buffer = Arrays.stream(input.split("\\s+"))
				.collect(Collectors.toCollection(ArrayList::new));
			
			Collections.reverse(buffer);
			
			return buffer
				.stream()
				.collect(Collectors.joining(" "));
			
			
	    }
	
	public static void main(String[] args) {
		System.out.println(new ReverseTheString().reverseWords("the sky is blue    "));
		
	}
	
}
