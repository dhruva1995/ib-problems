package math;

import java.math.BigInteger;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class SortedPermutationRankWithRepeats {

	
	
	public static void main(String[] args) {
		//System.out.println(new SortedPermutationRankWithRepeats().findRank("bbbbaaaa")); -> 70
		System.out.println(new SortedPermutationRankWithRepeats().findRank("asasdsdsadasdadsadasdsa"));
		
		
		
	}
	private static final int MOD = 1000003;
	
	public int findRank(String A) {
		
		long count = 1;
		
		TreeMap<Character, Long> charCount = A.chars()
		 .mapToObj(i -> new Character((char)i))
		 .collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()));
		
		for (int i = 0; i < A.length() - 1; i++) {
			final int index = i;
			char examining = A.charAt(i);
			long currentPremtation = charCount.keySet()
					.stream()
					.filter(chars -> chars < examining)
					.mapToLong(fixedChar -> getTotalPermutations(fixedChar, charCount,
							A.length() - index - 1))
					.sum();

			count += currentPremtation;
			if (currentPremtation == 1) {
				break;
			} 
			int chrCount = charCount.get(examining).intValue();
			if(chrCount == 1) {
				charCount.remove(examining);
			} else {
				charCount.put(examining, (long)chrCount - 1);
			}

			count %= MOD;

		}
		
		
		return (int)count % MOD;
		
		
		
    }
	
	
	
	
	private int getTotalPermutations(char fixedChar, TreeMap<Character, Long> charCount, int numeratorLen) {
		charCount.computeIfPresent(fixedChar, (key, oldValue) -> oldValue - 1);
		
		long denominator = charCount.values()
									.stream()
									.mapToInt(i -> i.intValue())
									.mapToLong(i -> getFactorialMod(i))
									.reduce(1, (a, b) -> a * b % MOD) % MOD;
		int numerator = getFactorialMod(numeratorLen);
		
		charCount.computeIfPresent(fixedChar, (key, oldValue) -> oldValue + 1);
		return divisionMod(numerator, denominator);
	}

	private int getFactorialMod(int number) {
		return (int) LongStream.rangeClosed(1, number)
			.reduce(1, (a, b) -> a * b % MOD) % MOD;
	}
	
	
	private int divisionMod(long numerator, long denomerator) {
		int denominatorInverse = findModularMultiplicativeInverseOf(denomerator, MOD);
		return (int)((numerator * denominatorInverse) % MOD);
	}

	private int findModularMultiplicativeInverseOf(long denomerator, int mod) {
		return BigInteger.valueOf(denomerator).modPow(BigInteger.valueOf(mod - 2), BigInteger.valueOf(mod)).intValue();
	}
	
	
}
