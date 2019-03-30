package math;

public class ReverseInteger {
	
	
	public static void main(String[] args) {
		System.out.println(new ReverseInteger().reverse(Integer.MIN_VALUE));
	}
	
	public int reverse(int A) {
		long input = Math.abs(A);
		long result = 0;
		while(input > 0) {
			result = (result * 10) + (input % 10);
			input /= 10;
		}
		if(A < 0) {
			result = -result;
		}
		return result > Integer.MAX_VALUE || result < Integer.MIN_VALUE ?
			 0 : (int)result;
		
    }

}
