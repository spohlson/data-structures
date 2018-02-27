package com.datastructures.problems;

public class MusicalChairs {

	/***
	 * Complete Question Text: Take a second to imagine that you are in a room
	 * with 100 chairs arranged in a circle. These chairs are numbered
	 * sequentially from One to One Hundred.
	 * 
	 * At some point in time, the person in chair #1 will be told to leave the
	 * room. The person in chair #2 will be skipped, and the person in chair #3
	 * will be told to leave. Next to go is person in chair #6. In other words,
	 * 1 person will be skipped initially, and then 2, 3, 4.. and so on. This
	 * pattern of skipping will keep going around the circle until there is only
	 * one person remaining.. the survivor. Note that the chair is removed when
	 * the person leaves the room.
	 * 
	 * Write a program to figure out which chair the survivor is sitting in.
	 */

	public class Node<K> {

		private K val;
		private Node<K> prev;
		private Node<K> next;

		public Node(K val) {
			this.val = val;
		}

		public K getVal() {
			return val;
		}

		public void setVal(K val) {
			this.val = val;
		}

		public Node<K> getPrev() {
			return prev;
		}

		public void setPrev(Node<K> prev) {
			this.prev = prev;
		}

		public Node<K> getNext() {
			return next;
		}

		public void setNext(Node<K> next) {
			this.next = next;
		}

	}

	public class CircularlyLinkedList<K> {

		private Node<K> head;
		private Node<K> tail;
		private int size;

		public int size() {
			return size;
		}

		public boolean isEmpty() {
			return size == 0;
		}

		public Node<K> getHead() {
			return head;
		}

		public Node<K> getTail() {
			return tail;
		}

		public void add(K element) {
			if (element != null) {
				Node<K> node = new Node<K>(element);

				if (isEmpty()) {
					head = node;

					head.setNext(node);
					head.setPrev(node);

					tail = head;
				} else {
					tail.setNext(node);

					node.setPrev(tail);
					node.setNext(head);

					head.setPrev(node);

					tail = node;
				}

				size++;
			}
		}

		public void remove(Node<K> node) {
			Node<K> prev = node.getPrev();
			Node<K> next = node.getNext();

			prev.setNext(next);
			next.setPrev(prev);

			if (node.equals(head)) {
				head = next;
			}

			size--;
		}

	}

	public CircularlyLinkedList<Integer> createCircularList(int numOfNodes) {
		CircularlyLinkedList<Integer> ll = new CircularlyLinkedList<>();

		int idx = 1;

		while (idx <= numOfNodes) {
			ll.add(idx);
			idx++;
		}

		return ll;
	}

	public int getSurvivor(CircularlyLinkedList<Integer> ll) {
		int idx = 0;

		Node<Integer> curr = ll.getHead();

		while (ll.size() != 1) {
			int count = idx;

			while (count > 0) {
				curr = curr.getNext();
				count--;
			}

			System.out.println("Removing: " + curr.getVal());

			ll.remove(curr);

			curr = curr.getNext();

			idx++;
		}

		printList(ll);

		return curr.getVal();
	}

	public void printList(CircularlyLinkedList<Integer> ll) {
		int idx = 0;
		Node<Integer> curr = ll.getHead();

		while (idx < ll.size()) {
			System.out.print(curr.getVal() + " --> ");
			curr = curr.getNext();
			idx++;
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		MusicalChairs app = new MusicalChairs();

		CircularlyLinkedList<Integer> ll = app.createCircularList(11);

		app.printList(ll);

		int survivor = app.getSurvivor(ll);

		System.out.println("Survivor: " + survivor);
	}

}
