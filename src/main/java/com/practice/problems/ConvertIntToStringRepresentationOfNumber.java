package com.practice.problems;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConvertIntToStringRepresentationOfNumber {

	/**
	 * Convert int to String representation:
	 * 
	 * 1 --> "one"
	 * 55 --> "fifty five"
	 * 895 --> "eight hundred ninety five"
	 * 1783 --> "one thousand seven hundred eighty three"
	 */

	private String[] smallNums;
	private String[] tensNums;
	private String[] increasingSequence;

	@Before
	public void init() {
		initSmallNums();
		initTensNums();
		initIncreasingSequence();
	}

	private void initSmallNums() {
		smallNums = new String[20];
		smallNums[0] = "";
		smallNums[1] = "one";
		smallNums[2] = "two";
		smallNums[3] = "three";
		smallNums[4] = "four";
		smallNums[5] = "five";
		smallNums[6] = "six";
		smallNums[7] = "seven";
		smallNums[8] = "eight";
		smallNums[9] = "nine";
		smallNums[10] = "ten";
		smallNums[11] = "eleven";
		smallNums[12] = "twelve";
		smallNums[13] = "thirteen";
		smallNums[14] = "fourteen";
		smallNums[15] = "fifteen";
		smallNums[16] = "sixteen";
		smallNums[17] = "seventeen";
		smallNums[18] = "eighteen";
		smallNums[19] = "nineteen";
	}

	private void initTensNums() {
		tensNums = new String[10];
		tensNums[0] = "";
		tensNums[1] = "ten";
		tensNums[2] = "twenty";
		tensNums[3] = "thirty";
		tensNums[4] = "forty";
		tensNums[5] = "fifty";
		tensNums[6] = "sixty";
		tensNums[7] = "seventy";
		tensNums[8] = "eighty";
		tensNums[9] = "ninety";
	}

	private void initIncreasingSequence() {
		increasingSequence = new String[] { "", " thousand", " million", " billion" };
	}

	public String convertNum(int num) {
		if (num == 0) {
			return "zero";
		}
		String stringNum = "";

		for (String sequence : increasingSequence) {

			if (num == 0) {
				break;
			}
			int threeDigits = num % 1000;
			String stringDigits = getThreeDigitString(threeDigits, sequence);

			if (StringUtils.isBlank(stringNum)) {
				stringNum = stringDigits;
			} else {
				stringNum = stringDigits + " " + stringNum;
			}
			num /= 1000;
		}

		return stringNum;
	}

	private String getThreeDigitString(int num, String sequence) {
		StringBuilder b = new StringBuilder();
		String firstStr = null;

		if (num > 99) {
			int firstDigit = num / 100;
			firstStr = smallNums[firstDigit];
			b.append(firstStr);
			b.append(" hundred");
		}
		int mod = num % 100;
		String remainingDigits = "";

		if (mod > 0) {

			if (!StringUtils.isBlank(firstStr)) {
				remainingDigits = " ";
			}

			if (mod < 20) {
				remainingDigits += smallNums[mod];
			} else {
				int secondDigit = mod / 10;
				remainingDigits += tensNums[secondDigit];
				int thirdDigit = mod % 10;

				if (thirdDigit > 0) {
					remainingDigits += (" " + smallNums[thirdDigit]);
				}
			}
		}
		b.append(remainingDigits);
		b.append(sequence);
		return b.toString();
	}

	public void confirmTest(int num, String expected) {
		String output = convertNum(num);
		System.out.println("Num: " + num + " Output: " + output);
		Assert.assertTrue(expected.equals(output));
	}

	@Test
	public void test() {
		confirmTest(1, "one");
		confirmTest(55, "fifty five");
		confirmTest(895, "eight hundred ninety five");
		confirmTest(1783, "one thousand seven hundred eighty three");
		confirmTest(400000, "four hundred thousand");
		confirmTest(13750412, "thirteen million seven hundred fifty thousand four hundred twelve");
	}

	@Test
	public void test1() {
		System.out.println(13750412 % 1000);
		System.out.println(13750412 / 1000);
	}

	@Test
	public void test2() {
		int num = 412;
		String output = getThreeDigitString(num, increasingSequence[0]);
		System.out.println(output);
	}

}
