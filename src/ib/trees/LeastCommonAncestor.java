package ib.trees;

import java.util.LinkedList;
import java.util.Queue;

public class LeastCommonAncestor {

	private Queue<TreeNode> pathToTarget1, pathToTarget2;;

	public int lca(TreeNode A, int target1, int target2) {
		fillPaths(A, target1, target2, new LinkedList<>());
		if (pathToTarget1 == null || pathToTarget2 == null) {
			return -1;
		} else {
			int result = -1;
			while (!pathToTarget1.isEmpty() && !pathToTarget2.isEmpty()
					&& pathToTarget1.peek() == pathToTarget2.peek()) {
				result = pathToTarget1.poll().val;
				pathToTarget2.poll();
			}
			return result;
		}

	}

	private void fillPaths(TreeNode a, int target1, int target2, LinkedList<TreeNode> prevPath) {
		if (a == null) {
			return;
		}
		prevPath.addLast(a);

		if (a.val == target1) {
			pathToTarget1 = new LinkedList<>(prevPath);
		} 
		if (a.val == target2) {
			pathToTarget2 = new LinkedList<>(prevPath);
		}

		fillPaths(a.left, target1, target2, prevPath);
		fillPaths(a.right, target1, target2, prevPath);
		prevPath.removeLast();
	}

}
