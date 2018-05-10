package com.practice.datastructures;

import java.util.List;

public class NaryNode<T extends Comparable<T>> {

	private T data;
	private List<NaryNode<T>> children;

	public NaryNode(T data) {
		this.data = data;
	}

	public NaryNode(T data, List<NaryNode<T>> children) {
		this(data);
		this.children = children;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<NaryNode<T>> getChildren() {
		return children;
	}

	public void setChildren(List<NaryNode<T>> children) {
		this.children = children;
	}

}
