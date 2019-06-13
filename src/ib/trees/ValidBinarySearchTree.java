package ib.trees;





public class ValidBinarySearchTree {

		public int isValidBST(TreeNode current) {
			return isValidBST(current, Integer.MAX_VALUE, Integer.MIN_VALUE) ? 1 : 0;
		}
	
	
		private boolean isValidBST(TreeNode current, int max, int min) {
			
			if(current == null) {
				return true;
			} 
			return min < current.val && current.val < max && 
					isValidBST(current.left, current.val, min) &&
					isValidBST(current.right, max, current.val);
		}

	  
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(5);
		System.out.println(new ValidBinarySearchTree().isValidBST(root));
		
		
	}
	
}
