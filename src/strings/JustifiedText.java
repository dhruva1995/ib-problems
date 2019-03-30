package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JustifiedText {

	public static void main(String[] args) {
		List<String> words = Arrays.asList("What", "must", "be", "shall", "be.");
		new JustifiedText().fullJustify(new ArrayList<>(words), 12).forEach(System.out::println);
		
	}
	
	
	public ArrayList<String> fullJustify(ArrayList<String> words, int lineLimit) {
		ArrayList<String> allLines = new ArrayList<>();
		int read = 0;
		
		while(read < words.size()) {
			
			ArrayList<String> currentLinesWords = new ArrayList<>();
			int wordLength = 0;
			int wordCount = 0;
			while(read < words.size() && wordLength + words.get(read).length() + wordCount <= lineLimit) {
				currentLinesWords.add(words.get(read));
				wordCount += 1;
				wordLength += words.get(read).length();
				read++;
			}
			
			if(read == words.size()) {
				//last line
				StringBuilder lastLineBuilder = new StringBuilder(currentLinesWords.stream().collect(Collectors.joining(" ")));
				while( lineLimit > lastLineBuilder.length()) {
					lastLineBuilder.append(" ");
				}
				allLines.add(lastLineBuilder.toString());
				
				return allLines;
				
			}
			
			if(wordCount == 1) {
				StringBuilder lastLineBuilder = new StringBuilder(currentLinesWords.stream().collect(Collectors.joining(" ")));
				while( lineLimit > lastLineBuilder.length()) {
					lastLineBuilder.append(" ");
				}
				allLines.add(lastLineBuilder.toString());
				continue;
			}
			
			
			int[] spaces = new int[wordCount - 1];
			Arrays.fill(spaces, 1);
			int extraSpaces = lineLimit - wordLength - spaces.length;
			if(extraSpaces / spaces.length > 0) {
				for(int i = 0; i < spaces.length; i++) {
					spaces[i] += extraSpaces / spaces.length;
				}
			}
			
			extraSpaces -= (extraSpaces / spaces.length) * spaces.length;
			
			for(int i = 0; extraSpaces - i > 0; i++) {
				spaces[i] += 1;
			}
			
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < wordCount; i++) {
				sb.append(currentLinesWords.get(i));
				if(i != wordCount - 1) {
					sb.append(IntStream.range(0, spaces[i]).mapToObj(in -> " ").collect(Collectors.joining("")));

				}
			}
			allLines.add(sb.toString());
		}
		return allLines;
    }
	
	
}
