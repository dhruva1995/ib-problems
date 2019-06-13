package ib.trees;

public class PopulateNextRightPointersTree {

	public void connect(TreeLinkNode root) {
		TreeLinkNode verticalTrav = root;

		while (verticalTrav != null) {
			TreeLinkNode nextRoot = null;
			TreeLinkNode horizontalTrav = verticalTrav;

			while (horizontalTrav != null) {

				fixUp(horizontalTrav);
				if (nextRoot == null) {
					if (horizontalTrav.left != null) {
						nextRoot = horizontalTrav.left;
					} else if (horizontalTrav.right != null) {
						nextRoot = horizontalTrav.right;
					}
				}

				horizontalTrav = horizontalTrav.next;
			}
			verticalTrav = nextRoot;

		}

	}

	private void fixUp(TreeLinkNode node) {
		if (node.left != null) {
			if (node.right != null) {
				node.left.next = node.right;
			} else {
				fixNextOfChildWIthGiveParent(node, node.left);
			}
		}

		if (node.right != null) {
			fixNextOfChildWIthGiveParent(node, node.right);
		}

	}

	private void fixNextOfChildWIthGiveParent(TreeLinkNode parent, TreeLinkNode child) {
		TreeLinkNode hTrav = parent.next;
		while (hTrav != null) {
			if (hTrav.left != null) {
				child.next = hTrav.left;
				return;
			} else if (hTrav.right != null) {
				child.next = hTrav.right;
				return;
			}
			hTrav = hTrav.next;
		}
	}

	public static void main(String[] args) {
		TreeLinkNode root = new TreeLinkNode(1);
		root.left = new TreeLinkNode(2);
		root.right = new TreeLinkNode(3);
		
		

		root.left.right = new TreeLinkNode(5);
		
		new PopulateNextRightPointersTree().connect(root);

		TreeLinkNode vTrav = root;
		while (vTrav != null) {
			TreeLinkNode nextRoot = null, hTrav = vTrav;
			while (hTrav != null) {
				System.out.print(hTrav.val + "\t");
				if (nextRoot == null) {
					if (hTrav.left != null) {
						nextRoot = hTrav.left;
					} else if (hTrav.right != null) {
						nextRoot = hTrav.right;
					}
				}
				hTrav = hTrav.next;

			}
			System.out.println();
			vTrav = nextRoot;
		}

	}

}
