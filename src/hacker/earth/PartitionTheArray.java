package hacker.earth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.stream.Stream;

public class PartitionTheArray {

	private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {

		reader.readLine();

		long[] input = Util.readLongs(reader);
		
		BigInteger leftProduct = BigInteger.valueOf(input[0]), rightProduct = BigInteger.valueOf(input[input.length - 1]);
		BigInteger lastMul = BigInteger.ONE, nextMul = BigInteger.ONE;
		int leftRead = 1, rightRead = input.length - 2;
		
		while(leftRead < rightRead) {
			if(leftProduct.compareTo(rightProduct) < 0) {
				leftProduct = leftProduct.multiply(BigInteger.valueOf(input[leftRead]));
				lastMul = BigInteger.valueOf(input[leftRead]);
				leftRead++;
				
			} else {
				rightProduct = rightProduct.multiply(BigInteger.valueOf(input[rightRead]));
				nextMul = BigInteger.valueOf(input[rightRead]);
				rightRead--;
			}
		}
		
		if(leftProduct.compareTo(rightProduct) == 0) {
			System.out.println(leftRead);
		} else {
			BigInteger diff2 = leftProduct.subtract(rightProduct).abs();
			BigInteger diff1 =  leftProduct.divide(lastMul).subtract(rightProduct.multiply(lastMul)).abs();
			BigInteger diff3 = leftProduct.multiply(nextMul).subtract(rightProduct.divide(nextMul)).abs();
			if(diff2 .compareTo(diff1) <= 0 && diff1.compareTo(diff3) <= 0) {
				System.out.println(leftRead);
			} else if(diff1.compareTo(diff2) <= 0&& diff1.compareTo(diff3) <= 0) {
				System.out.println(leftRead - 1);
			} else {
				System.out.println(leftRead + 1);
			}
			
		}
		

	}
	
	public static long[] readLongs(BufferedReader reader) throws IOException {
		return toLongArray(reader.readLine());
	}
	
	public static long[] toLongArray(String s) {
		return Stream.of(s.split("\\s")).mapToLong(Integer::parseInt).toArray();
    }
}