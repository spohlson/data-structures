package com.practice.problems;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class ValidateCharSequences {

	/**
	 * Write a function that validates whether a char[] has the correct
	 * subsequences:
	 * 
	 * A
	 * BX
	 * CXX
	 * DXXX
	 * EXXXX
	 * FXXXXX
	 * 
	 * Valid array examples:
	 * AAAAA
	 * BXAAEXXXX
	 * FXXXXXBXBXDXXXAA
	 * 
	 * Invalid array examples:
	 * BAAA
	 * DXBXACXXX
	 */

	private int xCount = 0;

	private static Map<Character, Integer> xMap;

	static {
		xMap = new HashMap<>(6);
		xMap.put('A', 0);
		xMap.put('B', 1);
		xMap.put('C', 2);
		xMap.put('D', 3);
		xMap.put('E', 4);
		xMap.put('F', 5);
	}

	public boolean isValid(char[] input) {
		for (char letter : input) {

			if (xCount != 0) {

				if (letter != 'X') {
					return false;
				}
				xCount--;
			} else if (!xMap.containsKey(letter)) {
				return false;
			} else {
				xCount = xMap.get(letter);
			}
		}

		return true;
	}

	public void test(String sequence, boolean expected) {
		char[] arr = sequence.toCharArray();
		boolean output = isValid(arr);
		Assert.assertTrue(expected == output);
	}

	@Test
	public void test1() {
		String seq = "AAAAA";
		boolean expected = true;
		test(seq, expected);
	}

	@Test
	public void test2() {
		String seq = "BXAAEXXXX";
		boolean expected = true;
		test(seq, expected);
	}

	@Test
	public void test3() {
		String seq = "FXXXXXBXBXDXXXAA";
		boolean expected = true;
		test(seq, expected);
	}

	@Test
	public void test4() {
		String seq = "BAAA";
		boolean expected = false;
		test(seq, expected);
	}

	@Test
	public void test5() {
		String seq = "BXXXAAA";
		boolean expected = false;
		test(seq, expected);
	}

	@Test
	public void test6() {
		String seq = "DXBXACXXX";
		boolean expected = false;
		test(seq, expected);
	}

	@Test
	public void test7() {
		String seq = "CXXADXXXBXAX";
		boolean expected = false;
		test(seq, expected);
	}

}
