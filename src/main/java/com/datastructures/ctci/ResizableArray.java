package com.datastructures.ctci;

import java.util.AbstractList;
import java.util.List;

public class ResizableArray<K> extends AbstractList<K> implements List<K> {

	private int size;
	private K[] items;

	public ResizableArray() {
		this(10);
	}

	@SuppressWarnings("unchecked")
	public ResizableArray(int initialCapacity) {
		if (initialCapacity < 0) {
			throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
		}
		this.items = (K[]) new Object[initialCapacity];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public K get(int index) {
		if ((index < 0) || (index >= size)) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		return items[index];
	}

	@Override
	public K set(int index, K item) {
		if ((index < 0) || (index >= size)) {
			throw new ArrayIndexOutOfBoundsException(index);
		}

		K itemToReplace = items[index];

		items[index] = item;

		return itemToReplace;
	}

	/**
	 * Runtime: O(1) amortized time
	 * 
	 * i.e. Ensuring the capacity (doubling the array and copying over the
	 * elements) happens so rarely that only the insertion of the element should
	 * be considered when determining runtime.
	 */
	public void append(K x) {
		ensureCapacity();

		items[size] = x;
		size++;
	}

	/**
	 * 1. Check if array is full
	 * 2. If so, create new array at 2x capacity
	 * 3. Copy over elements
	 */
	private void ensureCapacity() {
		if (size == items.length) {
			K[] copy = (K[]) new Object[size * 2];

			// manual copy:
			// for (int i = 0; i < items.length; i++) {
			// 		copy[i] = items[i];
			// }

			// System copy. Runtime: O(N)?
			System.arraycopy(items, 0, copy, 0, size);

			items = copy;
		}
	}

}
