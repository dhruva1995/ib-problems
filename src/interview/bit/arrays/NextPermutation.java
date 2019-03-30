package interview.bit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NextPermutation {

	
	public static void main(String[] args) {
		
		ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 2, 2, 2, 6));
		new NextPermutation().nextPermutation(input);
		System.out.println(input);
	}

	
	public void nextPermutation(ArrayList<Integer> input) {
		
		int trav = input.size() - 1;
		while(trav > 0 && input.get(trav - 1) >= input.get(trav)) {
			trav--;
		}
		
		if(trav == 0) {
			selectionSort(input, 0, input.size() - 1);
			return;
		}
		
		int minIndex = getIndexOfElementJustGreaterThan(input, trav, input.get(trav - 1));
		swap(input, minIndex, trav - 1);
		selectionSort(input, trav, input.size() - 1);
		
    }
	
	
	private int getIndexOfElementJustGreaterThan(ArrayList<Integer> input, int startIndex, int greaterThan) {
		return IntStream.range(startIndex, input.size())
			.boxed()
			.collect(Collectors.toMap(Function.identity(), input::get))
			.entrySet()
			.stream()
			.filter(e -> e.getValue() > greaterThan)
			.min((a, b) -> Integer.compare(a.getValue(), b.getValue()))
			.get()
			.getKey();
			
	}
	
	
	public void selectionSort(ArrayList<Integer> input, int startInclusive, int endInclusive) {
		
		while(startInclusive < endInclusive) {
			int minIndex = getMinIndex(input, startInclusive, endInclusive);
			swap(input, startInclusive, minIndex);
			startInclusive++;
		}
	}


	private void swap(ArrayList<Integer> input, int index1, int index2) {
		int temp = input.get(index1);
		input.set(index1, input.get(index2));
		input.set(index2, temp);
	}


	private int getMinIndex(ArrayList<Integer> input, int startInclusive, int endInclusive) {
		int minIndex = startInclusive;
		for(int i = startInclusive + 1; i <= endInclusive; i++) {
			minIndex = (input.get(minIndex) > input.get(i)) ? i : minIndex; 
		}
		return minIndex;
	}
	
}
