package com.datastructures.ctci;

import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * LinkedList Pros/Cons & When to Use
 * 
 * Pros - Easy insertion/removal
 * 
 * Cons - 1. Accessing a specific element requires traversing from the head
 * which can take longer than an array access. 2. Requires more memory. 3.
 * Easily corrupted (one can easily inset data in the middle).
 * 
 * Use - When you don't know how large a list you will need
 */
public class SinglyLinkedList<K> extends AbstractSequentialList<K> implements List<K> {

	private SinglyLinkedNode<K> head;
	private SinglyLinkedNode<K> tail;
	private int size;

	public SinglyLinkedList() {
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<K> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(K element) {
		if (element == null) {
			return false;
		}

		insertAtEnd(element);
		return true;
	}

	@Override
	public boolean remove(Object obj) {
		if ((obj == null) || isEmpty()) {
			// TODO: iterate to ensure no node data is null, if so then remove
			return false;
		}

		SinglyLinkedNode<K> node = head;

		if (obj.equals(node.getData())) {
			head = head.getNext();
		} else {
			while (!obj.equals(node.getNext().getData())) {
				node = node.getNext();
			}
			node.setNext(node.getNext().getNext());
		}

		size--;

		return true;
	}

	@Override
	public boolean containsAll(Collection<?> coll) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends K> coll) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends K> coll) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> coll) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> coll) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}

	@Override
	public K get(int idx) {
		return getElementAt(idx);
	}

	@Override
	public K set(int idx, K element) {
		return replaceElementAt(idx, element);
	}

	@Override
	public void add(int idx, K element) {
		insertAt(idx, element);
	}

	@Override
	public K remove(int idx) {
		return removeAt(idx);
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<K> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<K> listIterator(int idx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<K> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	////////////////////////////////////

	private boolean isValidIndex(int idx) {
		return (idx >= 0) && (idx < size);
	}

	private void validatePosition(int pos) {
		if (!isValidIndex(pos)) {
			throw new IndexOutOfBoundsException("Invalid position for list");
		}
	}

	public void insertAtFirst(K element) {
		SinglyLinkedNode<K> node = new SinglyLinkedNode<K>(element);

		if (isEmpty()) {
			head = node;
			tail = head;
		} else {
			node.setNext(head);
			head = node;
		}

		size++;
	}

	private void insertAtEnd(K element) {
		if (isEmpty()) {
			insertAtFirst(element);
		} else {
			SinglyLinkedNode<K> node = new SinglyLinkedNode<K>(element);
			tail.setNext(node);
			tail = node;
			size++;
		}
	}

	private void insertAt(int idx, K element) {
		validatePosition(idx);

		if (idx == 0) {
			insertAtFirst(element);
		} else if (idx == (size - 1)) {
			insertAtEnd(element);
		} else {
			int count = 0;
			SinglyLinkedNode<K> node = head;

			while (count != (idx - 1)) {
				node = node.getNext();
				count++;
			}

			SinglyLinkedNode<K> nodeToInsert = new SinglyLinkedNode<K>(element);

			SinglyLinkedNode<K> temp = node.getNext();
			node.setNext(nodeToInsert);
			nodeToInsert.setNext(temp);

			size++;
		}
	}

	public K removeFirst() {
		if (isEmpty()) {
			return null;
		} else if (size == 1) {
			K data = head.getData();
			clear();
			return data;
		}

		K data = head.getData();
		head = head.getNext();

		size--;

		return data;
	}

	public K removeLast() {
		if (isEmpty()) {
			return null;
		} else if (size == 1) {
			K data = head.getData();
			clear();
			return data;
		}

		SinglyLinkedNode<K> node = head;

		int secondToLastIdx = size - 2;
		int count = 0;

		while (count != secondToLastIdx) {
			node = node.getNext();
			count++;
		}

		SinglyLinkedNode<K> nodeToRemove = node.getNext();

		node.setNext(null);
		tail = node;

		size--;

		return nodeToRemove.getData();
	}

	public K removeAt(int idx) {
		validatePosition(idx);

		if (idx == 0) {
			return removeFirst();
		} else if (idx == (size - 1)) {
			return removeLast();
		} else {
			SinglyLinkedNode<K> node = head;

			int count = 0;

			while (count != (idx - 1)) {
				node = node.getNext();
				count++;
			}

			SinglyLinkedNode<K> nodeToRemove = node.getNext();

			node.setNext(nodeToRemove.getNext());

			size--;

			return nodeToRemove.getData();
		}
	}

	private K getElementAt(int idx) {
		validatePosition(idx);

		if (idx == 0) {
			return head.getData();
		} else if (idx == (size - 1)) {
			return tail.getData();
		}

		SinglyLinkedNode<K> node = head;

		int count = 0;

		while (count != idx) {
			node = node.getNext();
			count++;
		}

		return node.getData();
	}

	private K replaceElementAt(int index, K element) {
		// TODO
		return null;
	}

}

