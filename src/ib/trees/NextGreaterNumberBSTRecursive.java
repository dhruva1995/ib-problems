package ib.trees;

public class NextGreaterNumberBSTRecursive {

	public TreeNode getSuccessor(TreeNode root, int key) {
		if(root == null) {
			return null;
		} else if(root.val <= key) {
			return getSuccessor(root.right, key);
		} else {
			TreeNode temp = getSuccessor(root.left, key);
			return temp == null ? root : temp;
		}
    }
	
}
