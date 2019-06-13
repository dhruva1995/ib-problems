package dc.code.jam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

	private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(reader.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {

			String result = solve();

			System.out.println("Case #" + testCase + ": " + result);

		}

	}

	private static String solve() throws IOException {
		long[] nl = readLongs(reader);
		int n = (int) nl[0], l = (int) nl[1];
		long[] prods = readLongs(reader);

		long[] nums = new long[(l + 1)];

		for (int i = 1; i < l; i++) {
			nums[i] = gcd(prods[i], prods[i - 1]);
		}

		nums[0] = prods[0] / nums[1];
		nums[l] = prods[l - 1] / nums[l - 1];

		TreeSet<Long> sortedNums = Arrays.stream(nums)
				.boxed()
				.collect(Collectors.toCollection(TreeSet::new));
		TreeMap<Long, Character> mapping = new TreeMap<>();


		for (int i = 0; i < 26; i++) {
			mapping.put(sortedNums.pollFirst(), (char) ('A' + i));
		}

		char[] result = new char[nums.length];
		for (int i = 0; i < nums.length; i++) {
			result[i] = mapping.get(nums[i]);
		}
		return new String(result);
	}

	private static long gcd(long l, long m) {
		long big = Math.max(l, m), small = Math.min(l, m);
		if (small == 0) {
			return big;
		}
		return gcd(small, big % small);
	}

	public static long[] readLongs(BufferedReader reader) throws IOException {
		return toLongArray(reader.readLine());
	}

	public static long[] toLongArray(String s) {
		return Stream.of(s.split("\\s"))
				.mapToLong(Integer::parseInt)
				.toArray();
	}

}
