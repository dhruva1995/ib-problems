package strings;

import java.util.Arrays;
import java.util.List;

public class ValidNumber {

	
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
		String A = input.trim();
		int eIndex = A.indexOf('e');
		boolean result;
		if(eIndex == -1) {
			result = validateFloatingNumber(A);
		} else {
			result = validateFloatingNumber(A.substring(0, eIndex)) && validateInteger(A.substring(eIndex + 1));
		}
		return result ? 1 : 0;
    }

	private boolean validateInteger(String substring) {
		if(substring.isEmpty()) {
			return false;
		}
		int read = 0;
		
		if(substring.charAt(0) == '-' || substring.charAt(0) == '+') {
			read++;
		}
		
		if(substring.length() == read) {
			return false;
		}
		
		while (read < substring.length()) {
			if(Character.isDigit(substring.charAt(read))) {
				read++;
			} else {
				return false;
			}
		}
		
		return read == substring.length();
	}

	private boolean validateFloatingNumber(String a) {
		
		if(a.isEmpty()) {
			return false;
		}
		int dotCount = 0;
		int dotIndex = -1;
		
		for(int i = 0; i < a.length(); i++) {
			if(a.charAt(i) == '.') {
				dotCount++;
				dotIndex = i;
			}
		}
		
		if(dotCount > 1) {
			return false;
		}
		
		else if(dotCount == 0) {
			return validateInteger(a);
		} 
		else {
			if(a.substring(0, dotIndex).isEmpty() || validateInteger(a.substring(0, dotIndex))) {
				if(dotIndex == a.length() - 1) {
					return false;
				}
				for(int i = dotIndex + 1; i < a.length(); i++) {
					if(!Character.isDigit(a.charAt(i))) {
						return false;
					}
				}
				return true;
			}
			return false;
		}
	}
	
	
}
