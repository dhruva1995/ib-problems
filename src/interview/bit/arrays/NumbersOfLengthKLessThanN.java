package interview.bit.arrays;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class NumbersOfLengthKLessThanN {
	
	public static void main(String[] args) {
		System.out.println(new NumbersOfLengthKLessThanN().solve(new ArrayList<>(Arrays.asList(0)), 1, 5));
	}
	
	
    public int solve(ArrayList<Integer> A, int length, int bound) {
        
        int noOfDigitsInC = getNoOfDigitsIn(bound);
        
        if(noOfDigitsInC < length || bound == 0 || length == 0) {
            return 0;
        } else if(noOfDigitsInC > length) {
            int num = A.get(0) == 0 ? A.size() - 1 : A.size();
            for(int i = 1; i <= length; i++) {
            	num *= A.size();
            }
        	return num;
        }
        return getCount(A, length, bound, 1);
    }


	private int getCount(ArrayList<Integer> A, int length, int bound, int i) {
		if(i > getNoOfDigitsIn(bound)) {
			return 0;
		}
		int digit = getDigitAt(bound, i);
		int less = getNoOfDigitsLessThanGivenNumber(A, digit);
		if(i == 1 && A.get(0) == 0 && length != 1) {
			less--;
		}
		for(int j = i + 1; j <= length; j++) {
			less *= A.size();
		}
		
		if(A.contains(digit)) {
			less += getCount(A, length, bound, i + 1);
		}
		return less;
	}
    
    
    private int getDigitAt(int A, int position) {
        int length = getNoOfDigitsIn(A);
        A = (int) (A % (long)Math.pow(10, length - position + 1));
        return A / (int) Math.pow(10, length - position);
    }
    
    private int getNoOfDigitsLessThanGivenNumber(ArrayList<Integer> A, int digit) {
        return A.stream()
                .filter(i -> i < digit)
                .collect(Collectors.counting()).intValue();
    }
    
    
    private int getNoOfDigitsIn(int number) {
        int length = 0;
        while (number > 0) {
            length++;
            number /= 10;
        }
        return length;
    }
    
}
