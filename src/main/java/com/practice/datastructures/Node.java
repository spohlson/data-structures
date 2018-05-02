package com.practice.datastructures;

public class Node<T extends Comparable<T>> {

	private T data;
	private Node<T> left;
	private Node<T> right;

	public Node(T data) {
		this.data = data;
	}

	public Node(T data, Node<T> left, Node<T> right) {
		this(data);
		this.left = left;
		this.right = right;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getLeft() {
		return left;
	}

	public void setLeft(Node<T> left) {
		this.left = left;
	}

	public Node<T> getRight() {
		return right;
	}

	public void setRight(Node<T> right) {
		this.right = right;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Node<T> other = (Node<T>) obj;
		if (data == null) {
			if (other.data != null) {
				return false;
			}
		} else if (data.compareTo(other.data) != 0) {
			return false;
		}
		if (left == null) {
			if (other.left != null) {
				return false;
			}
		} else if (!left.equals(other.left)) {
			return false;
		}
		if (right == null) {
			if (other.right != null) {
				return false;
			}
		} else if (!right.equals(other.right)) {
			return false;
		}
		return true;
	}

}
