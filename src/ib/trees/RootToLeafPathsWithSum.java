package ib.trees;

import java.util.ArrayList;
import java.util.LinkedList;

public class RootToLeafPathsWithSum {
	
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		pathSumHelper(A, B, result, new LinkedList<>(), 0);
		return result;
        
    }

	private void pathSumHelper(TreeNode currentNode, int targetSum, ArrayList<ArrayList<Integer>> result, LinkedList<Integer> prevSelection, int prevSum) {
		
		if(currentNode == null) {
			return;
		}
		
		prevSelection.add(currentNode.val);
		int sumTillNow = prevSum + currentNode.val;
		if(currentNode.left == null && currentNode.right == null 
				&& sumTillNow == targetSum) {
			result.add(new ArrayList<>(prevSelection));
			
		} else {
			pathSumHelper(currentNode.left, targetSum, result, prevSelection, sumTillNow);
			pathSumHelper(currentNode.right, targetSum, result, prevSelection, sumTillNow);
		}
		prevSelection.removeLast();
		
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		
		root.left = new TreeNode(2);
		root.left.right = new TreeNode(3);
		
		new RootToLeafPathsWithSum().pathSum(root, 6).forEach(System.out::println);
	}

}
