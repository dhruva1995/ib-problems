package math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class RandomAttendance {

	public static void main(String[] args) {
		ArrayList<Integer> countForFirstDigit = new RandomAttendance().solve(804289385, new ArrayList<>(Arrays.<Integer>asList(783368691)));
		System.out.println(countForFirstDigit);
	}
	
	public ArrayList<Integer> solve(int A, ArrayList<Integer> B) {
		return B.stream()
				.map(rank -> this.computeNthNumberInLexicalOrderWithinLimit(rank, A))
				.collect(Collectors.toCollection(ArrayList::new));
	}

	private int computeNthNumberInLexicalOrderWithinLimit(int rank, int limit) {
		String withIn = Integer.toString(limit);
		int noOfDigits = withIn.length();
		boolean isMatching = true;
		int[] numberAsDigits = new int[noOfDigits];
		Arrays.fill(numberAsDigits, -1);
		int rankTracer = 0;
		int currentIndex = 0;
		boolean lenReduceOnce = false;
		while (rankTracer != rank && currentIndex < noOfDigits && withIn.length() > 0) {
			Map<Integer, Integer> numbersCount = getCountMapForDigit(withIn, currentIndex == 0 ? 1 : 0);
			Map.Entry<Integer, Integer> numberPrevCount = getNumberFromRange(numbersCount, rank - rankTracer);
			if (numberPrevCount != null) {
				numberAsDigits[currentIndex++] = numberPrevCount.getKey();
				rankTracer += numberPrevCount.getValue();
				if(numberPrevCount.getKey() == withIn.charAt(0) - '0' && isMatching) {
					withIn = withIn.substring(1);
				} else {
					if(withIn.length() > 0 && numberPrevCount.getKey() > withIn.charAt(0) - '0' && !lenReduceOnce) {
						withIn.substring(1);
						lenReduceOnce = true;
					}
					withIn = withIn.substring(1).replaceAll("\\d", "9");
					isMatching = false;
				}
				
			} else {
				break;
			}
		}

		return convertArrayIntoANumber(numberAsDigits);
	}

	private Entry<Integer, Integer> getNumberFromRange(Map<Integer, Integer> numbersCount, int rank) {
		int prev = 0;
		for (Entry<Integer, Integer> e : numbersCount.entrySet()) {
			if (rank > prev && rank <= e.getValue()) {
				final int prevDash = prev;
				return new Map.Entry<Integer, Integer>() {

					@Override
					public Integer getKey() {
						return e.getKey();
					}

					@Override
					public Integer getValue() {
						return prevDash;
					}

					@Override
					public Integer setValue(Integer value) {
						return null;
					}
				};
			}
			prev = e.getValue();
		}
		return null;
	}

	private TreeMap<Integer, Integer> getCountMapForDigit(String withIn, int startWith) {

		TreeMap<Integer, Integer> count = new TreeMap<>();
		int firstDigit = withIn.charAt(0) - '0';
		int i = startWith;
		if(startWith == 0) {
			count.put(-1, 1);
		}
		for (; i < firstDigit; i++) {
			int countForfirstDigit = 0;
			for (int j = 1; j <= withIn.length(); j++) {
				countForfirstDigit += Math.pow(10, j - 1);
			}
			count.put(i, countForfirstDigit);
		}
		if (i == firstDigit) {
			int countForfirstDigit = 0;
			for (int j = 1; j < withIn.length(); j++) {
				countForfirstDigit += Math.pow(10, j - 1);
			}
			if(withIn.length() > 1) {
				countForfirstDigit += Integer.parseInt(withIn.substring(1));
			}
			countForfirstDigit++;
			count.put(i, countForfirstDigit);
			i++;

		}
		for (; i <= 9; i++) {
			int countForfirstDigit = 0;
			for (int j = 1; j <= withIn.length() - 1; j++) {
				countForfirstDigit += Math.pow(10, j - 1);
			}
			count.put(i, countForfirstDigit);
		}

		TreeMap<Integer, Integer> cummulative = new TreeMap<>();
		int cummulativeSum = 0;
		for (Entry<Integer, Integer> entry : count.entrySet()) {
			cummulativeSum += entry.getValue();
			cummulative.put(entry.getKey(), cummulativeSum);
		}
		return cummulative;
	}

	private int convertArrayIntoANumber(int[] numberAsDigits) {
		int number = 0;
		int index = 0;
		while (index < numberAsDigits.length && numberAsDigits[index] != -1) {
			number = (number * 10) + numberAsDigits[index];
			index++;
		}
		return number;
	}

}
