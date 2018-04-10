package com.practice.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class GreedyCoins {

	/**
	 * Say you're a cashier and need to give someone 67 cents using as few coins
	 * as possible. How would you do it?
	 * 
	 * Write a function that returns a list of the fewest number of coin values
	 * that adds up to the given int cents argument.
	 * 
	 * Ex. getFewestCoins(int 67) --> [25, 25, 10, 5, 1, 1]
	 */
	private static final int[] coins = new int[] { 25, 10, 5, 1 };

	public List<Integer> getFewestCoins(int cents) {
		List<Integer> fewestCoins = new ArrayList<>();

		int remaining = cents;

		for (int coin : coins) {
			int div = remaining / coin;

			if (div > 0) {
				int i = 0;

				while (i < div) {
					remaining -= coin;
					fewestCoins.add(coin);
					i++;
				}
			}
		}

		if (remaining > 0) {
			throw new RuntimeException("Failed");
		}

		return fewestCoins;
	}

	@Test
	public void test() {
		int cents = 67;
		List<Integer> expected = new ArrayList<>(Arrays.asList(25, 25, 10, 5, 1, 1));
		List<Integer> output = getFewestCoins(cents);

		Assert.assertEquals(expected, output);
	}

	@Test
	public void test1() {
		int cents = 154;
		List<Integer> expected = new ArrayList<>(Arrays.asList(25, 25, 25, 25, 25, 25, 1, 1, 1, 1));
		List<Integer> output = getFewestCoins(cents);

		Assert.assertEquals(expected, output);
	}

	@Test
	public void test2() {
		int cents = 145;
		List<Integer> expected = new ArrayList<>(Arrays.asList(25, 25, 25, 25, 25, 10, 10));
		List<Integer> output = getFewestCoins(cents);

		Assert.assertEquals(expected, output);
	}

}
