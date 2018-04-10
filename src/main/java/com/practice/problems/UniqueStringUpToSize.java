package com.practice.problems;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class UniqueStringUpToSize {

	/**
	 * Given a string and int size, find if the string is unique up to the
	 * length specified in size.
	 */

	public boolean isUnique(String str, int uniqueLength) {
		int i = 0;
		Set<Character> set = new HashSet<>(uniqueLength);

		while (i < uniqueLength) {
			char letter = str.charAt(i);

			if (set.contains(letter)) {
				return false;
			} else {
				set.add(letter);
			}
			i++;
		}
		return true;
	}

	@Test
	public void test() {
		String str = "abcdddddd";
		int uniqueLength = 3;

		Assert.assertTrue(isUnique(str, uniqueLength));
	}

	@Test
	public void test1() {
		String str = "abbcdefg";
		int uniqueLength = 5;

		Assert.assertFalse(isUnique(str, uniqueLength));
	}

}
