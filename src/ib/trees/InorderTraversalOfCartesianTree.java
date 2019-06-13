package ib.trees;

import java.util.Arrays;
import java.util.List;

public class InorderTraversalOfCartesianTree {

	
    public TreeNode buildTree(List<Integer> A) {
    	return buildTreeHelper(A, 0, A.size() - 1);
    	
    }
	
	private TreeNode buildTreeHelper(List<Integer> A, int leftIndexInc, int rightIndexInc) {
		if(leftIndexInc > rightIndexInc) {
			return null;
		}
		
		int maxValuesIndex = leftIndexInc;
    	int maxValue = A.get(leftIndexInc);
    	for(int i = leftIndexInc + 1; i <= rightIndexInc; i++) {
    		if(A.get(i) > maxValue) {
    			maxValue = A.get(i);
    			maxValuesIndex = i;
    		}
    	}
    	TreeNode root = new TreeNode(A.get(maxValuesIndex));
		root.left = buildTreeHelper(A, leftIndexInc, maxValuesIndex - 1);
		root.right = buildTreeHelper(A, maxValuesIndex + 1, rightIndexInc);
		return root;
	}
    
	public static void main(String[] args) {
		new InorderTraversalOfCartesianTree().buildTree(Arrays.asList(1, 2, 3));
	}
	
    
}
