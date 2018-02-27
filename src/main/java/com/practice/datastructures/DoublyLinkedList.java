package com.practice.datastructures;

import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.util.CollectionUtils;

public class DoublyLinkedList<K> extends AbstractSequentialList<K> implements List<K> {

	DoublyLinkedNode<K> head;
	DoublyLinkedNode<K> tail;
	private int size;

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

		if (obj.equals(head.getData())) {
			return removeFirst() != null;
		} else if (obj.equals(tail.getData())) {
			return removeLast() != null;
		}

		DoublyLinkedNode<K> curr = head;

		while ((curr != null) && !obj.equals(curr.getData())) {
			curr = curr.getNext();
		}

		if (curr == null) {
			// Element not in list
			return false;
		}

		DoublyLinkedNode<K> prev = curr.getPrev();
		DoublyLinkedNode<K> next = curr.getNext();

		prev.setNext(next);
		next.setPrev(prev);

		size--;

		return true;
	}

	@Override
	public boolean containsAll(Collection<?> coll) {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean addAll(Collection<? extends K> coll) {
		if (CollectionUtils.isEmpty(coll)) {
			return false;
		}

		K[] arr = (K[]) coll.toArray();

		for (K element : arr) {
			insertAtEnd(element);
		}

		return true;
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
	public int indexOf(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object obj) {
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
		DoublyLinkedNode<K> node = new DoublyLinkedNode<K>(element);

		if (isEmpty()) {
			head = node;
			tail = head;
		} else {
			node.setNext(head);
			head.setPrev(node);
			head = node;
		}
		size++;
	}

	public void insertAtEnd(K element) {
		DoublyLinkedNode<K> node = new DoublyLinkedNode<K>(element);

		if (isEmpty()) {
			head = node;
			tail = head;
		} else {
			node.setPrev(tail);
			tail.setNext(node);
			tail = node;
		}
		size++;
	}

	public void insertAt(int idx, K element) {
		validatePosition(idx);

		if (idx == 0) {
			insertAtFirst(element);
		} else if (idx == (size - 1)) {
			insertAtEnd(element);
		} else {
			int prevIdx = idx - 1;
			int count = 0;

			DoublyLinkedNode<K> prev = head;

			while (count != prevIdx) {
				prev = prev.getNext();
				count++;
			}

			DoublyLinkedNode<K> next = prev.getNext();

			DoublyLinkedNode<K> node = new DoublyLinkedNode<K>(element);
			node.setPrev(prev);
			node.setNext(next);

			prev.setNext(node);
			next.setPrev(node);

			size++;
		}
	}

	public K removeFirst() {
		if (isEmpty()) {
			return null;
		} else if (size == 1) {
			clear();
			return null;
		}

		K data = head.getData();

		head = head.getNext();
		head.setPrev(null);

		size--;

		return data;
	}

	public K removeLast() {
		if (isEmpty()) {
			return null;
		} else if (size == 1) {
			clear();
			return null;
		}

		K data = tail.getData();

		DoublyLinkedNode<K> newTail = tail.getPrev();
		newTail.setNext(null);
		tail = newTail;

		size--;

		return data;
	}

	public K removeAt(int idx) {
		if (!isValidIndex(idx)) {
			return null;
		} else if (idx == 0) {
			return removeFirst();
		} else if (idx == (size - 1)) {
			return removeLast();
		}

		DoublyLinkedNode<K> curr = head;
		int count = 0;

		while (idx != count) {
			curr = curr.getNext();
			count++;
		}

		DoublyLinkedNode<K> prev = curr.getPrev();
		DoublyLinkedNode<K> next = curr.getNext();

		prev.setNext(next);
		next.setPrev(prev);

		size--;

		return curr.getData();
	}

	private K getElementAt(int idx) {
		validatePosition(idx);

		int count = 0;
		DoublyLinkedNode<K> node = head;

		while (count != idx) {
			node = node.getNext();
			count++;
		}

		return node.getData();
	}

	public K getFirst() {
		return head.getData();
	}

	public K getLast() {
		return tail.getData();
	}

	private K replaceElementAt(int index, K element) {
		// TODO
		return null;
	}

	public void reverse() {
		DoublyLinkedNode<K> curr = tail;

		tail = head;
		head = curr;

		while (curr != null) {
			DoublyLinkedNode<K> prev = curr.getPrev();
			DoublyLinkedNode<K> next = curr.getNext();

			curr.setNext(prev);
			curr.setPrev(next);

			curr = prev;
		}
	}

	/**
	 * For testing purposes.
	 */
	public void printNodesInOrder() {
		DoublyLinkedNode<K> curr = head;

		while (curr != null) {
			System.out.print(curr.getData() + " --> ");
			curr = curr.getNext();
		}
		System.out.println("");
	}

}
