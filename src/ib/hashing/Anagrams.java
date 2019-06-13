package ib.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Anagrams {

	public static void main(String[] args) {
		new Anagrams().anagrams(Arrays.asList("cat", "dog", "god", "tca"))
				.forEach(System.out::println);
	}

	public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
		return IntStream.range(0, A.size())
				.boxed()
				.collect(Collectors.groupingBy(i -> hash(A.get(i)),
						Collectors.mapping(i -> i + 1, Collectors.toCollection(ArrayList::new))))
				.values()
				.stream()
				.sorted((a, b) -> Integer.compare(a.get(0), b.get(0)))
				.collect(Collectors.toCollection(ArrayList::new));

	}

	private String hash(String string) {
		return string.chars()
				.boxed()
				.collect(Collectors.groupingBy(i -> i, TreeMap::new, Collectors.counting()))
				.toString();
	}

}
