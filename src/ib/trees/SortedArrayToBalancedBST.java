package ib.trees;

import java.util.List;

public class SortedArrayToBalancedBST {

	public TreeNode sortedArrayToBST(final List<Integer> a) {
		return sortedArrayToBSTHelper(a, 0, a.size() - 1);
    }
	
	private TreeNode sortedArrayToBSTHelper(final List<Integer> a, int start, int end) {
		if(start > end) {
			return null;
		}
		int mid = start + (end - start) / 2;
		
		TreeNode current = new TreeNode(a.get(mid));
		
		current.left = sortedArrayToBSTHelper(a, start, mid - 1);
		current.right = sortedArrayToBSTHelper(a, mid + 1, end);
		return current;
    }
	
	
	
	
}
