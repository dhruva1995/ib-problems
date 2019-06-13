package ib.trees;

import java.util.ArrayList;
import java.util.Stack;

public class PostorderTraversal {

	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		Stack<TreeNode> forRightVisit = new Stack<>(), forSelfVisit = new Stack<>();
		ArrayList<Integer> result = new ArrayList<>();
		
		while(root != null || !forSelfVisit.isEmpty()) {
			while(root != null) {
				forRightVisit.push(root);
				forSelfVisit.push(root);
				root = root.left;
			}
			
			if(!forRightVisit.isEmpty() && forRightVisit.peek() == forSelfVisit.peek()) {
				root = forRightVisit.pop().right;
				continue;
			}
			
			if (forRightVisit.isEmpty() || (forRightVisit.peek() != forSelfVisit.peek())) {
				result.add(forSelfVisit.pop().val);
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
		new PostorderTraversal().postorderTraversal(node).forEach(System.out::println);
	}
	
}
