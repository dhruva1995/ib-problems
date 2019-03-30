package math;

public class TrailingZerosInFactorial {
	
	
	public static void main(String[] args) {
		System.out.println(new TrailingZerosInFactorial().trailingZeroes(625));
	}
	
	
    public int trailingZeroes(int A) {
    	
    	int pow = 1;
    	int count = 0;
    	
    	while(A >= Math.pow(5, pow)) {
    		count += A / Math.pow(5, pow);
    		pow++;
    	}
    	
    	return count;
    }
}
