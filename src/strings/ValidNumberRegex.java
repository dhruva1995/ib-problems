package strings;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class ValidNumberRegex {
	
public static void main(String[] args) {
		
		List<String> inputs = Arrays.asList(
					"",
					".",
					"0.1",
					"8.0",
					"1.2e",
					"1.2e-03",
					".34e+42",
					"0.42e-2345",
					"1.000001e+0000009",
					"1e9.06",
					"1e1",
					"+12e-12",
					"1.",
					"1.e-34",
					"1.e+",
					"1.e-"
				);
		
		
		
		inputs.forEach(input -> System.out.println(input + " ---> " + new ValidNumber().isNumber(input)));
		System.out.println(new ValidNumber().isNumber("8.0"));
	}

	public int isNumber(final String input) {
		
		return Pattern.matches("^[+-]?((\\d+)|(\\d*(\\.\\d+)))(e[+-]?\\d+)?$", input.trim()) ? 1 : 0;
		
	}
	
	
}
