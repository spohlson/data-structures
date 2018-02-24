package com.datastructures.ctci;

public class SinglyLinkedNode<T> {

	T data;
	SinglyLinkedNode<T> next;

	public SinglyLinkedNode(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public SinglyLinkedNode<T> getNext() {
		return next;
	}

	public void setNext(SinglyLinkedNode<T> next) {
		this.next = next;
	}

}
