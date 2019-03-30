package interview.bit.arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class Factors {
	
	
	public static void main(String[] args) {
		System.out.println(new Factors().allFactors(82944));
	}

	public ArrayList<Integer> allFactors(int A) {
		ArrayList<Integer> factorsFromStart = new ArrayList<>();
		LinkedList<Integer> factorsFromLast = new LinkedList<>();

		IntStream.rangeClosed(1, (int) Math.sqrt(A))
				.filter(i -> A % i == 0)
				.forEach(i -> addFactorAndItsCounter(A, factorsFromStart, factorsFromLast, i));
		if(factorsFromLast.getLast().equals(factorsFromStart.get(factorsFromStart.size() - 1))) {
			factorsFromLast.removeLast();
		}

		while(!factorsFromLast.isEmpty()) {
			factorsFromStart.add(factorsFromLast.removeLast());
		}
				
				
		return factorsFromStart;

	}

	private void addFactorAndItsCounter(int A, ArrayList<Integer> factorsFromStart, LinkedList<Integer> factorsFromLast,
			int i) {
		factorsFromStart.add(i);
		factorsFromLast.add(A / i);
	}
}
