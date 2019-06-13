package ib.trees;

import java.util.List;

public class ConstructBinaryTreeFromInorderAndPreorder {

	public TreeNode buildTree(List<Integer> preOrder, List<Integer> inOrder) {

		if (preOrder.isEmpty()) {
			return null;
		}

		int rootIndex = 0;

		int currentRootsVal = preOrder.get(0);

		while (rootIndex < inOrder.size() && inOrder.get(rootIndex) != currentRootsVal) {
			rootIndex++;
		}

		TreeNode currentRoot = new TreeNode(currentRootsVal);

		if (rootIndex != 0) {
			currentRoot.left = buildTree(preOrder.subList(1, rootIndex + 1), inOrder.subList(0, rootIndex));
		}

		if (rootIndex != inOrder.size() - 1) {
			currentRoot.right = buildTree(preOrder.subList(rootIndex + 1, preOrder.size()),
					inOrder.subList(rootIndex + 1, inOrder.size()));
		}
		
		return currentRoot;

	}

}
