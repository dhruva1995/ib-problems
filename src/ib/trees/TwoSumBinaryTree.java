package ib.trees;

import java.util.Iterator;
import java.util.Stack;

public class TwoSumBinaryTree {

	
	public int t2Sum(TreeNode currentNode, int sum) {
		
		Iterator<Integer> ascendingIterator = getAscendingIterator(currentNode);
		Iterator<Integer> descendingIterator = getDescendingIterator(currentNode);
		
		int left = ascendingIterator.next();
		int right = descendingIterator.next();
		
		while(ascendingIterator.hasNext() && descendingIterator.hasNext()) {
			
			if(left >= right) {
				return 0;
			}
			
			if(left + right == sum) {
				return 1;
			} else if(left + right > sum) {
				right = descendingIterator.next();
				
			} else {
				left = ascendingIterator.next();
			}
			
		}
		
		return 0;
    }

	private Iterator<Integer> getDescendingIterator(TreeNode root) {

		
		Stack<TreeNode> descending = new Stack<>();
		
		
		return new Iterator<Integer>() {
			
			TreeNode currentRoot = root;
			
			@Override
			public boolean hasNext() {
				return !descending.isEmpty() || root != null;
			}

			@Override
			public Integer next() {
				while(currentRoot != null) {
					descending.push(currentRoot);
					currentRoot = currentRoot.right;
				}
				
				TreeNode currentVisit = descending.pop();
				
				if(currentVisit.left != null) {
					currentRoot = currentVisit.left;
				}
				return currentVisit.val;
			}
		};
	
	}

	private Iterator<Integer> getAscendingIterator(TreeNode root) {
		
		Stack<TreeNode> ascending = new Stack<>();
		
		
		return new Iterator<Integer>() {
			
			TreeNode currentRoot = root;
			
			@Override
			public boolean hasNext() {
				return !ascending.isEmpty() || root != null;
			}

			@Override
			public Integer next() {
				while(currentRoot != null) {
					ascending.push(currentRoot);
					currentRoot = currentRoot.left;
				}
				
				TreeNode currentVisit = ascending.pop();
				
				if(currentVisit.right != null) {
					currentRoot = currentVisit.right;
				}
				return currentVisit.val;
			}
		};
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		
		
		System.out.println(new TwoSumBinaryTree().t2Sum(root, 40));
	}
	
}
