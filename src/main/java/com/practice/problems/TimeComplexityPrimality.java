package com.practice.problems;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimeComplexityPrimality {

	/**
	 * A prime # is defined as any counting # that is divisible by exactly two
	 * distinct counting #s: 1 and itself. Therefore 1 is not prime b/c it is
	 * divisible by only one distinct counting #: 1. 2 is prime b/c it is
	 * divisible by two distinct counting #s: 1 and 2.
	 * 
	 * A prime # is a natural # greater than 1 that has no positive divisors
	 * other than 1 and itself.
	 * 
	 * Given p integers, determine the primality of each integer and print
	 * whether it is a "Prime" or "Not prime" on a new line.
	 * 
	 * Note: If possible, try to come up with an O(square root of n) primality
	 * algorithm, or see what sort of optimizations you can come up with for an
	 * O(n) algorithm.
	 * 
	 * Input Format: The 1st line contains an integer, p, denoting the # of
	 * integers to check for primality. Each of the p subsequent lines contains
	 * an integer, n, you must test for primality.
	 * 
	 * Sample Input: 3 12 5 7
	 * 
	 * Sample Output: Not prime Prime Prime
	 */

	private static final Logger LOG = LoggerFactory.getLogger(TimeComplexityPrimality.class);

	public boolean isPrime(int num) {
		if ((num % 2) == 0) {
			return false;
		}

		// check the odds
		for (int i = 3; (i * i) <= num; i += 2) {

			if ((num % i) == 0) {
				return false;
			}
		}
		return true;
	}

	// public static boolean isPrime(Integer num) {
	// if ((num == 0) || (num == 1)) {
	// return false;
	// } else if (num == 2) {
	// return true;
	// }
	//
	// Double[] divArr = new Double[] { 2.0, 3.0, 5.0, 7.0 };
	// Double doubleNum = new Double(num);
	//
	// for (Double numToDivBy : divArr) {
	//
	// if (!doubleNum.equals(numToDivBy)) {
	// Double output = doubleNum / numToDivBy;
	// // check if whole number
	// if ((output % 1) == 0) {
	// return false;
	// }
	// }
	// }
	// return true;
	// }

	@Test
	public void tester() {
		Assert.assertTrue(isPrime(1000000007));

		Assert.assertFalse(isPrime(100000003));

		Assert.assertTrue(isPrime(1000003));
	}

	@Test
	public void test() {
		List<Integer> primeArr = new ArrayList<>();
		List<Integer> notPrimeArr = new ArrayList<>();

		int num = 0;
		int cap = 100;

		while (num <= cap) {

			if (isPrime(num)) {
				primeArr.add(num);
			} else {
				notPrimeArr.add(num);
			}
			num++;
		}
		LOG.info("Prime #s: {}", primeArr);
		LOG.info("Non-prime #s: {}", notPrimeArr);
	}

	@Test
	public void test1() {
		Double[] arr = new Double[] { 25.0, 35.0, 49.0, 55.0, 65.0, 77.0, 85.0, 91.0, 95.0 };

		for (Double num : arr) {
			Double count = 4.0;

			while (count < 10) {
				Double output = num / count;

				if ((output % 1) == 0) {
					LOG.info("Num: {} --> {}", num, count);
					break;
				}
				count++;
			}
		}
	}

}
