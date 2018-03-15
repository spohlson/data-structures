package com.practice.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class BalancedBrackets {

	/**
	 * A bracket is considered to be one of the following: (, ), {, }, [, ]
	 * 
	 * Two brackets are considered to be a matched pair if the opening bracket
	 * occurs to the left of the closing bracket of the same type. A matching
	 * pair of brackets is not balanced if the set of brackets it encloses are
	 * not matched such as "{[(])}" because the contents between { and } are not
	 * balanced.
	 * 
	 * Brackets are balanced if:
	 * 
	 * 1. it contains no unmatched brackets
	 * 
	 * 2. The subset of brackets enclosed within the confines of a matched pair
	 * of brackets is also a matched pair of brackets
	 * 
	 * Given n strings of brackets, determine whether each sequence of brackets
	 * is balanced. If a string is balanced, print YES on a new line; otherwise
	 * print NO.
	 */

	public boolean isBalanced(String expression) {
		Set<String> openers = new HashSet<>(Arrays.asList("{", "(", "["));

		Map<String, String> bracketsMap = new HashMap<>();
		bracketsMap.put("}", "{");
		bracketsMap.put(")", "(");
		bracketsMap.put("]", "[");

		Stack<String> stack = new Stack<>();

		for (int i = 0; i < expression.length(); i++) {
			String bracket = String.valueOf(expression.charAt(i));

			if (openers.contains(bracket)) {
				stack.push(bracket);
			} else if (bracketsMap.containsKey(bracket)) {

				if (stack.isEmpty()) {
					return false;
				}
				String expected = bracketsMap.get(bracket);
				String opener = stack.pop();

				if (!expected.equals(opener)) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

	@Test
	public void test1() {
		String expression = "{[()]}";
		boolean isBalanced = isBalanced(expression);
		Assert.assertTrue(isBalanced);
	}

	@Test
	public void test2() {
		String expression = "{[(])}";
		boolean isBalanced = isBalanced(expression);
		Assert.assertFalse(isBalanced);
	}

	@Test
	public void test3() {
		String expression = "{{[[(())]]}}";
		boolean isBalanced = isBalanced(expression);
		Assert.assertTrue(isBalanced);
	}

	@Test
	public void test4() {
		String expression = "{()[][{}]}";
		boolean isBalanced = isBalanced(expression);
		Assert.assertTrue(isBalanced);
	}

	@Test
	public void test5() {
		String expression = "({}{[]})({)}";
		boolean isBalanced = isBalanced(expression);
		Assert.assertFalse(isBalanced);
	}

	@Test
	public void test6() {
		String expression = "()[]";
		boolean isBalanced = isBalanced(expression);
		Assert.assertTrue(isBalanced);
	}

	@Test
	public void test7() {
		String expression = "[()][{}]{[({})[]]}";
		boolean isBalanced = isBalanced(expression);
		Assert.assertTrue(isBalanced);
	}

	@Test
	public void test8() {
		String expression = "((){)}";
		boolean isBalanced = isBalanced(expression);
		Assert.assertFalse(isBalanced);
	}

}
