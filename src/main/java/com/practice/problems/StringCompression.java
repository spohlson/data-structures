package com.practice.problems;

import org.junit.Assert;
import org.junit.Test;

public class StringCompression {

	/**
	 * 1. Given a string "aaabbbcc", compress it = "a3b3c2" . Given that output
	 * string's length is always smaller than input string, you have do it
	 * inplace. No extra space
	 * 
	 * 2. Given an array of characters, compress it in-place. The length after
	 * compression must always be smaller than or equal to the original array.
	 * Every element of the array should be a character (not int) of length 1.
	 * After you are done modifying the input array in-place, return the new
	 * length of the array.
	 */
	public String compressString(String str) {
		int len = str.length();

		if (len <= 1) {
			return str;
		}
		StringBuilder b = new StringBuilder();

		for (int i = 0; i < len; i++) {
			char letter = str.charAt(i);
			int count = 1;

			while ((i < (len - 1)) && (letter == str.charAt(i + 1))) {
				count++;
				i++;
			}
			b.append(letter);

			if (count > 1) {
				b.append(count);
			}
		}
		return b.toString();
	}

	@Test
	public void testCompressString() {
		String str = "aaabbbcc";
		String expected = "a3b3c2";
		String output = compressString(str);
		Assert.assertTrue(expected.equals(output));

		str = "abbbbbbbbbbbb";
		expected = "ab12";
		output = compressString(str);
		Assert.assertTrue(expected.equals(output));

		str = "a";
		expected = "a";
		output = compressString(str);
		Assert.assertTrue(expected.equals(output));
	}


}
