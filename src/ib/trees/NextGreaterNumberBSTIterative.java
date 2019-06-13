package ib.trees;

public class NextGreaterNumberBSTIterative {

	public TreeNode getSuccessor(TreeNode root, int key) {
		TreeNode possibleAnswer = null;
		while(root != null) {
			if(root.val <= key) {
				root = root.right;
			} else {
				possibleAnswer = root;
				root = root.left;
			}
		}
		return possibleAnswer;
	}
	
	
}
