package com.practice.problems;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FizzBuzz {

	private static final Logger LOG = LoggerFactory.getLogger(FizzBuzz.class);

	/*
	 * Print the numbers 1-100. For multiples of 3, print "Fizz" instead of the
	 * number. For multiples of 5, print "Buzz" instead of the number. For
	 * multiples of both 3 and 5 print "FizzBuzz" instead of the number.
	 * 
	 * A Step Further: Fill an array instead of printing.
	 */
	public String getFizzBuzzString(int n) {
		String str = "";

		if ((n % 3) == 0) {
			str = "Fizz";
		}

		if ((n % 5) == 0) {
			str += "Buzz";
		}

		if (str.isEmpty()) {
			str = String.valueOf(n);
		}
		return str;
	}

	public void fizzBuzzPrint(int n) {
		if (n > 100) {
			return;
		}
		String str = getFizzBuzzString(n);

		LOG.info(str);

		fizzBuzzPrint(n + 1);
	}

	@Test
	public void testFizzBuzzPrint() {
		int n = 1;
		fizzBuzzPrint(n);
	}

	/**
	 * n should always start at 1
	 */
	public String[] fizzBuzzArray(String[] arr, int n) {
		if (n >= arr.length) {
			return arr;
		}
		String str = getFizzBuzzString(n);

		arr[n - 1] = str;

		return fizzBuzzArray(arr, n + 1);
	}

	@Test
	public void testFizzBuzzArray() {
		String[] arr = fizzBuzzArray(new String[100], 1);
		Assert.assertTrue(arr[14].equals("FizzBuzz"));
		Assert.assertTrue(arr[29].equals("FizzBuzz"));
		Assert.assertTrue(arr[17].equals("Fizz"));
		Assert.assertTrue(arr[19].equals("Buzz"));
		Assert.assertTrue(arr[30].equals("31"));
		Assert.assertTrue(arr[31].equals("32"));
	}

	/**
	 * 
	 * This is slightly more difficult version of the famous FizzBuzz problem
	 * which is sometimes given as a first problem for job interviews. (See
	 * also: FizzBuzz Code.) Consider the series of numbers beginning at start
	 * and running up to but not including end, so for example start=1 and end=5
	 * gives the series 1, 2, 3, 4. Return a new String[] array containing the
	 * string form of these numbers, except for multiples of 3, use "Fizz"
	 * instead of the number, for multiples of 5 use "Buzz", and for multiples
	 * of both 3 and 5 use "FizzBuzz". In Java, String.valueOf(xxx) will make
	 * the String form of an int or other type. This version is a little more
	 * complicated than the usual version since you have to allocate and index
	 * into an array instead of just printing, and we vary the start/end instead
	 * of just always doing 1..100.
	 * 
	 * 
	 * fizzBuzz(1, 6) → ["1", "2", "Fizz", "4", "Buzz"]
	 * fizzBuzz(1, 8) → ["1", "2", "Fizz", "4", "Buzz", "Fizz", "7"]
	 * fizzBuzz(1, 11) → ["1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz"]
	 */
	public String[] fizzBuzzArray2(int start, int end) {
		String[] arr = new String[end - start];
		int i = 0;

		while (start < end) {
			arr[i] = getFizzBuzzString(start);
			i++;
			start++;
		}
		return arr;
	}

	@Test
	public void testFizzBuzz() {
		int start = 1;
		int end = 6;
		String[] arr = new String[] { "1", "2", "Fizz", "4", "Buzz" };
		Assert.assertArrayEquals(arr, fizzBuzzArray2(start, end));

		start = 1;
		end = 8;
		arr = new String[] { "1", "2", "Fizz", "4", "Buzz", "Fizz", "7" };
		Assert.assertArrayEquals(arr, fizzBuzzArray2(start, end));

		start = 1;
		end = 11;
		arr = new String[] { "1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz" };
		Assert.assertArrayEquals(arr, fizzBuzzArray2(start, end));
	}

}
