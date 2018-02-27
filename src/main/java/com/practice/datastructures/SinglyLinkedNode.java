package com.practice.datastructures;

public class SinglyLinkedNode<K> {

	K data;
	SinglyLinkedNode<K> next;

	public SinglyLinkedNode(K data) {
		this.data = data;
	}

	public K getData() {
		return data;
	}

	public void setData(K data) {
		this.data = data;
	}

	public SinglyLinkedNode<K> getNext() {
		return next;
	}

	public void setNext(SinglyLinkedNode<K> next) {
		this.next = next;
	}

}
