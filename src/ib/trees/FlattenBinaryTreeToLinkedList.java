package ib.trees;

public class FlattenBinaryTreeToLinkedList {

	public TreeNode flatten(TreeNode a) {
    
		if(a == null) {
			return null;
		}
		
		
		
		TreeNode leftChildPath = flatten(a.left);
		
		TreeNode rightChildPath = flatten(a.right);
		
		TreeNode childPathCombined = null;
		
		if(leftChildPath != null) {
			childPathCombined = leftChildPath;
			while(leftChildPath.right != null) {
				leftChildPath = leftChildPath.right;
			}
		}
		
		if(rightChildPath != null) {
			if(childPathCombined == null) {
				childPathCombined = rightChildPath;
			} else {
				leftChildPath.right = rightChildPath;
			}
		}
		a.left = null;
		a.right = childPathCombined;
		return a;
		
		
		
		
		
    }

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.left.left = new TreeNode(6);
		root.right = new TreeNode(3);
		
		new FlattenBinaryTreeToLinkedList().flatten(root);
		
		while(root != null) {
			System.out.println(root.val);
			root = root.right;
		}
	}
	
	
}
