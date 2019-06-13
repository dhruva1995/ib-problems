package ib.backtracking;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class KthPermutationSequence {

	public static void main(String[] args) {
		System.out.println(new KthPermutationSequence().getPermutation(3, 2));
	}
	
	
	public String getPermutation(int n, int k) {
		ArrayList<Integer> allNums = IntStream.rangeClosed(1, n)
				.boxed()
				.collect(Collectors.toCollection(ArrayList::new));
		StringBuilder sb = new StringBuilder();
		getPermutationHelper(allNums, n, k - 1, sb);
		return sb.toString();
		
	}
	
	
	private void getPermutationHelper(ArrayList<Integer> available, int level, int k, StringBuilder sb) {
		if(available.isEmpty()) {
			return;
		} else {
			BigInteger nMinus1Factorial = factorial(level - 1);
			int index = BigInteger.valueOf(k).divide(nMinus1Factorial).intValue();
			sb.append(available.remove(index));
			k -= nMinus1Factorial.multiply(BigInteger.valueOf(index)).intValue();
			getPermutationHelper(available, level - 1, k, sb);
		}
	}

	private BigInteger factorial(int number) {
		if(number < 1) {
			return BigInteger.ONE;
		}
		return LongStream.rangeClosed(1, number).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, (a, b) -> a.multiply(b));
	}
	
}
