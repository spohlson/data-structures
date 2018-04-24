package com.practice.problems;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LongestCommonSubsequence {

	/**
	 * Given two sequences, find the length of longest subsequence present in
	 * both of them. A subsequence is a sequence that appears in the same
	 * relative order, but not necessarily contiguous. For example, “abc”,
	 * “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”. So a
	 * string of length n has 2^n different possible subsequences.
	 */

	private static final Logger LOG = LoggerFactory.getLogger(LongestCommonSubsequence.class);

	@Test
	public void test1() {
		String seq1 = "ABCDGH";
		String seq2 = "AEDFHR";
		String expected = "ADH";
		String output = getLCS(seq1, seq2);
		Assert.assertTrue(expected.equals(output));
	}

	@Test
	public void test2() {
		String seq1 = "AGGTAB";
		String seq2 = "GXTXAYB";
		String expected = "GTAB";
		String output = getLCS(seq1, seq2);
		Assert.assertTrue(expected.equals(output));
	}

	@Test
	public void test3() {
		String seq1 = "AGGTAB";
		String seq2 = "GXTXAYB";
		LOG.info("Seq1 - {}", seq1);
		LOG.info("Seq2 - {}", seq2);
		int expected = 4;
		int output = lcs(seq1.toCharArray(), seq2.toCharArray(), seq1.length(), seq2.length());
		Assert.assertTrue(expected == output);
	}

	public int lcs(char[] seq1, char[] seq2, int seq1Len, int seq2Len) {
		if ((seq1Len == 0) || (seq2Len == 0)) {
			return 0;
		}
		char seq1Char = seq1[seq1Len - 1];
		char seq2Char = seq2[seq2Len - 1];

		LOG.info("Comparing seq1 {} {} to seq2 {} {}", seq1Len - 1, seq1Char, seq2Len - 1,
				seq2Char);

		if (seq1Char == seq2Char) {
			LOG.info("Matched: seq1 - {} {}, seq2 - {} {}", seq1Len - 1, seq1Char, seq2Len - 1,
					seq2Char);
			LOG.info("+1");
			return 1 + lcs(seq1, seq2, seq1Len - 1, seq2Len - 1);
		}
		return max(lcs(seq1, seq2, seq1Len, seq2Len - 1), lcs(seq1, seq2, seq1Len - 1, seq2Len));
	}

	public int max(int a, int b) {
		return (a > b) ? a : b;
	}

	public String getLCS(String str1, String str2) {
		int str1Len = str1.length();
		Map<Character, Integer> str1Map = new HashMap<>(str1Len);

		for (int i = 0; i < str1Len; i++) {
			str1Map.put(str1.charAt(i), i);
		}

		int maxSub = 0;
		String seq = null;

		for (int i = 0; i < str2.length(); i++) {
			int count = 0;
			char letter = str2.charAt(i);

			if (str1Map.containsKey(letter)) {
				count++;
				seq = "" + letter;

				int index = str1Map.get(letter);

				for (int j = i + 1; j < str2.length(); j++) {
					char next = str2.charAt(j);

					if (str1Map.containsKey(next)) {
						int nextIndex = str1Map.get(next);

						if (nextIndex > index) {
							count++;
							seq += next;

						}
					}
				}
			}
		}

		return seq;
	}

}
