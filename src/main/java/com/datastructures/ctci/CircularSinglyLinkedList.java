package com.datastructures.ctci;

import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.util.CollectionUtils;

public class CircularSinglyLinkedList<K> extends AbstractSequentialList<K> implements List<K> {

	private SinglyLinkedNode<K> head;
	private SinglyLinkedNode<K> tail;
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

		SinglyLinkedNode<K> prev = head;

		int idx = 0;

		while ((idx != (size - 1)) && !obj.equals(prev.getNext().getData())) {
			prev = prev.getNext();
			idx++;
		}

		if (idx == (size - 1)) {
			// Element not in list
			return false;
		}

		SinglyLinkedNode<K> next = prev.getNext().getNext();
		prev.setNext(next);

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
	public boolean addAll(int idx, Collection<? extends K> coll) {
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

	/////////////////////////////////////////////////////

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
			tail = node;

			head.setNext(tail);
			tail.setNext(head);
		} else {
			node.setNext(head);
			tail.setNext(node);
			head = node;
		}

		size++;
	}

	public void insertAtEnd(K element) {
		SinglyLinkedNode<K> node = new SinglyLinkedNode<K>(element);

		if (isEmpty()) {
			head = node;
			tail = node;

			head.setNext(tail);
			tail.setNext(head);
		} else {
			tail.setNext(node);
			node.setNext(head);
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
		}

		SinglyLinkedNode<K> prev = head;

		int count = 0;

		while (count != (idx - 1)) {
			prev = prev.getNext();
			count++;
		}

		SinglyLinkedNode<K> next = prev.getNext();

		SinglyLinkedNode<K> node = new SinglyLinkedNode<K>(element);

		prev.setNext(node);
		node.setNext(next);

		size++;
	}

	public K removeFirst() {
		if (isEmpty()) {
			return null;
		}

		K data = head.getData();

		head = head.getNext();
		tail.setNext(head);

		size--;

		return data;
	}

	public K removeLast() {
		if (isEmpty()) {
			return null;
		}

		K data = tail.getData();

		int count = 0;

		SinglyLinkedNode<K> prev = head;

		while (count != (size - 2)) {
			prev = prev.getNext();
			count++;
		}

		prev.setNext(head);
		tail = prev;

		size--;

		return data;
	}

	public K removeAt(int idx) {
		validatePosition(idx);

		SinglyLinkedNode<K> prev = head;

		int count = 0;

		while (count != (idx - 1)) {
			prev = prev.getNext();
			count++;
		}

		SinglyLinkedNode<K> node = prev.getNext();

		prev.setNext(node.getNext());

		size--;

		return node.getData();
	}

	private K getElementAt(int idx) {
		validatePosition(idx);

		SinglyLinkedNode<K> curr = head;

		int count = 0;

		while (count != idx) {
			curr = curr.getNext();
			count++;
		}

		return curr.getData();
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
		if (size < 2) {
			return;
		}

		SinglyLinkedNode<K> curr = head;
		SinglyLinkedNode<K> prev = tail;

		head = tail;
		tail = curr;

		int idx = 0;

		while (idx < size) {
			SinglyLinkedNode<K> next = curr.getNext();

			curr.setNext(prev);

			prev = curr;
			curr = next;

			idx++;
		}
	}

}
