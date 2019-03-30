package strings;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CompareVersionNumbers {
	
	
	public static void main(String[] args) {
		System.out.println(new CompareVersionNumbers().compareVersion("7.2.0.0", "7.2.0.0.01"));
		
	}
	
	public int compareVersion(String A, String B) {
		List<BigInteger> a = Arrays.stream(A.split("\\.")).map(BigInteger::new).collect(Collectors.toCollection(ArrayList::new));
		List<BigInteger> b = Arrays.stream(B.split("\\.")).map(BigInteger::new).collect(Collectors.toCollection(ArrayList::new));
		a = removeTrailingZeros(a);
		b = removeTrailingZeros(b);
		
		for(int i = 0; i < Math.min(a.size(), b.size()); i++) {
			int result = a.get(i).compareTo(b.get(i));
			if(result != 0) {
				return result;
			}
		}
		
		return Integer.compare(a.size(), b.size()); 
		
		
		
		
    }
	
	private List<BigInteger> removeTrailingZeros(List<BigInteger> input) {
		int i = input.size() - 1;
		for(; i >= 0; i--) {
			if(!input.get(i).equals(BigInteger.ZERO)) {
				break;
			}
		}
		return input.subList(0, i + 1);
	}

}
