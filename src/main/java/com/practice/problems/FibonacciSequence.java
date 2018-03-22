package com.practice.problems;

import org.junit.Assert;
import org.junit.Test;

public class FibonacciSequence {

	/**
	 * The Fibonacci Sequence is a series of numbers in which each number is the
	 * sum of the two preceding numbers. The simplest is the series 0, 1, 1, 2,
	 * 3, 5, 8, etc.
	 * 
	 * Given n, complete the fibonacci function so it returns fibonacci(n);
	 * 
	 * Basic information you need to calculate fibonacci(n):
	 * 
	 * F(0) = 0
	 * 
	 * F(1) = 1
	 * 
	 * F(n) = F(n-1) + F(n-2)
	 * 
	 * Sample Input: 3
	 * Sample Output: 2
	 * 
	 * f(0) = 0
	 * f(1) = 1
	 * f(2) = (0 + 1) = 1
	 * f(3) = (1 + 1) = 2
	 * f(4) = (1 + 2) = 3
	 * f(5) = (2 + 3) = 5
	 * f(6) = (3 + 5) = 8
	 */

	public static int fibonacci(int n) {
		if ((n == 0) || (n == 1)) {
			return n;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	@Test
	public void test() {
		Integer output = fibonacci(3);
		Integer expected = 2;
		Assert.assertEquals(expected, output);
	}

	@Test
	public void testOne() {
		Integer output = fibonacci(6);
		Integer expected = 8;
		Assert.assertEquals(expected, output);
	}

}
