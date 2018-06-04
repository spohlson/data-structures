package com.practice.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TextJustification {

	/**
	 * Given an array of words and a width maxWidth, format the text such that
	 * each line has exactly maxWidth characters and is fully (left and right)
	 * justified.
	 * 
	 * You should pack your words in a greedy approach; that is, pack as many
	 * words as you can in each line. Pad extra spaces ' ' when necessary so
	 * that each line has exactly maxWidth characters.
	 * 
	 * Extra spaces between words should be distributed as evenly as possible.
	 * If the number of spaces on a line do not divide evenly between words, the
	 * empty slots on the left will be assigned more spaces than the slots on
	 * the right.
	 * 
	 * For the last line of text, it should be left justified and no extra space
	 * is inserted between words.
	 * 
	 * Note:
	 * 
	 * A word is defined as a character sequence consisting of non-space
	 * characters only. Each word's length is guaranteed to be greater than 0
	 * and not exceed maxWidth. The input array words contains at least one
	 * word.
	 * 
	 * Examples:
	 * 
	 * Input: words = ["This", "is", "an", "example", "of", "text",
	 * "justification."]
	 * maxWidth = 16
	 * Output:
	 * [
	 *  "This    is    an",
	 *  "example  of text",
	 *  "justification.  "
	 *  ]
	 * 
	 * Input: words = ["What","must","be","acknowledgment","shall","be"]
	 * maxWidth = 16
	 * Output:
	 * [
	 *  "What   must   be",
	 *  "acknowledgment  ",
	 *  "shall be        "
	 * ]
	 * 
	 * Explanation: Note that the last line is "shall be " instead of "shall
	 * be", because the last line must be left-justified instead of
	 * fully-justified. Note that the second line is also left-justified because
	 * it contains only one word.
	 */
	public List<String> textJustification(List<String> words, int maxWidth) {
		List<String> just = new ArrayList<>();

		int i = 0;
		int wordsLen = words.size();

		List<String> lineWords = new ArrayList<>();
		int numOfLineLetters = 0;

		while (i < wordsLen) {
			int lineWordsLen = lineWords.size();

			String word = words.get(i);
			int wordLen = word.length();

			if ((lineWordsLen == 0) && (wordLen == maxWidth)) {
				just.add(word);
				i++;
				continue;
			}
			int defaultSpaces = lineWordsLen;
			int lineLength = numOfLineLetters + wordLen + defaultSpaces;
			boolean lastLine = false;

			if (lineLength <= maxWidth) {
				lineWords.add(word);
				numOfLineLetters += wordLen;

				lastLine = (i + 1) == wordsLen;

				if (!lastLine && (lineLength < maxWidth)) {
					i++;
					continue;
				}
			}
			int numOfSpaces = maxWidth - numOfLineLetters;

			String line = getLine(lineWords, numOfSpaces, lastLine);
			just.add(line);

			lineWords = new ArrayList<>();
			numOfLineLetters = 0;

			if (lineLength <= maxWidth) {
				i++;
			}
		}
		return just;
	}

	private String getLine(List<String> words, int numOfSpaces, boolean lastLine) {
		int index = 0;
		int lastIndex = words.size() - 1;

		while (numOfSpaces > 0) {

			if ((index == lastIndex) && !lastLine) {
				index = 0;
				continue;
			}
			String word = words.get(index);
			word += " ";
			words.set(index, word);

			numOfSpaces--;

			if (!lastLine) {
				index++;
			}
		}
		String line = String.join("", words);
		return line;
	}

	@Test
	public void test() {
		List<String> words = new ArrayList<>(
				Arrays.asList("This", "is", "an", "example", "of", "text", "justification."));
		int maxWidth = 16;
		List<String> expected = new ArrayList<>(
				Arrays.asList("This    is    an", "example  of text", "justification.  "));
		List<String> output = textJustification(words, maxWidth);
		System.out.println(expected);
		System.out.println(output);
		Assert.assertTrue(expected.equals(output));

		words = new ArrayList<>(
				Arrays.asList("What", "must", "be", "acknowledgment", "shall", "be"));
		maxWidth = 16;
		expected = new ArrayList<>(
				Arrays.asList("What   must   be", "acknowledgment  ", "shall be        "));
		output = textJustification(words, maxWidth);
		Assert.assertTrue(expected.equals(output));
	}

	@Test
	public void test1() {
		List<String> words = new ArrayList<>(
				Arrays.asList("What", "must", "be", "acknowledgment", "shall", "be"));
		int maxWidth = 16;
		List<String> expected = new ArrayList<>(
				Arrays.asList("What   must   be", "acknowledgment  ", "shall be        "));
		List<String> output = textJustification(words, maxWidth);
		System.out.println(expected);
		System.out.println(output);
		Assert.assertTrue(expected.equals(output));
	}

}
