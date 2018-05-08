package com.practice.problems;

import org.junit.Assert;
import org.junit.Test;

public class LongestPalindromicSubstring {

	/**
	 * Given a string, find the longest substring which is palindrome. For
	 * example, if the given string is “forgeeksskeegfor”, the output should be
	 * “geeksskeeg”.
	 * 
	 * Time: O(n^2)
	 * Space: O(1)
	 */
	public String getLongestPalindromicSubstring(String str) {
		String longest = str.substring(0, 1);

		for (int i = 0; i < str.length(); i++) {
			// check for odd palindromes
			String tmp = helper(str, i, i);

			if (tmp.length() > longest.length()) {
				longest = tmp;
			}

			// check for even palindromes
			tmp = helper(str, i, i + 1);

			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
		}
		return longest;
	}

	private String helper(String str, int start, int end) {
		while ((start >= 0) && (end <= (str.length() - 1))
				&& (str.charAt(start) == str.charAt(end))) {
			start--;
			end++;
		}
		return str.substring(start + 1, end);
	}

	@Test
	public void test() {
		String str = "forgeeksskeegfor";
		String expected = "geeksskeeg";
		String output = getLongestPalindromicSubstring(str);
		Assert.assertTrue(expected.equals(output));

		str = "helloradar";
		expected = "radar";
		output = getLongestPalindromicSubstring(str);
		Assert.assertTrue(expected.equals(output));
	}

}
