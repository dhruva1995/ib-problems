package strings;

import java.util.stream.IntStream;

public class IntegerToRoman {

	/*
	 * I = 1 
	 * IV= 4
	 * V = 5
	 * IX= 9 
	 * X = 10 
	 * XL= 40
	 * L = 50
	 * XC= 90 
	 * C = 100
	 * CD= 400 
	 * D = 500 
	 * CM= 900
	 * M = 1000
	 * 
	 * 
	 * 
	 * 
	 */
	
	private static final int[] decimalValues = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};

	private static final String[] romans = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
	
	public String intToRoman(int input) {
		StringBuilder sb = new StringBuilder();
		while(input > 0) {
			int index = doBSAndGetJustLessOrEqualDecimalValuesIndex(input);
			int times = input / decimalValues[index];
			IntStream.range(0, times).forEach(i -> sb.append(romans[index]));
			input -= (decimalValues[index] * times);
		}
		return sb.toString();
	}
	
	private int doBSAndGetJustLessOrEqualDecimalValuesIndex(int number) {
		int low = 0, high = decimalValues.length - 1;
		int result = -1;
		if(number > decimalValues[high]) {
			return high;
		}
		while(low <= high) {
			int mid = low + (high - low) / 2;
			if(number == decimalValues[mid]) {
				return mid;
			} else if(number < decimalValues[mid]) {
				high = mid - 1;
			} else {
				result = mid;
				low = mid + 1;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		
		System.out.println(new IntegerToRoman().intToRoman(99));
		
	}
	
}
