package com.practice.problems;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

public class Calculator {

	public enum Operator {

		MULTIPLY("*", 1),
		DIVIDE("/", 1),
		ADD("+", 2),
		SUBTRACT("-", 2);

		private int priority;
		private String symbol;

		private Operator(String symbol, int priority) {
			this.symbol = symbol;
			this.priority = priority;
		}

		public String getSymbol() {
			return symbol;
		}

		public int getPriority() {
			return priority;
		}

		public static Operator getOperatorForSymbol(String symbol) {
			if (!StringUtils.isBlank(symbol)) {

				for (Operator operator : Operator.values()) {

					if (StringUtils.equals(symbol, operator.getSymbol())) {
						return operator;
					}
				}
			}
			return null;
		}

	}

	/**
	 * Create a basic calculator that takes string expressions such as "5 * 3 +
	 * 8" and returns 23.0
	 */
	public double calculate(String exp) {
		String[] arr = exp.split("\\s");

		if ((arr.length % 2) == 0) {
			throw new IllegalArgumentException("Invalid mathmatical equation");
		}
		return calc(arr, Double.parseDouble(arr[0]), 1);
	}

	private double calc(String[] arr, double num, int index) {
		if (index > (arr.length - 2)) {
			return num;
		}
		Operator op = Operator.getOperatorForSymbol(arr[index]);

		if (op == null) {
			throw new IllegalArgumentException("Invalid mathmatical equation");
		}
		double next = Double.parseDouble(arr[index + 1]);

		if (op.getPriority() == 1) {

			switch (op) {
				case MULTIPLY:
					num *= next;
					break;
				case DIVIDE:
					num /= next;
					break;
				default:
					break;
			}
			return calc(arr, num, index + 2);
		}

		switch (op) {
			case ADD:
				return num + calc(arr, next, index + 2);
			case SUBTRACT:
				return num - calc(arr, next, index + 2);
			default:
				break;
		}
		return num;
	}

	@Test
	public void test() {
		String exp = "5 * 3 + 8";
		double output = calculate(exp);
		double expected = 23.0;
		Assert.assertTrue(expected == output);
	}

	@Test
	public void test1() {
		String exp = "8 + 5 * 3";
		double output = calculate(exp);
		double expected = 23.0;
		Assert.assertTrue(expected == output);
	}

	@Test
	public void test2() {
		String exp = "6 * 4 / 8";
		double output = calculate(exp);
		double expected = 3.0;
		Assert.assertTrue(expected == output);
	}

}
