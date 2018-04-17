package com.practice.problems;

import org.junit.Assert;
import org.junit.Test;

public class MultiplesOf3or5 {

	/**
	 * If we list all the natural numbers below 10 that are multiples of 3 or 5,
	 * we get 3, 5, 6 and 9. The sum of these multiples is 23.
	 * 
	 * Find the sum of all the multiples of 3 or 5 below 1000.
	 */

	public int findSumOfMultiples(int num) {
		int sum = 0;
		int count = 1;

		while (count < num) {

			if (((count % 3) == 0) || ((count % 5) == 0)) {
				sum += count;
			}
			count++;
		}

		return sum;
	}

	@Test
	public void test() {
		int num = 10;
		// 3 + 5 + 6 + 9 = 23
		int expected = 23;

		int output = findSumOfMultiples(num);

		Assert.assertTrue(expected == output);
	}

	@Test
	public void test1000() {
		int output = findSumOfMultiples(1000);
		System.out.println(output);
	}

}
