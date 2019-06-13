package ib.avl.trees;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AVLTree<T extends Comparable<? super T>> implements Iterable<T> {

	private int size;

	private AVLNode<T> root;

	public AVLTree() {
		size = 0;
	}

	private static class AVLNode<T> {

		private AVLNode(T data) {
			this.data = data;
		}

		private T data;

		private AVLNode<T> left, right;

		private int height;

		private void updateHeight() {
			this.height = Math.max(AVLTree.height(left), AVLTree.height(right)) + 1;
		}

	}

	public int size() {
		return size;
	}

	public T peekMin() {
		return peekMin(this.root);
	}

	private T peekMin(AVLNode<T> current) {
		AVLNode<T> trav = current;
		while (trav.left != null) {
			trav = trav.left;
		}
		return trav.data;
	}

	public T peekMax() {
		return peekMax(this.root);
	}

	private T peekMax(AVLNode<T> current) {
		AVLNode<T> trav = current;
		while (trav.right != null) {
			trav = trav.right;
		}
		return trav.data;
	}

	public T removeMin() {
		T min = peekMin(this.root);
		this.root = removeMinCore(this.root);
		this.size--;
		return min;
	}

	private AVLNode<T> removeMinCore(AVLNode<T> current) {
		if (current.left == null) {
			return current.right;
		} else {
			current.left = removeMinCore(current.left);
			current.updateHeight();
			return isAVLTreeIsntBalanced(current) ? fixUp(current) : current;
		}
	}

	public T removeMax() {
		T max = peekMax(this.root);
		this.root = removeMaxCore(this.root);
		this.size--;
		return max;
	}

	private AVLNode<T> removeMaxCore(AVLNode<T> current) {
		if (current.right == null) {
			return current.left;
		} else {
			current.right = removeMaxCore(current.right);
			current.updateHeight();
			return isAVLTreeIsntBalanced(current) ? fixUp(current) : current;
		}
	}

	public void add(T newElement) {
		root = insert(root, newElement);
		this.size++;
	}

	public T floor(T element) {
		return floor(element, this.root);

	}

	private T floor(T element, AVLNode<T> current) {
		if (current == null) {
			return null;
		} else if (current.data.compareTo(element) == 0) {
			return current.data;
		} else if (current.data.compareTo(element) > 0) {
			return floor(element, current.left);
		} else {
			T dataReturn = floor(element, current.right);
			return dataReturn == null ? current.data : dataReturn;
		}
	}

	public T ceil(T element) {
		return ceil(element, this.root);
	}

	private T ceil(T element, AVLNode<T> current) {
		if (current == null) {
			return null;
		} else if (current.data.compareTo(element) == 0) {
			return current.data;
		} else if (current.data.compareTo(element) > 0) {
			T returnedData = ceil(element, current.left);
			return returnedData == null ? current.data : returnedData;
		} else {
			return ceil(element, current.right);
		}
	}

	public Iterator<T> iterator() {
		Queue<T> inorderIteration = new LinkedList<>();
		inOrderTraversal(root, inorderIteration);
		return inorderIteration.iterator();

	}

	private void inOrderTraversal(AVLNode<T> current, Queue<T> queueToInsertInto) {
		if (current == null) {
			return;
		}
		inOrderTraversal(current.left, queueToInsertInto);
		queueToInsertInto.add(current.data);
		inOrderTraversal(current.right, queueToInsertInto);
	}

	public boolean contains(T element) {
		return contains(element, this.root);
	}

	private boolean contains(T element, AVLNode<T> current) {
		if (current == null) {
			return false;
		} else if (current.data.compareTo(element) == 0) {
			return true;
		} else if (current.data.compareTo(element) < 0) {
			return contains(element, current.right);
		} else {
			return contains(element, current.left);
		}
	}

	// TODO: complete this
	public void delete(T element) {
		this.root = delete(element, this.root);

	}

	private AVLNode<T> delete(T element, AVLNode<T> current) {
		if (current == null) {
			return null;
		} else if (current.data.compareTo(element) == 0) {
			if (current.left == null && current.right == null) {
				return null;
			} else if (current.left == null) {
				return current.right;
			} else if (current.right == null) {
				return current.left;
			} else {
				T replacement = peekMax(current.left);
				current.left = removeMaxCore(current.left);
				current.data = replacement;
			}
		} else if (current.data.compareTo(element) < 0) {
			current.right = delete(element, current.right);
		} else {
			current.left = delete(element, current.left);
		}
		current.updateHeight();
		return isAVLTreeIsntBalanced(current) ? fixUp(current) : current;
	}

	private static <T> int height(AVLNode<T> current) {
		if (current == null) {
			return -1;
		}
		return current.height;
	}

	private AVLNode<T> insert(AVLNode<T> current, T newElement) {
		if (current == null) {
			return new AVLNode<>(newElement);
		}
		if (current.data.compareTo(newElement) == 0) {
			current.data = newElement;
		} else if (current.data.compareTo(newElement) < 0) {
			current.right = insert(current.right, newElement);
		} else {
			current.left = insert(current.left, newElement);
		}
		current.updateHeight();
		return isAVLTreeIsntBalanced(current) ? fixUp(current) : current;
	}

	private boolean isAVLTreeIsntBalanced(AVLNode<T> root) {
		return Math.abs(height(root.left) - height(root.right)) > 1;
	}

	private AVLNode<T> fixUp(AVLNode<T> current) {
		if (isLeftLeft(current)) {
			return rotateRight(current);
		} else if (isRightRight(current)) {
			return rotateLeft(current);
		} else if (isRightLeft(current)) {
			return rotateRightLeft(current);
		} else {
			return rotateLeftRight(current);
		}
	}

	private boolean isRightLeft(AVLNode<T> current) {
		return height(current.right) - height(current.left) > 1
				&& height(current.right.left) - height(current.right.right) == 1;
	}

	private AVLNode<T> rotateLeft(AVLNode<T> current) {
		AVLNode<T> node3 = current, node2 = current.right, nodeb = node2.left;
		node2.left = node3;
		node3.right = nodeb;
		node3.updateHeight();
		node2.updateHeight();
		return node2;
	}

	private boolean isRightRight(AVLNode<T> current) {
		return height(current.right) - height(current.left) > 1
				&& height(current.right.right) - height(current.right.left) >= 0;
	}

	private AVLNode<T> rotateRight(AVLNode<T> current) {
		AVLNode<T> node2 = current.left, node3 = current, nodec = node2.right;
		node2.right = node3;
		node3.left = nodec;
		node3.updateHeight();
		node2.updateHeight();
		return node2;
	}

	private boolean isLeftLeft(AVLNode<T> current) {
		return height(current.left) - height(current.right) > 1
				&& height(current.left.left) - height(current.left.right) >= 0;
	}

	private AVLNode<T> rotateLeftRight(AVLNode<T> grandParent) {
		grandParent.left = rotateLeft(grandParent.left);
		return rotateRight(grandParent);
	}

	private AVLNode<T> rotateRightLeft(AVLNode<T> grandParent) {
		grandParent.right = rotateRight(grandParent.right);
		return rotateLeft(grandParent);
	}

	private void verifyIfBST() {

		Iterator<T> dataIterator = iterator();
		T prev = null;
		if (dataIterator.hasNext()) {
			prev = dataIterator.next();
		}
		while (dataIterator.hasNext()) {
			T current = dataIterator.next();
			if (prev.compareTo(current) >= 0) {
				throw new IllegalStateException("BST Property disintegrated");
			}
		}
	}

	private int calaculateActualHeight(AVLNode<T> current) {
		if (current == null) {
			return -1;
		}
		int leftHeight = calaculateActualHeight(current.left);
		int rightHeight = calaculateActualHeight(current.right);
		int caclHeight = Math.max(leftHeight, rightHeight) + 1;
		if (Math.abs(leftHeight - rightHeight) > 1 || caclHeight != current.height) {
			throw new IllegalStateException("AVL Property disintegrated at " + current.data);
		}
		return caclHeight;
	}

	public static void main(String[] args) {
		AVLTree<Integer> ints = new AVLTree<>();

		List<Integer> allNums = IntStream.range(1, 16)
				.boxed()
				.collect(Collectors.toList());

		//ints.levelOrderTraversal();

		Collections.shuffle(allNums);
		// Collections.reverse(allNums);

		allNums.forEach(ints::add);
		
		for(int i : allNums) {
			ints.delete(i);
			System.out.println(i + " " + ints.floor(i));
		}

	}

	private void levelOrderTraversal() {

		AVLNode<T> sentinal = new AVLNode<>(null);

		Queue<AVLNode<T>> queue = new LinkedList<>();

		queue.add(root);
		queue.add(sentinal);

		while (!queue.isEmpty()) {
			AVLNode<T> current = queue.poll();
			if (current == sentinal) {
				if (!queue.isEmpty()) {
					queue.add(sentinal);
				}
				System.out.println();
			} else if (current != null) {
				System.out.print(" " + current.data + " ");
				if (current.left != null) {
					queue.add(current.left);
				}
				if (current.right != null) {
					queue.add(current.right);
				}
			} else {
				break;
			}
		}

	}

}
