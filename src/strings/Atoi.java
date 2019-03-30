package strings;

import java.util.Arrays;
import java.util.List;

public class Atoi {

	public static void main(String[] args) {
		
		List<String> inputs = Arrays.asList(
				"-",
				"-12",
				"-abc",
				"-0abc",
				"-001abc",
				"12",
				"0",
				"",
				"abc",
				"01abc",
				"001abc",
				"+12",
				"+abc",
				"+0abc",
				"+001abc",
				Long.toString(Integer.MAX_VALUE + 1L),
				Long.toString(Integer.MAX_VALUE),
				Long.toString(Integer.MIN_VALUE - 1234L),
				Long.toString(Integer.MIN_VALUE)
				);
		
		inputs.forEach(input -> System.out.println(input + " -> " + new Atoi().atoi(input)));
	}
	
	
	public int atoi(final String input) {
		boolean isPositive = true;
		int read = 0;
		long result = 0;
		int len = input.length();
		
		if(len == 0) {
			return 0;
		}
		
		if(input.charAt(read) == '-') {
			isPositive = false;
			read++;
		} else if(input.charAt(read) == '+') {
			read++;
		}
		while(read < len && input.charAt(read) == '0') {
			read++;
		}
		
		int numEnd = read;
		
		while(numEnd < len && Character.isDigit(input.charAt(numEnd))) {
			numEnd++;
		}
		
		while(read < numEnd) {
			result = (result * 10) + (input.charAt(read) - '0');
			if(isPositive && result >= Integer.MAX_VALUE) {
				return Integer.MAX_VALUE;
			} else if(!isPositive && -result <= Integer.MIN_VALUE) {
				return Integer.MIN_VALUE;
			}
			read++;
		}
		return (int)(isPositive ? result : -result);
    }
	
}
