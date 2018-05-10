package com.practice.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.springframework.util.CollectionUtils;

public class NaryTree<T extends Comparable<T>> {

	private NaryNode<T> root;

	public NaryTree(NaryNode<T> root) {
		this.root = root;
	}

	public NaryNode<T> getRoot() {
		return root;
	}

	public void setRoot(NaryNode<T> root) {
		this.root = root;
	}

	/**
	 * root --> left --> right
	 */
	public void printPreOrder() {
		printPreOrder(root);
	}

	private void printPreOrder(NaryNode<T> node) {
		if (node == null) {
			return;
		}
		System.out.print(node.getData() + " ");
		List<NaryNode<T>> children = node.getChildren();

		if (CollectionUtils.isEmpty(children)) {
			return;
		}

		for (int i = 0; i < children.size(); i++) {
			NaryNode<T> next = children.get(i);
			printPreOrder(next);
		}
	}

	public List<T> getPreOrder() {
		List<T> values = new ArrayList<>();
		return getPreOrder(values, root);
	}

	private List<T> getPreOrder(List<T> values, NaryNode<T> node) {
		if (node != null) {
			T value = node.getData();
			values.add(value);

			List<NaryNode<T>> children = node.getChildren();

			if (!CollectionUtils.isEmpty(children)) {

				for (int i = 0; i < children.size(); i++) {
					NaryNode<T> next = children.get(i);
					values = getPreOrder(values, next);
				}
			}
		}
		return values;
	}

	/**
	 * left --> right --> root
	 */
	public void printPostOrder() {
		printPostOrder(root);
	}

	private void printPostOrder(NaryNode<T> node) {
		if (node == null) {
			return;
		}
		List<NaryNode<T>> children = node.getChildren();

		if (!CollectionUtils.isEmpty(children)) {

			for (int i = 0; i < children.size(); i++) {
				NaryNode<T> next = children.get(i);
				printPostOrder(next);
			}
		}
		System.out.print(node.getData() + " ");
	}

	public List<T> getPostOrder() {
		List<T> values = new ArrayList<>();
		return getPostOrder(values, root);
	}

	private List<T> getPostOrder(List<T> values, NaryNode<T> node) {
		if (node != null) {
			List<NaryNode<T>> children = node.getChildren();

			if (!CollectionUtils.isEmpty(children)) {
				for (int i = 0; i < children.size(); i++) {
					NaryNode<T> next = children.get(i);
					values = getPostOrder(values, next);
				}
			}
			values.add(node.getData());
		}
		return values;
	}

	/**
	 * left --> right level by level
	 */
	public void printLevelOrder() {
		Queue<NaryNode<T>> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			NaryNode<T> node = queue.poll();
			System.out.print(node.getData() + " ");

			List<NaryNode<T>> children = node.getChildren();

			if (!CollectionUtils.isEmpty(children)) {
				queue.addAll(children);
			}
		}
	}

	public List<List<T>> getLevelOrder() {
		Queue<NaryNode<T>> queue = new LinkedList<>();
		queue.add(root);

		int level = 0;
		int levelCount = 1;

		List<List<T>> levels = new ArrayList<>();

		while (!queue.isEmpty()) {
			NaryNode<T> node = queue.poll();
			List<T> levelList;
			try {
				levelList = levels.get(level);
			} catch (IndexOutOfBoundsException e) {
				levelList = new ArrayList<>();
			}
			levelList.add(node.getData());
			levels.add(level, levelList);

			if (levelList.size() == levelCount) {
				level++;
				levelCount = 0;
			}
			List<NaryNode<T>> children = node.getChildren();

			if (!CollectionUtils.isEmpty(children)) {
				queue.addAll(children);
				levelCount += children.size();
			}
		}
		return levels;
	}

	public List<List<T>> getLevelOrder1() {
		List<List<T>> levels = new ArrayList<>();

		if (root == null) {

		}

		List<T> above = Arrays.asList(root.getData());

		return levels;
	}

}
