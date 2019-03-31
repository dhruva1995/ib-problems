package ib.bit.manipulations;

public class DivideIntegers {

	public int divide(int dividend, int divisor) {

		long num = dividend, den = divisor;
		
		boolean isResultNegative = dividend < 0 ^ divisor < 0;
		
		num = num < 0 ? -num : num;
		den = den < 0 ? -den : den;	
		
		long quotient = 0;
		
		while(num >= den) {
			long copyDen = den;
			int noOfLeftShift = 0; 
			while(copyDen <= num) {
				copyDen <<= 1;
				noOfLeftShift++;
			}
			noOfLeftShift--;
			quotient += (1L << noOfLeftShift);
			num = num - (den << noOfLeftShift);
		}
		
		if(isResultNegative) {quotient = -quotient;}
		return quotient > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) quotient;
		
	}
	
	public static void main(String[] args) {
		System.out.println(new DivideIntegers().divide(100, -11));
	}

}
