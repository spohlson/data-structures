package com.practice.problems;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

import com.practice.utilities.Dictionary;

public class FindAllNearbyWords {

	/**
	 * When typing on a touch screen, occasionally the wrong key is registered.
	 * For example, when typing "Hello", a "G" might be registered instead of
	 * "H".
	 * 
	 * Write a function that given a string, returns all nearby words.
	 * Set<String> getNearbyWords(String word) {}
	 * 
	 * You are given the following helper functions:
	 * 
	 * for a given character, return all nearby characters:
	 * Set<Character> getNearbyChars(char letter) {}
	 * 
	 * for a given string, return true if it is a word:
	 * boolean isWord(String word) {}
	 * 
	 * 
	 * Clarifying questions to ask:
	 * 
	 * 1. What format is the word given to us? - String
	 * 
	 * 2. How do we define a nearby word? - any word where we replace one of the
	 * characters inside the string with another character given by the
	 * getNearcyChars method. Ex. word = Hello, a nearby word would be Jello
	 * 
	 * 3. Do we need to remove duplicate words in the output?
	 * 
	 * 4. Does the output need to be sorted?
	 */

	private Dictionary dict;
	private Map<Character, Set<Character>> nearbyCharsMap;

	@Before
	public void init() {
		try {
			dict = new Dictionary();
		} catch (IOException e) {
			e.printStackTrace();
		}

		nearbyCharsMap = new HashMap<>(26);
		nearbyCharsMap.put('a', new HashSet<>(Arrays.asList('a', 'q', 'w', 's', 'z')));
		nearbyCharsMap.put('b', new HashSet<>(Arrays.asList('b', 'v', 'g', 'h', 'n', 'j')));
		nearbyCharsMap.put('c', new HashSet<>(Arrays.asList('c', 'x', 'd', 'f', 'g', 'v')));
		nearbyCharsMap.put('d', new HashSet<>(Arrays.asList('d', 's', 'e', 'r', 'f', 'c', 'x', 'z')));
		nearbyCharsMap.put('e', new HashSet<>(Arrays.asList('e', 'w', 's', 'd', 'r')));
		nearbyCharsMap.put('f', new HashSet<>(Arrays.asList('f', 'x', 'd', 'r', 't', 'g', 'v', 'c')));
		nearbyCharsMap.put('g',
				new HashSet<>(Arrays.asList('g', 'c', 'f', 't', 'y', 'h', 'b', 'v')));
		nearbyCharsMap.put('h',
				new HashSet<>(Arrays.asList('h', 'v', 'g', 'y', 'u', 'j', 'n', 'b')));
		nearbyCharsMap.put('i', new HashSet<>(Arrays.asList('i', 'u', 'j', 'k', 'o')));
		nearbyCharsMap.put('j', new HashSet<>(Arrays.asList('j', 'h', 'u', 'i', 'k', 'n', 'b')));
		nearbyCharsMap.put('k', new HashSet<>(Arrays.asList('k', 'i', 'j', 'o', 'l', 'm', 'n')));
		nearbyCharsMap.put('l', new HashSet<>(Arrays.asList('l', 'm', 'k', 'o', 'p')));
		nearbyCharsMap.put('m', new HashSet<>(Arrays.asList('m', 'n', 'j', 'k', 'l')));
		nearbyCharsMap.put('n', new HashSet<>(Arrays.asList('n', 'b', 'h', 'j', 'k', 'm')));
		nearbyCharsMap.put('o', new HashSet<>(Arrays.asList('o', 'i', 'k', 'l', 'p')));
		nearbyCharsMap.put('p', new HashSet<>(Arrays.asList('p', 'o', 'l')));
		nearbyCharsMap.put('q', new HashSet<>(Arrays.asList('q', 'a', 'w')));
		nearbyCharsMap.put('r', new HashSet<>(Arrays.asList('r', 'e', 'd', 'f', 't')));
		nearbyCharsMap.put('s', new HashSet<>(Arrays.asList('s', 'a', 'w', 'e', 'd', 'x', 'z')));
		nearbyCharsMap.put('t', new HashSet<>(Arrays.asList('t', 'r', 'f', 'g', 'y')));
		nearbyCharsMap.put('u', new HashSet<>(Arrays.asList('u', 'y', 'h', 'j', 'i')));
		nearbyCharsMap.put('v', new HashSet<>(Arrays.asList('v', 'c', 'f', 'g', 'h', 'b')));
		nearbyCharsMap.put('w', new HashSet<>(Arrays.asList('w', 'q', 'a', 's', 'e')));
		nearbyCharsMap.put('x', new HashSet<>(Arrays.asList('x', 'z', 's', 'd', 'f', 'c')));
		nearbyCharsMap.put('y', new HashSet<>(Arrays.asList('y', 't', 'g', 'h', 'u')));
		nearbyCharsMap.put('z', new HashSet<>(Arrays.asList('z', 'a', 's', 'd', 'x')));
	}

	/**
	 * Create all possible permutations of the original word by replacing them
	 * with a nearby character then filter out those permutations with only
	 * valid words.
	 */
	public Set<String> getNearbyWordsIteratively(String word) {
		word = normalizeWord(word);

		Set<String> nearbyWords = new HashSet<>();

		for (int i = 0; i < word.length(); i++) {
			char[] wordChars = word.toCharArray();
			char letter = wordChars[i];
			Set<Character> nearbyChars = getNearbyChars(letter);

			for (char nearbyChar : nearbyChars) {
				wordChars[i] = nearbyChar;
				String possibleWord = String.valueOf(wordChars);

				boolean isWord = isWord(possibleWord);

				if (isWord) {
					nearbyWords.add(possibleWord);
				}
			}
		}
		return nearbyWords;
	}

	/**
	 * This gets all permuations, not just words with only a single different
	 * letter.
	 * 
	 * @param word
	 * @return
	 */
	public Set<String> getNearbyWordsRecursively(String word) {
		if (StringUtils.isEmpty(word)) {
			return Collections.emptySet();
		}
		word = normalizeWord(word);

		Set<String> permutations = getNearbyPermutations(0, word);
		Set<String> nearbyWords = new HashSet<>();

		for (String permutation : permutations) {

			if (isWord(permutation)) {
				nearbyWords.add(permutation);
			}
		}
		return nearbyWords;
	}

	private Set<String> getNearbyPermutations(int index, String word) {
		if (index >= word.length()) {
			return new HashSet<>(Arrays.asList(""));
		}
		Set<String> subWords = getNearbyPermutations(index + 1, word);

		char letter = word.charAt(index);
		Set<Character> nearbyChars = getNearbyChars(letter);

		Set<String> permutations = new HashSet<>();

		for (String subWord : subWords) {

			for (char nearbyChar : nearbyChars) {
				String permutation = nearbyChar + subWord;
				permutations.add(permutation);
			}
		}
		return permutations;
	}

	private String normalizeWord(String word) {
		return word.toLowerCase();
	}

	private Set<Character> getNearbyChars(char letter) {
		Set<Character> nearbyChars = nearbyCharsMap.get(letter);
		return nearbyChars;
	}

	private boolean isWord(String word) {
		return dict.contains(word);
	}

	@Test
	public void testIterative() {
		String word = "hello";
		Set<String> nearbyWords = getNearbyWordsIteratively(word);
		System.out.println("Iterative: ");
		System.out.println(nearbyWords);
	}

	@Test
	public void testRecursive() {
		String word = "hello";
		Set<String> nearbyWords = getNearbyWordsRecursively(word);
		System.out.println("Recursive: ");
		System.out.println(nearbyWords);
	}

}
