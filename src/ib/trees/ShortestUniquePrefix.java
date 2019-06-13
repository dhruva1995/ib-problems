package ib.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ShortestUniquePrefix {

	private static class TrieNode {

		TrieNode(String strToAdd) {
			this.leafString = strToAdd;
		}

		String leafString;

		Map<Character, TrieNode> child;

		boolean isLeaf() {
			return child == null || child.isEmpty();
		}

		void add(String strToAdd, int index) {
			if (this.isLeaf()) {
				child = new HashMap<>();
				if(index >= leafString.length()) {
					this.child.put(strToAdd.charAt(index), new TrieNode(strToAdd));
				} else {
					this.child.put(this.leafString.charAt(index), new TrieNode(this.leafString));
					add(strToAdd, index);
				}
			} else {
				if(child.containsKey(strToAdd.charAt(index))) {
					child.get(strToAdd.charAt(index)).add(strToAdd, index + 1);
				} else {
					child.put(strToAdd.charAt(index), new TrieNode(strToAdd));
				}
			}
		}
		
		
	}
	
	
	public ArrayList<String> prefix(List<String> A) {
		TrieNode root = new TrieNode("");
		A.forEach(str -> root.add(str, 0));
		Map<String, String> stringPrefixMap = new HashMap<>();
		traverseRecursivelyAndAdd(root, stringPrefixMap, 0);
		
		
		return A.stream().map(stringPrefixMap::get).collect(Collectors.toCollection(ArrayList::new));
    }


	private void traverseRecursivelyAndAdd(TrieNode root, Map<String, String> result, int prefixIndex) {
		if(root.isLeaf()) {
			result.put(root.leafString, root.leafString.substring(0, prefixIndex));
		} else {
			for(TrieNode child : root.child.values()) {
				traverseRecursivelyAndAdd(child, result, prefixIndex + 1);
			}
			
		}
	}
	
	public static void main(String[] args) {
		new ShortestUniquePrefix().prefix(Arrays.asList("zebra", "dog", "duck", "dove")).forEach(System.out::println);
	}

}
