package com.practice.concepts;

import org.junit.Assert;
import org.junit.Test;

public class DynamicProgrammingOverlappingSubProblems {

	/**
	 * Dynamic Programming:
	 * 
	 * an algorithmic paradigm that solves a given complex problem by breaking
	 * it into subproblems and storing the results of subproblems to avoid
	 * computing the same results again.
	 * 
	 * Overlapping SubProblems Property:
	 * 
	 * when a problem can be broken down into subproblems which are reused
	 * several times or a recursive algorithm solves the same subproblem over
	 * and over rather than always generating new subproblems.
	 * 
	 * EXAMPLE: Fibonacci Sequence
	 * 
	 * 2 Ways to Store Values so they can be Reused:
	 * 
	 * 1. Memoization (Top Down): similar to the recursive version but includes
	 * a lookup table before computing solutions. Whenever you need a solution
	 * to a subproblem, first look in the lookup table. If present, return
	 * value, otherwise compute and add result in the lookup table.
	 * 
	 * 2. Tabulation (Bottom Up): Builds a table in bottom up fashion and
	 * returns the last entry from the table. For example, for the same
	 * Fibonacci number, we first calculate fib(0) then fib(1) then fib(2) then
	 * fib(3) and so on.
	 */

	/**
	 * Example of Overlapping SubProblems Property - Recursive Fibonacci
	 * Sequence
	 */
	public int recursiveFib(int n) {

		if (n <= 1) {
			return n;
		}

		return recursiveFib(n - 1) + recursiveFib(n - 2);
	}

	/**
	 * Example of Memoization with Fibonacci
	 */
	public class MemoizationFibonacci {

		private final int MAX = 100;
		private final int NIL = -1;

		private int[] lookup;

		public MemoizationFibonacci() {
			lookup = new int[MAX];

			for (int i = 0; i < MAX; i++) {
				lookup[i] = NIL;
			}
		}

		public int fib(int n) {

			if (lookup[n] == NIL) {

				if (n <= 1) {
					lookup[n] = n;
				} else {
					lookup[n] = fib(n - 1) + fib(n - 2);
				}
			}

			return lookup[n];
		}

	}

	/**
	 * Example of Tabulation with Fibonacci
	 */
	public int tabulationFib(int n) {
		int[] fib = new int[n + 1];
		fib[0] = 0;
		fib[1] = 1;

		for (int i = 2; i <= n; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
		}
		return fib[n];
	}

	@Test
	public void memoizationTest() {
		int n = 40;
		int expected = 102334155;
		MemoizationFibonacci mem = new MemoizationFibonacci();
		int output = mem.fib(n);
		Assert.assertTrue(output == expected);
	}

	@Test
	public void tabulationTest() {
		int n = 40;
		int expected = 102334155;
		int output = tabulationFib(n);
		Assert.assertTrue(output == expected);
	}

}
