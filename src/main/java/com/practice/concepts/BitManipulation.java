package com.practice.concepts;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BitManipulation {

	private static final Logger LOG = LoggerFactory.getLogger(BitManipulation.class);

	public void printBits(int x) {
		LOG.info("{}", Integer.toBinaryString(x));
	}

	@Test
	public void test() {
		// 17 --> 10001
		int count = Integer.bitCount(17);
		LOG.info("Count = {}", count);

		// Highest one bit is the first 1 (left to right)
		// So 17's (10001) highest bit is the 1 marking the 2^4 slot (i.e. 16)
		int highest = Integer.highestOneBit(17);
		// highest will be 16 here
		LOG.info("Highest = {}", highest);

		// Lowest one bit is the farthest right 1
		int lowest = Integer.lowestOneBit(17);
		// lowest will be 1 here since there is a 1 in the 2^0 slot of 10001
		LOG.info("Lowest = {}", lowest);

		// Number of Leading Zeros in a byte (32 bits)
		int numLeadingZeros = Integer.numberOfLeadingZeros(17);
		// numLeadingZeros will be 27 here
		LOG.info("Leading = {}", numLeadingZeros);

		// Reverse flips the bits of the int provided so 3 (11) would become:
		// 11000000000000000000000000000000 --> 1073741824
		int reverse = Integer.reverse(3);
		LOG.info("Reverse = {}", reverse);

		int reverseBytes = Integer.reverseBytes(3);
		LOG.info("Reverse Bytes = {}", reverseBytes);
	}

	/**
	 * A power of 2 number (X) would have a single 1 bit in the byte and since
	 * (X - 1) inverts all bits starting at the farthest right 1 bit and on then
	 * doing the & comparator to X and (X - 1) will result in zero
	 */
	public boolean isPowerOf2(int x) {
		return ((x > 0) && ((x & (x - 1)) == 0));
	}

	@Test
	public void testPowerOf2() {
		int x = 8;
		Assert.assertTrue(isPowerOf2(x));
		LOG.info("{} = {}", x, Integer.toBinaryString(x));
	}

	/**
	 * Count the number of 1 bits are in a byte
	 */
	public int countOneBits(int x) {
		String binaryStr = Integer.toBinaryString(x);
		int count = 0;

		for (int i = 0; i < binaryStr.length(); i++) {
			char letter = binaryStr.charAt(i);

			if (letter == '1') {
				count++;
			}
		}
		return count;
	}

	@Test
	public void testCountOneBits() {
		int x = 8;
		int expected = 1;
		int output = countOneBits(x);
		Assert.assertTrue(expected == output);

		x = 7;
		expected = 3;
		output = countOneBits(x);
		Assert.assertTrue(expected == output);
	}

}
