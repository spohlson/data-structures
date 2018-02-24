package com.datastructures.ctci;

import java.util.AbstractSequentialList;
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
public class SinglyLinkedList<T> extends AbstractSequentialList<T> implements List<T> {

	private SinglyLinkedNode<T> head;
	private SinglyLinkedNode<T> tail;
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
	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}

	private boolean isValidIndex(int idx) {
		return (idx >= 0) && (idx < size);
	}

	private void validatePosition(int pos) {
		if (!isValidIndex(pos)) {
			throw new IndexOutOfBoundsException("Invalid position for list");
		}
	}

	@Override
	public boolean add(T element) {
		if (element == null) {
			return false;
		}

		insertAtEnd(element);
		return true;
	}

	private void insertAtFirst(T element) {
		SinglyLinkedNode<T> node = new SinglyLinkedNode<T>(element);

		if (isEmpty()) {
			head = node;
			tail = head;
		} else {
			node.setNext(head);
			head = node;
		}

		size++;
	}

	private void insertAtEnd(T element) {
		if (isEmpty()) {
			insertAtFirst(element);
		} else {
			SinglyLinkedNode<T> node = new SinglyLinkedNode<T>(element);
			tail.setNext(node);
			tail = node;
			size++;
		}
	}

	private void insertAt(int pos, T element) {
		validatePosition(pos);

		if (pos == 0) {
			insertAtFirst(element);
		} else if (pos == (size - 1)) {
			insertAtEnd(element);
		} else {
			int idx = 0;
			SinglyLinkedNode<T> node = head;

			while (idx != (pos - 1)) {
				node = node.getNext();
				idx++;
			}

			SinglyLinkedNode<T> nodeToInsert = new SinglyLinkedNode<T>(element);

			SinglyLinkedNode<T> temp = node.getNext();
			node.setNext(nodeToInsert);
			nodeToInsert.setNext(temp);

			size++;
		}
	}

	private void removeLast() {
		if (isEmpty()) {
			return;
		} else if (size == 1) {
			clear();
			return;
		}

		SinglyLinkedNode<T> node = head;

		int pos = size - 2;
		int idx = 0;

		while (idx != pos) {
			node = node.getNext();
			idx++;
		}

		node.setNext(null);
		tail = node;

		size--;
	}

	private void removeFirst() {
		if (isEmpty()) {
			return;
		} else if (size == 1) {
			clear();
			return;
		}

		SinglyLinkedNode<T> node = head.getNext();
		head = node;

		size--;
	}

	private void removeAt(int pos) {
		validatePosition(pos);

		if (pos == 0) {
			removeFirst();
		} else if (pos == (size - 1)) {
			removeLast();
		} else {
			SinglyLinkedNode<T> node = head;

			int idx = 0;

			while (idx != (pos - 1)) {
				node = node.getNext();
				idx++;
			}
			node.setNext(node.getNext().getNext());

			size--;
		}
	}

	@Override
	public boolean remove(Object o) {
		if (o == null) {
			// TODO: iterate to ensure no node data is null, if so then remove
			return false;
		}

		SinglyLinkedNode<T> node = head;

		if (o.equals(node.getData())) {
			head = head.getNext();
		} else {
			while (!o.equals(node.getNext().getData())) {
				node = node.getNext();
			}
			node.setNext(node.getNext().getNext());
		}

		size--;

		return true;
	}

	@Override
	public T get(int pos) {
		validatePosition(pos);

		if (pos == 0) {
			return head.getData();
		} else if (pos == (size - 1)) {
			return tail.getData();
		}

		SinglyLinkedNode<T> node = head;

		int idx = 0;

		while (idx != pos) {
			node = node.getNext();
			idx++;
		}

		return node.getData();
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

}

