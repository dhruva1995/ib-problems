package ib.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class HotelReviewsTries {

	private static class TrieNode {
		
		private TrieNode[] children = new TrieNode[26];
		
		private boolean termination;
	
		public void insert(String insertion) {
			TrieNode trav = this;
			for(int i = 0; i < insertion.length(); i++) {
				char c = insertion.charAt(i);
				trav = trav.getOrCreateIfDoesntExists(c);
			}
			trav.termination = true;
		}

		
		public boolean contains(String key) {
			TrieNode trav = this;
			for(int i = 0; i < key.length(); i++) {
				char c = key.charAt(i);
				trav = trav.children[c - 'a'];
				if(trav == null) {
					return false;
				}
			}
			return trav.termination;
		}
		
		
		private TrieNode getOrCreateIfDoesntExists(char c) {
			if(this.children[c - 'a'] == null) {
				this.children[c - 'a'] = new TrieNode();
			}
			return this.children[c - 'a'];
		}
		
	}
	
	public ArrayList<Integer> solve(String A, ArrayList<String> B) {
		TrieNode trie = new TrieNode();
		Stream.of(A.split("_")).forEach(trie::insert);
		
		return IntStream.range(0, B.size())
			.boxed()
			.collect(Collectors.groupingBy(i -> Stream.of(B.get(i).split("_")).filter(trie::contains).count(),() -> new TreeMap<Long, List<Integer>>(Comparator.reverseOrder()), Collectors.toList()))
			.entrySet()
			.stream()
			.map(e -> e.getValue())
			.flatMap(List::stream)
			.collect(Collectors.toCollection(ArrayList::new));
		
	}
	
	public static void main(String[] args) {
		new HotelReviewsTries().solve("cool_ice_wifi",
				new ArrayList<>(Arrays.asList("water_is_cool", "cold_ice_drink", "cool_wifi_speed"))).forEach(System.out::println);
	}

	
	
	
}
