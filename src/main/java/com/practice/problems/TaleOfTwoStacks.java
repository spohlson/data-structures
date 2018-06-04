package com.practice.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class TaleOfTwoStacks {

	/**
	 * A queue is an abstract data type that maintains the order in which
	 * elements were added to it, allowing the oldest elements to be removed
	 * from the front and new elements to be added to the rear. This is called a
	 * First-In-First-Out (FIFO) data structure because the first element added
	 * to the queue (i.e., the one that has been waiting the longest) is always
	 * the first one to be removed.
	 * 
	 * A basic queue has the following opertations:
	 * 
	 * 1. Enqueue: add a new element to end of queue
	 * 
	 * 2. Dequeue: remove element from the front of the queue and return it
	 * 
	 * In this challenge, you must first implement a queue using two stacks.
	 * Then process q queries, where each query is one of the following 3 types:
	 * 
	 * 1. Enqueue elemnt x into end of queue
	 * 
	 * 2. Dequeue element at front of queue
	 * 
	 * 3. Print element at the front of the queue
	 * 
	 * Input Format:
	 * 
	 * The first line contains a single integer, q, denoting the number of
	 * queries. Each line i of the q subsequent lines contains a single query in
	 * the form described in the problem statement above. All three queries
	 * start with an integer denoting the query type, but only query #1 is
	 * followed by an additional space-separated value, x, denoting the value to
	 * be enqueued.
	 */

	public class MyQueue<K> {

		private Stack<K> in;
		private Stack<K> out;

		public MyQueue() {
			in = new Stack<>();
			out = new Stack<>();
		}

		public void enqueue(K element) {
			in.push(element);
		}

		public K dequeue() {
			if (out.isEmpty()) {

				while (!in.isEmpty()) {
					out.push(in.pop());
				}
			}
			return out.pop();
		}

		public K peek() {
			if (out.isEmpty()) {
				while (!in.empty()) {
					out.push(in.pop());
				}
			}
			return out.peek();
		}

	}

	@Test
	public void test() {
		String[] arr =
				new String[] { "1 42", "2", "1 14", "3", "1 28", "3", "1 60", "1 78", "2", "2" };

		MyQueue<Integer> queue = new MyQueue<Integer>();

		List<Integer> output = new ArrayList<>();

		for (String str : arr) {
			int num = Integer.valueOf(String.valueOf(str.charAt(0)));

			if (num == 1) {
				int element = Integer.valueOf(str.replace("1 ", ""));
				queue.enqueue(element);
			} else if (num == 2) {
				queue.dequeue();
			} else if (num == 3) {
				int element = queue.peek();
				output.add(element);
			}
		}

		List<Integer> expectedOutput = new ArrayList<>(Arrays.asList(14, 14));
		Assert.assertTrue(expectedOutput.size() == output.size());

		for (int i = 0; i < expectedOutput.size(); i++) {
			Assert.assertTrue(expectedOutput.get(i) == output.get(i));
		}
	}

}
