package strings;

import java.util.Arrays;

public class MultiplyStrings {

	public static void main(String[] args) {
		System.out.println(new MultiplyStrings().multiply("87", "0"));
	}
	
	
    public String multiply(String A, String B) {
    	int[] large, small;
    	if(A.length() > B.length()) {
    		large = A.chars().map(i -> i - '0').toArray();
    		small = B.chars().map(i -> i - '0').toArray();
    	} else {
    		large = B.chars().map(i -> i - '0').toArray();
    		small = A.chars().map(i -> i - '0').toArray();
    	}
    	
    	large = removeStartingZeros(large);
    	small = removeStartingZeros(small);
    	
    	if(small.length == 0 || large.length == 0) {
    		return "0";
    	}
    	
    	int[] result = new int[large.length + small.length];
    	
    	for(int i = small.length - 1; i >= 0; i--) {
    		int[] temp = mulitplyBasic(large, small[i]);
    		shiftSmallNumAndAdd(result, temp, small.length - 1 - i);
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	Arrays.stream(removeStartingZeros(result)).forEach(sb::append);
    	return sb.toString();
    }
	
    
    private void shiftSmallNumAndAdd(int[] large, int[] small, int shift) {
    	int carry = 0;
    	for(int i = small.length - 1, j = large.length - shift - 1; j >= 0; i--, j--) {
    		int other = i >= 0 ? small[i] : 0;
    		int buffer = large[j] + carry + other;
    		large[j] = buffer % 10;
    		carry = buffer / 10;
    		
    	}
    	
    	
    }
    
    
    private int[] mulitplyBasic(int[] bigNum, int digit) {
    	
    	int[] result = new int[bigNum.length + 1];
    	
    	int read = bigNum.length - 1, write = result.length - 1;
    	int carry = 0;
    	while(read >= 0) {
    		int buffer = (bigNum[read] * digit) + carry;
    		result[write] = buffer % 10;
    		carry = buffer / 10;
    		read--;
    		write--;
    	}
    	
    	result[0] = carry;
    	return removeStartingZeros(result);
    	
    	
    	
    }
    
	
    private int[] removeStartingZeros(int[] number) {
    	int firstNonZeroDigit = 0;
    	while(firstNonZeroDigit < number.length && number[firstNonZeroDigit] == 0) {
    		firstNonZeroDigit++;
    	}
    	return firstNonZeroDigit == 0 ? number : Arrays.copyOfRange(number, firstNonZeroDigit, number.length);
    	
    	
    }
    
}
