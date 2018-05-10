package com.practice.problems;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TowerOfHanoi {

	/**
	 * There are 3 rods and n number of disks of different sizes which can slide
	 * onto any rod. All disks start in a neat stack in ascending order on the
	 * 1st rod, smallest at the top making a conical shape.
	 * 
	 * Objective: Move entire stack to the last rod while obeying the following
	 * rules.
	 * 
	 * 1. Only one disk can move at a time
	 * 
	 * 2. Each move consists of taking the upper disk from one of the stacks and
	 * placing it on top of another stack.
	 * 
	 * 3. No disk may be placed on top of a smaller disk.
	 * 
	 * With 3 disks the puzzle can be solved in 7 moves. The minimum # of moves
	 * required to solve the puzzle is 2^n - 1.
	 */

	private static final Logger LOG = LoggerFactory.getLogger(TowerOfHanoi.class);
	private static final int FIRST_ROD = 1;

	private int moves;

	public class Rod {

		private int id;
		private Stack<Integer> stack;
		private Rod prev;
		private Rod next;

		public Rod(int id) {
			this.id = id;
		}

		public Rod(int id, Rod next) {
			this(id);
			this.next = next;
			stack = new Stack<>();
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public Stack<Integer> getStack() {
			return stack;
		}

		public void setStack(Stack<Integer> stack) {
			this.stack = stack;
		}

		public Rod getPrev() {
			return prev;
		}

		public void setPrev(Rod prev) {
			this.prev = prev;
		}

		public Rod getNext() {
			return next;
		}

		public void setNext(Rod next) {
			this.next = next;
		}

		public boolean canPushDisk(int disk) {
			return stack.isEmpty() || (stack.peek() > disk);
		}

	}

	public Rod createRods(int numOfDisks) {
		moves = 0;

		Rod first = new Rod(FIRST_ROD);
		Stack<Integer> firstStack = new Stack<>();

		int count = numOfDisks;
		while (count > 0) {
			firstStack.push(count);
			count--;
		}
		first.setStack(firstStack);

		Rod third = new Rod(3, first);

		Rod second = new Rod(2, third);
		second.setPrev(first);

		first.setNext(second);
		first.setPrev(third);

		third.setPrev(second);

		return first;
	}

	public void moveDisks(Rod rod, int totalDisks) {
		boolean odd = (totalDisks % 2) == 1;

		int rodId = rod.getId();
		Stack<Integer> stack = rod.getStack();

		Rod next = (odd) ? rod.getPrev() : rod.getNext();

		if (stack.isEmpty()) {
			moveDisks(next, totalDisks);
			return;
		} else if ((rodId != FIRST_ROD) && (stack.size() == totalDisks)) {
			return;
		}

		int disk = stack.peek();

		if (!next.canPushDisk(disk)) {
			Rod nextNext = (odd) ? next.getPrev() : next.getNext();

			if (!nextNext.canPushDisk(disk)) {
				moveDisks(next, totalDisks);
				return;
			}
			next = nextNext;
		}

		stack.pop();
		next.getStack().push(disk);

		moves++;

		logMove(rod);

		moveDisks((odd) ? next.getPrev() : next.getNext(), totalDisks);
	}

	public void logMove(Rod rod) {
		LOG.debug("Move {}", moves);

		int rodId = rod.getId();
		Rod firstRod = rod;

		if (rodId == 1) {
			firstRod = rod;
		} else if (rodId == 2) {
			firstRod = rod.getNext().getNext();
		} else {
			firstRod = rod.getNext();
		}

		LOG.debug("{}---{}---{}", firstRod.getStack(), firstRod.getNext().getStack(),
				firstRod.getNext().getNext().getStack());
	}

	/**
	 * Solution #2
	 * 
	 *  -      |      |
	 *  --     |      |
	 *  ---    |      |
	 * _____  _____  _____
	 * src    aux    dest
	 */
	public void toh(int n, Stack<Integer> src, Stack<Integer> aux, Stack<Integer> dest) {
		// base case, if 1 disk is left then move it to target rod
		if (n == 1) {
			dest.push(src.pop());
			return;
		}
		/**
		 * move all disks except the last/largest from src to aux rod (that's
		 * why aux and dest rods are swapped in func call so that aux rod
		 * becomes destination for all but the largest disk)
		 * 
		 *   |     |       |
		 *   |     -       |
		 *  ---    --      |
		 * _____  _____  _____
		 *  src    aux   dest
		 */
		toh(n - 1, src, dest, aux);

		/**
		 * move the last disk from src to dest rod
		 * 
		 *   |     |       |
		 *   |     -       |
		 *   |     --     ---
		 * _____  _____  _____
		 *  src    aux   dest
		 */
		dest.push(src.pop());

		/**
		 * move the remaining disks from aux to target rod, that's why aux and
		 * src rods are swapped in a func call so aux rod becomes src
		 * 
		 *   |     |       -
		 *   |     |      --
		 *   |     |      ---
		 * _____  _____  _____
		 *  src    aux   dest
		 */
		toh(n - 1, aux, src, dest);
	}

	@Test
	public void testTOH() {
		Stack<Integer> src = new Stack<>();
		src.push(3);
		src.push(2);
		src.push(1);

		Stack<Integer> aux = new Stack<>();
		Stack<Integer> dest = new Stack<>();

		toh(3, src, aux, dest);

		Assert.assertTrue(dest.pop() == 1);
		Assert.assertTrue(dest.pop() == 2);
		Assert.assertTrue(dest.pop() == 3);
	}

	@Test
	public void test3Disks() {
		int numOfDisks = 3;
		Rod firstRod = createRods(numOfDisks);
		LOG.debug("Initial Rods:\n1. {}\n2. {}\n3. {}", firstRod.getStack(),
				firstRod.getNext().getStack(), firstRod.getNext().getNext().getStack());

		moveDisks(firstRod, firstRod.getStack().size());

		LOG.debug("Final Rods:\n1. {}\n2. {}\n3. {}", firstRod.getStack(),
				firstRod.getNext().getStack(), firstRod.getNext().getNext().getStack());

		Assert.assertTrue(firstRod.getStack().isEmpty());
		Assert.assertTrue(firstRod.getNext().getStack().isEmpty());

		Rod finalRod = firstRod.getNext().getNext();
		Stack<Integer> finalStack = finalRod.getStack();

		for (int i = 1; i <= numOfDisks; i++) {
			Assert.assertTrue(finalStack.pop() == i);
		}

		LOG.debug("Moves: {}", moves);

		Assert.assertTrue(moves == 7);
	}

	@Test
	public void test4Disks() {
		int numOfDisks = 4;
		Rod firstRod = createRods(numOfDisks);
		LOG.debug("Initial Rods:\n1. {}\n2. {}\n3. {}", firstRod.getStack(),
				firstRod.getNext().getStack(), firstRod.getNext().getNext().getStack());

		moveDisks(firstRod, firstRod.getStack().size());

		LOG.debug("Final Rods:\n1. {}\n2. {}\n3. {}", firstRod.getStack(),
				firstRod.getNext().getStack(), firstRod.getNext().getNext().getStack());

		Assert.assertTrue(firstRod.getStack().isEmpty());
		Assert.assertTrue(firstRod.getNext().getStack().isEmpty());

		Rod finalRod = firstRod.getNext().getNext();
		Stack<Integer> finalStack = finalRod.getStack();

		for (int i = 1; i <= numOfDisks; i++) {
			Assert.assertTrue(finalStack.pop() == i);
		}

		LOG.debug("Moves: {}", moves);

		Assert.assertTrue(moves == 15);
	}

}
