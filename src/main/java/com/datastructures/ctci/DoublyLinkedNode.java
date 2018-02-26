package com.datastructures.ctci;

public class DoublyLinkedNode<K> {

	K data;
	DoublyLinkedNode<K> prev;
	DoublyLinkedNode<K> next;

	public DoublyLinkedNode(K data) {
		this.data = data;
	}

	public K getData() {
		return data;
	}

	public void setData(K data) {
		this.data = data;
	}

	public DoublyLinkedNode<K> getPrev() {
		return prev;
	}

	public void setPrev(DoublyLinkedNode<K> prev) {
		this.prev = prev;
	}

	public DoublyLinkedNode<K> getNext() {
		return next;
	}

	public void setNext(DoublyLinkedNode<K> next) {
		this.next = next;
	}

	public void setPrevAndNext(DoublyLinkedNode<K> prev, DoublyLinkedNode<K> next) {
		this.prev = prev;
		this.next = next;
	}

}
