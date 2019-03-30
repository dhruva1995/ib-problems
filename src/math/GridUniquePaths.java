package math;

import java.math.BigInteger;

public class GridUniquePaths {
	
	public static void main(String[] args) {
		System.out.println(new GridUniquePaths().uniquePaths(15, 9));
	}
	public int uniquePaths(int A, int B) {
		return factorial(A + B - 2).divide(factorial(A - 1).multiply(factorial(B - 1))).intValue();
		
    }
	
    
    
    public BigInteger factorial(int number) {
    	BigInteger result = BigInteger.ONE;
    	for(int i = 1; i <= number; i++) {
    		result = result.multiply(BigInteger.valueOf(i));
    	}
    	return result;
        
    }
	
	
	

}
