package com.practice.problems;

import org.junit.Assert;
import org.junit.Test;

public class GCD {

	/**
	 * Given 2 non negative integers m and n, find gcd(m, n)
	 * 
	 * GCD of 2 integers m and n is defined as the greatest integer g such that
	 * g is a divisor of both m and n. Both m and n fit in a 32 bit signed
	 * integer.
	 * 
	 * Note: DO NOT USE LIBRARY FUNCTIONS
	 */

	public int gcdSolution(int a, int b) {
		if (a == 0) {
			return b;
		}
		return gcdSolution(b % a, a);
	}

	public int timedGcd(int a, int b) {
		long startTime = System.nanoTime();
		int gcd = gcd(a, b);
		long endTime = System.nanoTime();
		System.out.println("That took " + (endTime - startTime) + " nanoseconds");
		return gcd;
	}

	public int gcd(int a, int b) {
		int higherNum = (a > b) ? a : b;

		if ((a == 0) || (b == 0) || (a == b)) {
			return higherNum;
		}
		int lowerNum = (a < b) ? a : b;

		int count = 1;
		int gcd = 1;

		while (count <= lowerNum) {

			if (((lowerNum % count) == 0) && ((higherNum % count) == 0)) {
				gcd = count;
			}
			count++;
		}
		return gcd;
	}

	public int timedGcdEuclid(int a, int b) {
		long startTime = System.nanoTime();
		int gcd = gcdEuclid(a, b);
		long endTime = System.nanoTime();
		System.out.println("That took " + (endTime - startTime) + " nanoseconds");
		return gcd;
	}

	public int gcdEuclid(int a, int b) {
		int higherNum = (a > b) ? a : b;

		if ((a == 0) || (b == 0) || (a == b)) {
			return higherNum;
		}
		int lowerNum = (higherNum == a) ? b : a;

		int gcd = euclid(higherNum, lowerNum);
		return gcd;
	}

	private int euclid(int a, int b) {
		int remainder = a % b;

		if (remainder == 0) {
			return b;
		}
		return euclid(b, remainder);
	}

	@Test
	public void test() {
		int a = 6;
		int b = 9;
		int expected = 3;
		int output = timedGcd(a, b);
		Assert.assertTrue(expected == output);

		b = 12;
		expected = 6;
		output = timedGcd(a, b);
		Assert.assertTrue(expected == output);

		a = 2;
		b = 0;
		expected = 2;
		output = timedGcd(a, b);
		Assert.assertTrue(expected == output);

		a = 48;
		b = 18;
		expected = 6;
		output = timedGcd(a, b);
		Assert.assertTrue(expected == output);
	}

	@Test
	public void testEuclid() {
		System.out.println("--------------------");
		int a = 6;
		int b = 9;
		int expected = 3;
		int output = timedGcdEuclid(a, b);
		Assert.assertTrue(expected == output);

		b = 12;
		expected = 6;
		output = timedGcdEuclid(a, b);
		Assert.assertTrue(expected == output);

		a = 2;
		b = 0;
		expected = 2;
		output = timedGcdEuclid(a, b);
		Assert.assertTrue(expected == output);

		a = 48;
		b = 18;
		expected = 6;
		output = timedGcdEuclid(a, b);
		Assert.assertTrue(expected == output);
	}

	@Test
	public void testSolution() {
		int a = 6;
		int b = 9;
		int expected = 3;
		int output = gcdSolution(a, b);
		Assert.assertTrue(expected == output);

		b = 12;
		expected = 6;
		output = gcdSolution(a, b);
		Assert.assertTrue(expected == output);

		a = 2;
		b = 0;
		expected = 2;
		output = gcdSolution(a, b);
		Assert.assertTrue(expected == output);

		a = 48;
		b = 18;
		expected = 6;
		output = gcdSolution(a, b);
		Assert.assertTrue(expected == output);

		a = 48;
		b = 0;
		expected = 48;
		output = gcdSolution(a, b);
		Assert.assertTrue(expected == output);

		a = 56;
		b = 42;
		expected = 14;
		output = gcdSolution(a, b);
		Assert.assertTrue(expected == output);
	}

}
