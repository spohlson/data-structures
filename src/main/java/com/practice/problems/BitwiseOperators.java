package com.practice.problems;

import org.junit.Test;

public class BitwiseOperators {

	/**
	 * & --> AND
	 * | --> OR
	 * ~ --> NOT
	 * ^ --> XOR
	 * << --> left shift
	 * >> --> right shift
	 * >>> --> unsigned right shift
	 * &= --> AND assignment
	 * |= --> OR assignment
	 * ^= --> XOR assignment
	 * <<= --> left shift and assignment
	 * >>= --> right shift and assignment
	 * >>>= --> unsigned right shift and assignment
	 */

	/**
	 * NOTE: normally ints take up 4 bytes (32 bits) of space (i.e. 32 binary
	 * digits) but for this assignment assume an int only takes up 1 byte (8
	 * bits/binary digits)
	 */

	/**
	 * AND (&) Operator:
	 * 
	 * Compares each binary digit of two integers and returns a new integer,
	 * with a 1 wherever both numbers had a 1 and a 0 anywhere else.
	 * 
	 * 1 & 1 --> 1
	 * 0 & 1 --> 0
	 * 1 & 0 --> 0
	 * 0 & 0 --> 0
	 */

	/**
	 * OR (|) Operator:
	 * 
	 * Compares each binary digit across two integers and gives back a 1 if
	 * EITHER of them are 1.
	 * 
	 * 0 | 0 --> 0
	 * 0 | 1 --> 1
	 * 1 | 0 --> 1
	 * 1 | 1 --> 1
	 */

	public boolean isEven(int num) {
		boolean isEven = false;

		// if (0b00000011 & 0b00000001) {
		//
		// }

		return isEven;
	}

	@Test
	public void testAND() {

		// 60 = 0011 1100
		int a = 60;

		// 13 = 0000 1101
		int b = 13;

		int c = a & b;

		System.out.println(c);
	}

	@Test
	public void testOR() {
		int a = 12;
		int b = 25;
		int c = a | b;
		System.out.println(c);
	}

	@Test
	public void testNOT() {
		int num = 35;
		int result = ~num;
		// in decimal this will be 220 but compiler will use negative notation
		// --> -(num + 1)...-36

		System.out.println(result);
	}

}
