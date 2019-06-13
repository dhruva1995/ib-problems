package ib.trees;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class VerticalOrderTraversalOfBinaryTree {

	private TreeMap<Integer, TreeMap<Integer, ArrayList<Integer>>> orderMap = new TreeMap<>();
	
	public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
		verticalOrderTraversalHelper(A, 0, 0);
		return orderMap.values().stream()
			.map(map -> map.values().stream().flatMap(ArrayList::stream).collect(Collectors.toCollection(ArrayList::new)))
			.collect(Collectors.toCollection(ArrayList::new));
		
	}	
	
	private void verticalOrderTraversalHelper(TreeNode root, int verticalOrder, int depth) {
		if(root == null) {
			return;
		}
		orderMap.computeIfAbsent(verticalOrder, (key) -> new TreeMap<>()).computeIfAbsent(depth, (key) -> new ArrayList<>()).add(root.val);
		verticalOrderTraversalHelper(root.left, verticalOrder - 1, depth + 1);
		verticalOrderTraversalHelper(root.right, verticalOrder + 1, depth + 1);
		
	}
	
	public static void main(String[] args) {
		TreeNode node = new TreeNode(6);
		node.left = new TreeNode(3);
		node.left.left = new TreeNode(2);
		node.left.right = new TreeNode(5);
		node.right = new TreeNode(7);
		node.right.right = new TreeNode(9);
		new VerticalOrderTraversalOfBinaryTree().verticalOrderTraversal(node).forEach(System.out::println);
	}
	
	
	
}
