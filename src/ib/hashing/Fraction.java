package ib.hashing;

import java.util.HashMap;
import java.util.HashSet;

public class Fraction {

	public static void main(String[] args) {
		System.out.println(new Fraction().fractionToDecimal(1, Integer.MIN_VALUE));
		System.out.println(new Fraction().fractionToDecimal(1, 33));
	}

	public String fractionToDecimal(int a, int b) {
		
		StringBuilder sb = new StringBuilder();
		
		if(a == 0) {
			return "0";
		}
		
		if(a < 0 ^ b < 0) {
			sb.append("-");
		}
		
		long numerator = a, denominator = b;
		
		numerator = Math.abs(numerator);
		denominator = Math.abs(denominator);
		
		sb.append(numerator / denominator);
		
		numerator %= denominator;
		
		numerator *= 10;
		
		if(numerator != 0) {
			sb.append(".");
			HashMap<Long, Integer> map = new HashMap<>();
			
			while(numerator != 0 && !map.containsKey(numerator)) {
				map.put(numerator, sb.length());
				
				sb.append(numerator / denominator);
				
				numerator %= denominator;
				
				numerator *= 10;
				
			}
			if(numerator != 0) {
				sb.insert(map.get(numerator), "(");
				sb.append(")");
			}
		}
		return sb.toString();
	}

}
