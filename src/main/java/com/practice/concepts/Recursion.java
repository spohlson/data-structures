package com.practice.concepts;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class Recursion {

	/**
	 * 1. Break the problem into a problem that is ONE step simpler.
	 * 
	 * 2. Assume that the function will work to solve the simpler problem.
	 * 
	 * 3. Ask: Since I know I can solve the simpler problem, how would I solve
	 * the more complex problem?
	 */

	/**
	 * Reverse a string.
	 * 
	 * 1. One step simpler would be reversing a string that is one letter
	 * shorter.
	 * 
	 * 2. Assume that my function can correctly reverse a string that is one
	 * letter shorter than the one I am currently trying to reverse.
	 * 
	 * 3. Ask: Since I know and believe that my function can correctly reverse a
	 * string that is one letter shorter than the one I am currently trying to
	 * reverse, how can I reverse the whole string? - I can take all the
	 * characters except the first one, reverse those and then tack the first
	 * character on to the end.
	 */
	public String reverse(String str) {
		// base case
		if (str.length() < 2) {
			return str;
		}
		String letter = String.valueOf(str.charAt(0));

		return reverse(str.substring(1)) + letter;
	}

	@Test
	public void testReverseString() {
		String str = "standard";
		String expected = "dradnats";
		String output = reverse(str);
		Assert.assertTrue(expected.equals(output));
	}

	/**
	 * Go through an array and print out all the elements.
	 * 
	 * 1. One step simpler: printing array that is one element smaller
	 * 
	 * 3. I can take all elements except the last one and print them then print
	 * the last one.
	 */
	public void printElementsInArray(String[] arr) {
		int len = arr.length;

		if (len == 0) {
			return;
		}
		System.out.print(arr[0]);
		printElementsInArray(Arrays.copyOfRange(arr, 1, len));
	}

	@Test
	public void testPrintElementsInArray() {
		String[] arr = new String[] { "h", "e", "l", "l", "o" };
		printElementsInArray(arr);
	}

	/**
	 * Determine whether or not a string is a palindrome: radar, abcba
	 * 
	 * 1. One step simpler: String had one less letter to check
	 * 
	 * Function should check if beginning letter matches end letter
	 * 
	 * 3. I can take all letters except the first one and check if they have a
	 * matching letter
	 */
	public boolean isPalindrome(String str) {
		int len = str.length();

		if (len == 1) {
			return true;
		} else if ((len == 2) || (str.charAt(0) != str.charAt(len - 1))) {
			return false;
		}

		return isPalindrome(str.substring(1, len - 1));
	}

	@Test
	public void testIsPalindromeTrue() {
		String str = "radar";
		boolean output = isPalindrome(str);
		Assert.assertTrue(output);
	}

	@Test
	public void testIsPalindromeFalse() {
		String str = "hello";
		boolean output = isPalindrome(str);
		Assert.assertFalse(output);
	}

	@Test
	public void testIsPalindromeFalse1() {
		String str = "raddar";
		boolean output = isPalindrome(str);
		Assert.assertFalse(output);
	}

	/**
	 * Calculate num a raised to the power of num b
	 * 
	 * 1. One step simpler: calculating a to the power of b - 1
	 * 
	 * 3.
	 */
	public int calculatePowerOf(int a, int b) {
		if (b == 0) {
			return 1;
		} else if (b == 1) {
			return a;
		}

		return calculatePowerOf(a, b - 1) * a;
	}

	@Test
	public void testCalculatePowerOf() {
		int a = 2;
		int b = 4;
		int expected = 16;
		int output = calculatePowerOf(a, b);
		Assert.assertTrue(expected == output);
	}

	@Test
	public void testCalculatePowerOf1() {
		int a = 9;
		int b = 6;
		int expected = 531441;
		int output = calculatePowerOf(a, b);
		Assert.assertTrue(expected == output);
	}

	/**
	 * Try implementing the map function (the one that transforms arrays)
	 * without using loops
	 */

}
