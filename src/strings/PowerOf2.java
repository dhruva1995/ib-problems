package strings;

import java.util.Arrays;

public class PowerOf2 {

	
	public static void main(String[] args) {
		//IntStream.range(0, 8197).mapToObj(i -> Integer.toString(i)).filter(s -> new PowerOf2().power(s) == 1).forEach(System.out::println);
		System.out.println(new PowerOf2().power("1"));
	}
	
	
	public int power(String A) {
		if(!A.matches("\\d+")) {
			return 0;
		}
		
		int[] dividend = removeZerosPrefixes(A.chars().map(i -> i - '0').toArray());
		
		while(dividend.length > 0) {
			int[] quotient = new int[dividend.length];
			if(dividend.length == 1 && dividend[0] == 2) {
				return 1;
			}
			int read = 0, carry = 0;
			while (read < dividend.length) {
				quotient[read] = ((carry * 10) + dividend[read]) / 2;
				carry = dividend[read] % 2;
				read++;
			}
			
			if(carry == 1) {
				return 0;
			}
			dividend = removeZerosPrefixes(quotient);
			
		}
		return 0;
		
    }

	private int[] removeZerosPrefixes(int[] number) {
		int startIndex = 0;
		while(startIndex < number.length && number[startIndex] == 0) {
			startIndex++;
		}
		return startIndex == 0 ? number : Arrays.copyOfRange(number, startIndex, number.length);
	}
	
}
