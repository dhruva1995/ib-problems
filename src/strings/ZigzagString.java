package strings;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ZigzagString {
	
	public static void main(String[] args) {
		
		System.out.println(new ZigzagString().convert("PAYPALISHIRING", 3));
	}
	
	

	public String convert(String inputText, int rowCount) {
		
		if(rowCount <= 1 || rowCount >= inputText.length()) {
			return inputText;
		}
		
		
		StringBuilder[] sb = IntStream.range(0, rowCount)
				.mapToObj(i -> new StringBuilder())
				.toArray(StringBuilder[]::new);
		
		int readPtr = 0;
		
		int i = 0;
		boolean increment = true;
		while(readPtr < inputText.length()) {
			sb[i].append(inputText.charAt(readPtr++));
			if(i == sb.length - 1) {
				increment = false;
			} else if (i == 0) {
				increment = true;
			}
			if(increment) {
				i++;
			} else {
				i--;
			}
			
		}
		
		return Arrays.stream(sb).map(StringBuilder::toString).collect(Collectors.joining(""));
		
		
    }
	
}
//PAHNAPLSIIGYIR