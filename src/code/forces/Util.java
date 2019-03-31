package code.forces;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Util {


	
	public static BigInteger[] toBigIntArray(String s) {
		String[] nums = s.split("\\s");
		return IntStream.range(0, nums.length)
				.boxed()
				.map(index -> new BigInteger(nums[index]))
				.toArray(size -> new BigInteger[size]);
		
	}
	

	
	
	public static String getSpaceSeperatedInts(int[] ints) {
		return Stream.of(ints).map(String::valueOf).collect(Collectors.joining(" "));
	}
	
	public static String getSpaceSeperatedBigInteger(BigInteger[] nums) {
		return Stream.of(nums)
				.map(BigInteger::toString)
				.collect(Collectors.joining(" "));
		
	}
	
	public static boolean isEven(long number) {
		return number % 2 == 0;
	}
	
	public static boolean isOdd(long number) {
		return !isEven(number);
	}
	
	public static boolean isEven(BigInteger number) {
		return !number.testBit(1);
	}
	
	public static boolean isOdd(BigInteger number) {
		return !isEven(number);
	}
	
	public static int[] readInts(BufferedReader reader) throws IOException {
		return toIntArray(reader.readLine());
	}
	
	public static int[] toIntArray(String s) {
		return Stream.of(s.split("\\s")).mapToInt(Integer::parseInt).toArray();
	}
	
	public static long[] readLongs(BufferedReader reader) throws IOException {
		return toLongArray(reader.readLine());
	}
	
	public static long[] toLongArray(String s) {
		return Stream.of(s.split("\\s")).mapToLong(Integer::parseInt).toArray();
    }
	
	public static BigInteger[] readBigInts(BufferedReader reader) throws IOException {
		return toBigIntArray(reader.readLine());
	}
	
	public static char[] readChars(BufferedReader reader) throws IOException {
		return reader.readLine().toCharArray();
	}
	
	public static class Pair<K, V> {
		
		public K first;
		
		public V second;
		
		public Pair(K first, V second) {
			this.first = first;
			this.second = second;
		}
		
		public Pair() {}

		@Override
		public String toString() {
			return "Pair [first=" + first + ", second=" + second + "]";
		}
	}
	
}
