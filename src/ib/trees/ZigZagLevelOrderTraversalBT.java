package ib.trees;

import java.util.ArrayList;
import java.util.Stack;

public class ZigZagLevelOrderTraversalBT {

	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<>();

		Stack<TreeNode> currentLevel = new Stack<>(), newLevel;
		
		if(A == null) {
			return result;
		}

		currentLevel.push(A);

		boolean isEven = true;

		while (!currentLevel.isEmpty()) {
			newLevel = new Stack<>();
			ArrayList<Integer> newRow = new ArrayList<>();

			while (!currentLevel.isEmpty()) {

				TreeNode node = currentLevel.pop();

				if (isEven) {
					if (node.left != null) {
						newLevel.push(node.left);
					}
					if (node.right != null) {
						newLevel.push(node.right);
					}
				} else {
					if (node.right != null) {
						newLevel.push(node.right);
					}
					if (node.left != null) {
						newLevel.push(node.left);
					}
				}

				newRow.add(node.val);

			}
			result.add(newRow);
			isEven = !isEven;
			currentLevel = newLevel;
		}
		return result;
	}

}
