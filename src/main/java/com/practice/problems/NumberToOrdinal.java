package com.practice.problems;

import org.junit.Assert;
import org.junit.Test;

public class NumberToOrdinal {

	/**
	 * Finish the function numberToOrdinal, which should take a number and
	 * return it as a string with the correct ordinal indicator suffix (in
	 * English). That is:
	 * 
	 * numberToOrdinal(1) ==> '1st'
	 * numberToOrdinal(2) ==> '2nd'
	 * numberToOrdinal(3) ==> '3rd'
	 * numberToOrdinal(4) ==> '4th'
	 */
	public String getOrdinal(int num) {

		return null;
	}

	public void confirmTest(int num, String expected) {
		String output = getOrdinal(num);
		Assert.assertTrue(expected.equals(output));
	}

	@Test
	public void test() {
		confirmTest(1, "1st");
		confirmTest(2, "2nd");
		confirmTest(3, "3rd");
		confirmTest(4, "4th");
		confirmTest(77, "77th");
	}

}
