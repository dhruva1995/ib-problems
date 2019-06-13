package ib.trees;

import java.util.ArrayList;
import java.util.Stack;

public class InorderTraversal {

	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		
		Stack<TreeNode> stack = new Stack<>();
		
		ArrayList<Integer> result = new ArrayList<>();
		
		while(root != null) {
			
			while(root != null) {
				stack.push(root);
				root = root.left;
			}
			
			while(!stack.isEmpty()) {
				TreeNode last = stack.pop();
				result.add(last.val);
				if(last.right != null) {
					root = last.right;
					break;
				}
				
			}
			
		}
		
		return result;
    }

	public static void main(String[] args) {
		TreeNode node = new TreeNode(6);
		node.left = new TreeNode(3);
		node.left.left = new TreeNode(2);
		node.left.right = new TreeNode(5);
		node.right = new TreeNode(7);
		node.right.right = new TreeNode(9);
		new InorderTraversal().inorderTraversal(node).forEach(System.out::println);
	}
	
	
}
