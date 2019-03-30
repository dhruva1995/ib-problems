package interview.bit.arrays;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class RepeatAndMissingNumber {

	public static void main(String[] args) {
		List<Integer> listOfNums = Arrays.asList(IntStream.rangeClosed(1, 1000000).boxed().toArray(n -> new Integer[n]));
		listOfNums.set(0, 100000);
		System.out.println(new RepeatAndMissingNumber().repeatedNumber(
				listOfNums
				)
				);
	}

	public ArrayList<Integer> repeatedNumber(final List<Integer> A) {

		long sumActual = 0;

		BigInteger sumOfSquaredActual = BigInteger.ZERO;
		
		for (int i = 0; i < A.size(); i++) {

			sumActual += A.get(i);

			sumOfSquaredActual = sumOfSquaredActual.add(BigInteger.valueOf((long)A.get(i) * A.get(i)));
		}
		int n = A.size();
		long sumExpected = ((long)n * (n + 1)) / 2;
		BigInteger sumOfSquaredExpected = BigInteger.valueOf((long)n * (n + 1)).multiply(BigInteger.valueOf((2 * n) + 1))
				.divide(BigInteger.valueOf(6));

		long difference = sumExpected - sumActual;
		long sum = sumOfSquaredExpected.subtract(sumOfSquaredActual).divide(BigInteger.valueOf(difference)).longValue();
		int missing = (int)(sum + difference) / 2;
		int repeated = (int) (missing - difference);
		

		return new ArrayList<>(Arrays.asList(repeated, missing));
	}

}
