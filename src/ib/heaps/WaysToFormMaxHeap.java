package ib.heaps;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class WaysToFormMaxHeap {

	private static final int MOD = 1000000007;
	
	
	public static void main(String[] args) {
		
		IntStream.range(1, 101).mapToObj(new WaysToFormMaxHeap()::solve).forEach(System.out::println);
		
	}
	
	

	public int solve(int A) {
		
		if(A == 1 || A == 2) {
			return 1;
		}
		

		int height = (int) (Math.log(A) / Math.log(2));

		int sizeOfOneArm = (int) ((A - Math.pow(2, height) + 1 < Math.pow(2, height - 1)) ? Math.pow(2, height - 1) - 1
				: Math.pow(2, height) - 1);

		long buffer = calclateNCM(A - 1, sizeOfOneArm);
		
		buffer *= solve(sizeOfOneArm);
		
		buffer %= MOD;
		
		buffer *= solve(A - 1 - sizeOfOneArm);
		
		buffer %= MOD;
		
		return (int)buffer;

	}

	private int calclateNCM(int n, int m) {

		if (m > n - m) {
			m = n - m;
		}

		long numerator = IntStream.rangeClosed(n - m + 1, n)
				.asLongStream()
				.reduce(1, (a, b) -> (a * b) % MOD);

		BigInteger denominator = IntStream.rangeClosed(1, m)
				.asLongStream()
				.mapToObj(BigInteger::valueOf)
				.reduce(BigInteger.ONE, (a, b) -> a.multiply(b));

		return BigInteger.valueOf(numerator)
				.multiply(denominator.modInverse(BigInteger.valueOf(MOD)))
				.mod(BigInteger.valueOf(MOD))
				.intValue();

	}

}
