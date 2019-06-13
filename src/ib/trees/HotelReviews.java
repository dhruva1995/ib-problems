package ib.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class HotelReviews {

	public ArrayList<Integer> solve(String A, ArrayList<String> B) {
		Set<String> tokens = Stream.of(A.split("_"))
				.collect(Collectors.toSet());

		return IntStream.range(0, B.size())
				.boxed()
				.collect(Collectors.groupingBy(i -> getMatchingTokensCount(getSetOfWords(B.get(i)), tokens),
						() -> new TreeMap<Integer, List<Integer>>(Comparator.reverseOrder()), Collectors.toList()))
				.entrySet()
				.stream()
				.map(e -> e.getValue())
				.flatMap(List::stream)
				.collect(Collectors.toCollection(ArrayList::new));

	}

	private List<String> getSetOfWords(String str) {
		return Stream.of(str.split("_"))
				.collect(Collectors.toList());
	}

	private Integer getMatchingTokensCount(List<String> a, Set<String> b) {
		return (int) a.stream()
				.filter(b::contains)
				.count();
	}

	public static void main(String[] args) {
		new HotelReviews().solve("cool_ice_wifi",
				new ArrayList<>(Arrays.asList("water_is_cool", "cold_ice_drink", "cool_wifi_speed"))).forEach(System.out::println);
	}

}
