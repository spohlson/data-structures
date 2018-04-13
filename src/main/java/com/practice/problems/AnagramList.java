package com.practice.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class AnagramList {

	/*
	 * INPUT anagrams(["xxy", "cab", "bca", "cab", "bac", "dash", "shad"])
	 * 
	 * OUTPUT [ ["xxy"], ["cab", "bca’, "bac"], ["dash", "shad"] ]
	 * 
	 * Group strings that are anagram of each other into a list without
	 * duplicate.
	 * 
	 * ‘cab’ is an example duplicates removed. There are 2 ‘cab’ in the input
	 * and only 1 ‘cab’ in the output. You can think of anagram as two words
	 * that have the same count per letter. You should treat upper and lower
	 * case differently. "xxy’ is by itself because it doesn’t have any other
	 * strings that are anagram with ’xxy’
	 * 
	 * Abc and abc are NOT anagrams abcc and abc are NOT anagrams abc and cab
	 * are anagrams because each of them has 1 a, 1 b, and 1 c
	 */

	/**
	 * Runtime Complexity: O(N)
	 * Space Complexity: O(N)
	 */
	public List<List<String>> anagrams(List<String> strList) {
		List<List<String>> anagrams = new ArrayList<>();

		Map<String, Set<String>> alphabetizedMap = new HashMap<>();

		for (String str : strList) {
			String sortedStr = alphabetize(str);

			if (!alphabetizedMap.containsKey(sortedStr)) {
				Set<String> strSet = new HashSet<>();
				strSet.add(str);

				alphabetizedMap.put(sortedStr, strSet);
			} else {
				Set<String> strSet = alphabetizedMap.get(sortedStr);
				strSet.add(str);
			}
		}

		for (String key : alphabetizedMap.keySet()) {
			Set<String> strSet = alphabetizedMap.get(key);
			anagrams.add(new ArrayList<>(strSet));
		}

		return anagrams;
	}

	public String alphabetize(String str) {
		char[] arr = str.toCharArray();
		Arrays.sort(arr);
		return new String(arr);
	}

	/////////////////////////////////////////////////////

	/**
	 * Runtime Complexity: O(N^2)
	 * Space Complexity: O(N)
	 */
	public List<List<String>> findAnagramsBruteForce(List<String> strList) {
		List<List<String>> anagramsList = new ArrayList<>();
		Set<Integer> checkedIndexes = new HashSet<>();

		for (int i = 0; i < (strList.size() - 1); i++) {

			if (checkedIndexes.contains(i)) {
				continue;
			}

			String str = strList.get(i);
			Set<String> anagramSet = new HashSet<>();
			anagramSet.add(str);

			for (int j = i + 1; j < strList.size(); j++) {
				String next = strList.get(j);

				boolean isAnagram = isAnagram(str, next);

				if (isAnagram) {
					checkedIndexes.add(j);
					anagramSet.add(next);
				}
			}

			anagramsList.add(new ArrayList<>(anagramSet));
		}
		return anagramsList;
	}

	public boolean isAnagram(String str1, String str2) {
		Map<Character, Integer> strMap = new HashMap<>();

		for (int i = 0; i < str1.length(); i++) {
			char letter = str1.charAt(i);

			if (strMap.containsKey(letter)) {
				strMap.put(letter, strMap.get(letter) + 1);
			} else {
				strMap.put(letter, 1);
			}
		}

		for (int i = 0; i < str2.length(); i++) {
			char letter = str2.charAt(i);

			if (!strMap.containsKey(letter)) {
				return false;
			} else {
				int freq = strMap.get(letter);

				if (freq == 1) {
					strMap.remove(letter);
				} else {
					strMap.put(letter, freq - 1);
				}
			}
		}
		return strMap.isEmpty();
	}

	/**
	 * Tester Method
	 */
	public void assertListEquals(List<List<String>> expected, List<List<String>> output) {
		Assert.assertTrue(output.size() == expected.size());

		for (int i = 0; i < expected.size(); i++) {
			List<String> expectedList = expected.get(i);
			List<String> outputList = output.get(i);

			Assert.assertTrue(outputList.size() == expectedList.size());

			for (int j = 0; j < expectedList.size(); j++) {
				String expectedStr = expectedList.get(j);
				String outputStr = outputList.get(j);

				Assert.assertTrue(expectedStr.equals(outputStr));
			}
		}
	}

	@Test
	public void test() {
		List<String> strings = new ArrayList<>();
		strings.add("xxy");
		strings.add("cab");
		strings.add("bca");
		strings.add("cab");
		strings.add("bac");
		strings.add("dash");
		strings.add("shad");

		List<List<String>> expected = new ArrayList<>();
		expected.add(Arrays.asList("bca", "cab", "bac"));
		expected.add(Arrays.asList("dash", "shad"));
		expected.add(Arrays.asList("xxy"));

		List<List<String>> output = anagrams(strings);

		assertListEquals(expected, output);
	}

	@Test
	public void test1() {
		List<String> strings = new ArrayList<>();
		strings.add("cab");
		strings.add("bca");
		strings.add("abcc");

		List<List<String>> expected = new ArrayList<>();
		expected.add(Arrays.asList("bca", "cab"));
		expected.add(Arrays.asList("abcc"));

		List<List<String>> output = anagrams(strings);

		assertListEquals(expected, output);
	}

	@Test
	public void testBruteForce() {
		List<String> strings = new ArrayList<>();
		strings.add("xxy");
		strings.add("cab");
		strings.add("bca");
		strings.add("cab");
		strings.add("bac");
		strings.add("dash");
		strings.add("shad");

		List<List<String>> expected = new ArrayList<>();
		expected.add(Arrays.asList("xxy"));
		expected.add(Arrays.asList("bca", "cab", "bac"));
		expected.add(Arrays.asList("dash", "shad"));

		List<List<String>> output = findAnagramsBruteForce(strings);

		assertListEquals(expected, output);
	}

}
