package ib.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

import com.google.common.collect.Iterators;

public class MaxHeap<T extends Comparable<? super T>> {

	private int heapSize;

	private final ArrayList<T> holder;

	public MaxHeap() {
		this.holder = new ArrayList<>();
		heapSize = 0;
	}

	public MaxHeap(Collection<T> buffer) {
		this.holder = new ArrayList<>(buffer);
		this.heapSize = holder.size();
		heapify();
	}

	public void add(T newElement) {
		this.holder.add(heapSize, newElement);
		this.heapSize++;
		swimUp(heapSize - 1);
	}

	public T peekMax() {
		return this.holder.get(0);
	}

	public T removeMax() {
		T removed = this.holder.get(0);
		T last = this.holder.get(heapSize - 1);
		this.holder.set(heapSize - 1, null);
		this.holder.set(0, last);
		heapSize--;
		sinkDown(0);
		return removed;
	}

	public int size() {
		return this.heapSize;
	}

	public void sort() {
		while(this.heapSize > 1) {
			T max = removeMax();
			this.holder.set(heapSize, max);
		}
	}

	public Iterator<T> iterator() {
		return this.holder.iterator();
	}
	
	private void swimUp(int index) {
		T parent = parent(index);
		T current = this.holder.get(index);
		while (parent != null && parent.compareTo(current) < 0) {
			swap(index, parentIndex(index));
			index = parentIndex(index);
			current = this.holder.get(index);
			parent = parent(index);
		}

	}

	private void heapify() {
		for (int i = this.heapSize / 2; i >= 0; i--) {
			sinkDown(i);
		}

	}

	private void swap(int index1, int index2) {
		T temp = this.holder.get(index1);
		this.holder.set(index1, this.holder.get(index2));
		this.holder.set(index2, temp);
	}

	private void sinkDown(int index) {
		while (index < heapSize / 2) {
			T current = this.holder.get(index);
			T left = left(index), right = right(index);
			int largeElementsIndex;
			if (right == null) {
				largeElementsIndex = leftIndex(index);
			} else {
				largeElementsIndex = left.compareTo(right) > 0 ? leftIndex(index) : rightIndex(index);
			}
			if (this.holder.get(largeElementsIndex)
					.compareTo(current) > 0) {
				swap(index, largeElementsIndex);
			} else {
				break;
			}
			index = largeElementsIndex;
		}

	}

	private int leftIndex(int index) {
		return rightIndex(index) - 1;
	}

	private T left(int index) {
		int leftIndex = leftIndex(index);
		return leftIndex < this.heapSize ? this.holder.get(leftIndex) : null;
	}

	private T right(int index) {
		int rightIndex = rightIndex(index);
		return rightIndex < this.heapSize ? this.holder.get(rightIndex) : null;
	}

	private int rightIndex(int index) {
		return 2 * (index + 1);
	}

	private T parent(int index) {
		int parentIndex = parentIndex(index);
		return parentIndex >= 0 ? this.holder.get(parentIndex) : null;

	}

	private int parentIndex(int index) {
		return ((index + 1) / 2) - 1;
	}
	
	public static void main(String[] args) {
		
		MaxHeap<Integer> heap = new MaxHeap<>(Arrays.asList(3, 5 ,6, 2, 1, Integer.MIN_VALUE, Integer.MAX_VALUE));
		heap.sort();
		System.out.println(heap.holder);
		Random random = new Random();
		heap = new MaxHeap<>();
		ArrayList<Integer> ints = new ArrayList<>();
		for(int i = 0; i < 1_00_000; i++) {
			int randomInt = random.nextInt();
			heap.add(randomInt);
			ints.add(randomInt);
		}
		Collections.sort(ints);
		while(heap.size() > 0) {
			int large = heap.removeMax();
			int expected = ints.remove(ints.size() - 1);
			if(large != expected) {
				System.out.println("Failed");
			}
		}
		if(ints.isEmpty() && heap.size() == 0) {
			System.out.println("Success");
		} else {
			System.out.println("Failed");
		}
		
	}
	
}
