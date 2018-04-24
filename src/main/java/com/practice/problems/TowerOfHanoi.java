package com.practice.problems;

import java.util.Stack;

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

	private Stack<Integer> rod1;
	private Stack<Integer> rod2;
	private Stack<Integer> rod3;

	public void init() {
		rod1 = new Stack<>();
		rod1.push(3);
		rod1.push(2);
		rod1.push(1);

		rod2 = new Stack<>();
		rod3 = new Stack<>();
	}

	public void moveAllDisksToAnotherRod() {
		// move 1 to rod3
		int one = rod1.pop();
		rod3.push(one);
		// move 2 to rod2
		int two = rod1.pop();
		rod2.push(two);
		// move 1 to rod2
		one = rod3.pop();
		rod2.push(one);
		// move 3 to rod3
		int three = rod1.pop();
		rod3.push(three);
		// move 1 to rod1
		one = rod2.pop();
		rod1.push(one);
		// move 2 to rod3
		two = rod2.pop();
		rod3.push(two);
		// move 1 to rod3
		one = rod1.pop();
		rod3.push(one);
	}

	public void logRod(Stack<Integer> rod) {
		LOG.info("{}", rod);
	}

	@Test
	public void test() {
		init();
		logRod(rod1);
		moveAllDisksToAnotherRod();
		logRod(rod3);
	}

}
