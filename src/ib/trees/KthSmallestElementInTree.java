package ib.trees;

public class KthSmallestElementInTree {

	
	public int kthsmallest(TreeNode current, int k) {
		int leftSubTreeSize = size(current.left);
		if(k <= leftSubTreeSize) {
			return kthsmallest(current.left, k);
		} else if(k == leftSubTreeSize + 1) {
			return current.val;
		} else {
			return kthsmallest(current.right, k - (leftSubTreeSize + 1));
		}
    }
	
	
	private int size(TreeNode root) {
		if(root == null) {
			return 0;
		}
		return size(root.left) + size(root.right) + 1;
	}
	
	
	
	
}
