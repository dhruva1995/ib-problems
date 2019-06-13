package ib.trees;

import java.util.ArrayList;
import java.util.Arrays;

public class RecoverBinarySearchTree {

	public ArrayList<Integer> recoverTree(TreeNode current) {
		TreeNode prevNode = null;
		TreeNode firstTimePrev = null, lastTimeCurrent = null;

		while (current != null) {
			if (current.left == null) {
				if (prevNode != null) {
					if (current.val < prevNode.val) {
						if (firstTimePrev == null) {
							firstTimePrev = prevNode;
							lastTimeCurrent = current;
						} else {
							lastTimeCurrent = current;
						}
					}

				}
				prevNode = current;
				current = current.right;

			} else {
				TreeNode prevHighest = current.left;
				while(prevHighest.right != null && prevHighest.right != current) {
					prevHighest = prevHighest.right;
				}
				
				if (prevHighest.right == current) {
					prevHighest.right = null;

					if (current.val < prevNode.val) {
						if (firstTimePrev == null) {
							firstTimePrev = prevNode;
							lastTimeCurrent = current;
						} else {
							lastTimeCurrent = current;
						}
					}

					prevNode = current;
					current = current.right;
				} else {
					prevHighest.right = current;
					current = current.left;
				}
				
			}
		}
		return new ArrayList<>(Arrays.asList(firstTimePrev.val, lastTimeCurrent.val));
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(2);
		root.right = new TreeNode(-4);
		
		new RecoverBinarySearchTree().recoverTree(root).forEach(System.out::println);
	}

}
