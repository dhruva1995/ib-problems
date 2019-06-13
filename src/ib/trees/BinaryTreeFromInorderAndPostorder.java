package ib.trees;

import java.util.Arrays;
import java.util.List;

public class BinaryTreeFromInorderAndPostorder {

	public TreeNode buildTree(List<Integer> inOrder, List<Integer> postOrder) {
        if(inOrder.isEmpty()) {
            return null;
        }
        
        int currentRoot = postOrder.get(postOrder.size() - 1);
        int i = 0;
        while(i < inOrder.size() && inOrder.get(i) != currentRoot) {
            i++;
        }
        
        TreeNode rootNode = new TreeNode(currentRoot);
        if(i != 0) {
        	rootNode.left = buildTree(inOrder.subList(0, i), postOrder.subList(0, i));
        }
        
        if(i != inOrder.size() - 1) {
        	rootNode.right = buildTree(inOrder.subList(i + 1, inOrder.size()), postOrder.subList(i, postOrder.size() - 1));
        }
        return rootNode;
        
    }
	
	
	public static void main(String[] args) {
		
		TreeNode tree = new BinaryTreeFromInorderAndPostorder()
				.buildTree(Arrays.asList(4, 5, 6, 7, 10, 11, 13, 15, 17), Arrays.asList(4, 6 ,7, 5, 11, 13, 17, 15, 10));
		
		inOrder(tree);
		System.out.println();
		postOrder(tree);
	}


	private static void inOrder(TreeNode tree) {
		if(tree == null) return;
		inOrder(tree.left);
		System.out.print( " " + tree.val + " ");
		inOrder(tree.right);
	}
	
	private static void postOrder(TreeNode tree) {
		if(tree == null) return;
		postOrder(tree.left);
		postOrder(tree.right);
		System.out.print(" " + tree.val + " ");
	}
	
	
	
}
