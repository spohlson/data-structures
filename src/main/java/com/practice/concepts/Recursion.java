package com.practice.concepts;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class Recursion {

	/**
	 * 1. Break the problem into a problem that is ONE step simpler.
	 * 
	 * 2. Assume that the function will work to solve the simpler problem.
	 * 
	 * 3. Ask: Since I know I can solve the simpler problem, how would I solve
	 * the more complex problem?
	 */

	/**
	 * Reverse a string.
	 * 
	 * 1. One step simpler would be reversing a string that is one letter
	 * shorter.
	 * 
	 * 2. Assume that my function can correctly reverse a string that is one
	 * letter shorter than the one I am currently trying to reverse.
	 * 
	 * 3. Ask: Since I know and believe that my function can correctly reverse a
	 * string that is one letter shorter than the one I am currently trying to
	 * reverse, how can I reverse the whole string? - I can take all the
	 * characters except the first one, reverse those and then tack the first
	 * character on to the end.
	 */
	public String reverse(String str) {
		// base case
		if (str.length() < 2) {
			return str;
		}
		String letter = String.valueOf(str.charAt(0));

		return reverse(str.substring(1)) + letter;
	}

	@Test
	public void testReverseString() {
		String str = "standard";
		String expected = "dradnats";
		String output = reverse(str);
		Assert.assertTrue(expected.equals(output));
	}

	/**
	 * Go through an array and print out all the elements.
	 * 
	 * 1. One step simpler: printing array that is one element smaller
	 * 
	 * 3. I can take all elements except the last one and print them then print
	 * the last one.
	 */
	public void printElementsInArray(String[] arr) {
		int len = arr.length;

		if (len == 0) {
			return;
		}
		System.out.print(arr[0]);
		printElementsInArray(Arrays.copyOfRange(arr, 1, len));
	}

	@Test
	public void testPrintElementsInArray() {
		String[] arr = new String[] { "h", "e", "l", "l", "o" };
		printElementsInArray(arr);
	}

	/**
	 * Determine whether or not a string is a palindrome: radar, abcba
	 * 
	 * 1. One step simpler: String had one less letter to check
	 * 
	 * Function should check if beginning letter matches end letter
	 * 
	 * 3. I can take all letters except the first one and check if they have a
	 * matching letter
	 */
	public boolean isPalindrome(String str) {
		int len = str.length();

		if (len == 1) {
			return true;
		} else if ((len == 2) || (str.charAt(0) != str.charAt(len - 1))) {
			return false;
		}

		return isPalindrome(str.substring(1, len - 1));
	}

	public boolean isPalindrome(String str, int start, int end) {
		if (start > end) {
			return true;
		}

		if (str.charAt(start) != str.charAt(end)) {
			return false;
		}
		return isPalindrome(str, start + 1, end - 1);
	}

	@Test
	public void testIsPalindromeTrue() {
		String str = "radar";
		boolean output = isPalindrome(str);
		Assert.assertTrue(output);

		output = isPalindrome(str, 0, str.length() - 1);
		Assert.assertTrue(output);
	}

	@Test
	public void testIsPalindromeFalse() {
		String str = "hello";
		boolean output = isPalindrome(str);
		Assert.assertFalse(output);

		output = isPalindrome(str, 0, str.length() - 1);
		Assert.assertFalse(output);
	}

	@Test
	public void testIsPalindromeFalse1() {
		String str = "raddar";
		boolean output = isPalindrome(str);
		Assert.assertFalse(output);

		output = isPalindrome(str, 0, str.length() - 1);
		Assert.assertTrue(output);
	}

	/**
	 * Calculate num a raised to the power of num b
	 * 
	 * 1. One step simpler: calculating a to the power of b - 1
	 * 
	 * 3.
	 */
	public int calculatePowerOf(int a, int b) {
		if (b == 0) {
			return 1;
		} else if (b == 1) {
			return a;
		}

		return calculatePowerOf(a, b - 1) * a;
	}

	@Test
	public void testCalculatePowerOf() {
		int a = 2;
		int b = 4;
		int expected = 16;
		int output = calculatePowerOf(a, b);
		Assert.assertTrue(expected == output);
	}

	@Test
	public void testCalculatePowerOf1() {
		int a = 9;
		int b = 6;
		int expected = 531441;
		int output = calculatePowerOf(a, b);
		Assert.assertTrue(expected == output);
	}

	/**
	 * Given a string, compute recursively a new string where all the lowercase
	 * 'x' chars have been moved to the end of the string.
	 * 
	 * endX("xxre") → "rexx"
	 * endX("xxhixx") → "hixxxx"
	 * endX("xhixhix") → "hihixxx"
	 */
	public String endX(String str) {
		if (str.length() < 1) {
			return "";
		}
		char letter = str.charAt(0);
		String sub = endX(str.substring(1));
		return (letter == 'x') ? sub + letter : letter + sub;
	}

	@Test
	public void testEndX() {
		String str = "xxre";
		String expected = "rexx";
		Assert.assertTrue(expected.equals(endX(str)));

		str = "xxhixx";
		expected = "hixxxx";
		Assert.assertTrue(expected.equals(endX(str)));

		str = "xhixhix";
		expected = "hihixxx";
		Assert.assertTrue(expected.equals(endX(str)));
	}

	/**
	 * Given a string that contains a single pair of parenthesis, compute
	 * recursively a new string made of only of the parenthesis and their
	 * contents, so "xyz(abc)123" yields "(abc)".
	 * 
	 * parenBit("xyz(abc)123") → "(abc)"
	 * parenBit("x(hello)") → "(hello)"
	 * parenBit("(xy)1") → "(xy)"
	 */
	public String parenBit(String str) {
		if (str.length() < 2) {
			return "";
		}

		if (str.charAt(0) == '(') {
			int i = 1;
			boolean foundClosing = false;

			while (!foundClosing && (i < str.length())) {
				char letter = str.charAt(i);

				if (letter == ')') {
					foundClosing = true;
				}
				i++;
			}
			return str.substring(0, i);
		}
		return parenBit(str.substring(1));
	}

	public String parenBit1(String str) {
		if (str.charAt(0) != '(') {
			return parenBit(str.substring(1));
		}
		if (str.charAt(str.length() - 1) != ')') {
			return parenBit(str.substring(0, str.length() - 1));
		}
		return str;
	}

	@Test
	public void testParenBit() {
		String str = "xyz(abc)123";
		String expected = "(abc)";
		String output = parenBit(str);
		Assert.assertTrue(expected.equals(output));

		str = "x(hello)";
		expected = "(hello)";
		Assert.assertTrue(expected.equals(parenBit(str)));

		str = "(xy)1";
		expected = "(xy)";
		Assert.assertTrue(expected.equals(parenBit(str)));

		str = "()";
		expected = "()";
		Assert.assertTrue(expected.equals(parenBit(str)));
	}

	/**
	 * Given a string, return true if it is a nesting of zero or more pairs of
	 * parenthesis, like "(())" or "((()))". Suggestion: check the first and
	 * last chars, and then recur on what's inside them.
	 * 
	 * nestParen("(())") → true
	 * nestParen("((()))") → true
	 * nestParen("(((x))") → false
	 */
	public boolean nestParen(String str) {
		int len = str.length();

		if (len == 0) {
			return true;
		} else if ((len < 2) || (str.charAt(0) != '(') || (str.charAt(len - 1) != ')')) {
			return false;
		} else if (len == 2) {
			return true;
		}
		return nestParen(str.substring(1, len - 1));
	}

	@Test
	public void testNestParen() {
		String str = "(())";
		boolean expected = true;
		Assert.assertTrue(expected == nestParen(str));

		str = "((()))";
		expected = true;
		Assert.assertTrue(expected == nestParen(str));

		str = "(((x))";
		expected = false;
		Assert.assertTrue(expected == nestParen(str));

		str = "(((()";
		expected = false;
		Assert.assertTrue(expected == nestParen(str));

		str = "";
		expected = true;
		Assert.assertTrue(expected == nestParen(str));
	}

	/**
	 * Given a string, compute recursively the number of times lowercase "hi"
	 * appears in the string, however do not count "hi" that have an 'x'
	 * immediately before them.
	 * 
	 * countHi2("ahixhi") → 1
	 * countHi2("ahibhi") → 2
	 * countHi2("xhixhi") → 0
	 */
	public int countHi2(String str) {
		if (str.length() < 2) {
			return 0;
		}
		int count = (str.startsWith("hi")) ? 1 : 0;
		int i = 1;

		if (str.startsWith("xhi")) {

			if (str.length() == 3) {
				return 0;
			}
			i = 3;
		}
		return count + countHi2(str.substring(i));
	}

	@Test
	public void testCountHi2() {
		String str = "ahixhi";
		int expected = 1;
		Assert.assertTrue(expected == countHi2(str));

		str = "ahibhi";
		expected = 2;
		Assert.assertTrue(expected == countHi2(str));

		str = "xhixhi";
		expected = 0;
		Assert.assertTrue(expected == countHi2(str));
	}

	/**
	 * Given a string, return recursively a "cleaned" string where adjacent
	 * chars that are the same have been reduced to a single char. So "yyzzza"
	 * yields "yza".
	 * 
	 * stringClean("yyzzza") → "yza"
	 * stringClean("abbbcdd") → "abcd"
	 * stringClean("Hello") → "Helo"
	 */
	public String stringClean(String str) {
		if (str.length() < 1) {
			return "";
		}
		char letter = str.charAt(0);
		String regex = String.valueOf(letter) + "+";
		return letter + stringClean(str.replaceFirst(regex, ""));
	}

	@Test
	public void testStringClean() {
		String str = "yyzzza";
		String expected = "yza";
		Assert.assertTrue(expected.equals(stringClean(str)));

		str = "abbbcdd";
		expected = "abcd";
		Assert.assertTrue(expected.equals(stringClean(str)));

		str = "Hello";
		expected = "Helo";
		Assert.assertTrue(expected.equals(stringClean(str)));
	}

	/**
	 * 
	 * We'll say that a "pair" in a string is two instances of a char separated
	 * by a char. So "AxA" the A's make a pair. Pair's can overlap, so "AxAxA"
	 * contains 3 pairs -- 2 for A and 1 for x. Recursively compute the number
	 * of pairs in the given string.
	 * 
	 * countPairs("axa") → 1
	 * countPairs("axax") → 2
	 * countPairs("axbx") → 1
	 */
	public int countPairs(String str) {
		if (str.length() < 3) {
			return 0;
		}
		int count = (str.charAt(0) == str.charAt(2)) ? 1 : 0;
		return count + countPairs(str.substring(1));
	}

	@Test
	public void testCountPairs() {
		String str = "axa";
		int expected = 1;
		Assert.assertTrue(expected == countPairs(str));

		str = "axax";
		expected = 2;
		Assert.assertTrue(expected == countPairs(str));

		str = "axbx";
		expected = 1;
		Assert.assertTrue(expected == countPairs(str));
	}

	/**
	 * Given n of 1 or more, return the factorial of n, which is n * (n-1) *
	 * (n-2) ... 1. Compute the result recursively (without loops).
	 * 
	 * factorial(1) → 1
	 * factorial(2) → 2
	 * factorial(3) → 6
	 */
	public int factorial(int n) {
		if (n < 1) {
			return 1;
		}

		return n * factorial(n - 1);
	}

	@Test
	public void testFactorial() {
		int n = 1;
		int expected = 1;
		Assert.assertTrue(expected == factorial(n));

		n = 2;
		expected = 2;
		Assert.assertTrue(expected == factorial(n));

		n = 3;
		expected = 6;
		Assert.assertTrue(expected == factorial(n));
	}

	/**
	 * We have a number of bunnies and each bunny has two big floppy ears. We
	 * want to compute the total number of ears across all the bunnies
	 * recursively (without loops or multiplication).
	 * 
	 * bunnyEars(0) → 0
	 * bunnyEars(1) → 2
	 * bunnyEars(2) → 4
	 */
	public int bunnyEars(int bunnies) {
		if (bunnies < 1) {
			return 0;
		}
		return 2 + bunnyEars(bunnies - 1);
	}

	@Test
	public void testBunnyEars() {
		int n = 0;
		int expected = 0;
		Assert.assertTrue(expected == bunnyEars(n));

		n = 1;
		expected = 2;
		Assert.assertTrue(expected == bunnyEars(n));

		n = 2;
		expected = 4;
		Assert.assertTrue(expected == bunnyEars(n));
	}

	/**
	 * We have bunnies standing in a line, numbered 1, 2, ... The odd bunnies
	 * (1, 3, ..) have the normal 2 ears. The even bunnies (2, 4, ..) we'll say
	 * have 3 ears, because they each have a raised foot. Recursively return the
	 * number of "ears" in the bunny line 1, 2, ... n (without loops or
	 * multiplication).
	 * 
	 * bunnyEars2(0) → 0
	 * bunnyEars2(1) → 2
	 * bunnyEars2(2) → 5
	 */
	public int bunnyEars2(int bunnies) {
		if (bunnies < 1) {
			return 0;
		}
		int ears = ((bunnies % 2) == 0) ? 3 : 2;
		return ears + bunnyEars2(bunnies - 1);
	}

	@Test
	public void testBunnyEars2() {
		int n = 0;
		int expected = 0;
		Assert.assertTrue(expected == bunnyEars2(n));

		n = 1;
		expected = 2;
		Assert.assertTrue(expected == bunnyEars2(n));

		n = 2;
		expected = 5;
		Assert.assertTrue(expected == bunnyEars2(n));
	}

	/**
	 * The fibonacci sequence is a famous bit of mathematics, and it happens to
	 * have a recursive definition. The first two values in the sequence are 0
	 * and 1 (essentially 2 base cases). Each subsequent value is the sum of the
	 * previous two values, so the whole sequence is: 0, 1, 1, 2, 3, 5, 8, 13,
	 * 21 and so on. Define a recursive fibonacci(n) method that returns the nth
	 * fibonacci number, with n=0 representing the start of the sequence.
	 * 
	 * 
	 * fibonacci(0) → 0
	 * fibonacci(1) → 1
	 * fibonacci(2) → 1
	 */
	public int fibonacci(int n) {
		if ((n == 0) || (n == 1)) {
			return n;
		}
		return fibonacci(n - 2) + fibonacci(n - 1);
	}

	@Test
	public void testFibonacci() {
		int n = 0;
		int expected = 0;
		Assert.assertTrue(expected == fibonacci(n));

		n = 1;
		expected = 1;
		Assert.assertTrue(expected == fibonacci(n));

		n = 2;
		expected = 1;
		Assert.assertTrue(expected == fibonacci(n));
	}

	/**
	 * We have triangle made of blocks. The topmost row has 1 block, the next
	 * row down has 2 blocks, the next row has 3 blocks, and so on. Compute
	 * recursively (no loops or multiplication) the total number of blocks in
	 * such a triangle with the given number of rows.
	 * 
	 * triangle(0) → 0
	 * triangle(1) → 1
	 * triangle(2) → 3
	 */
	public int triangle(int rows) {
		if (rows < 1) {
			return 0;
		}
		return rows + triangle(rows - 1);
	}

	@Test
	public void testTriangle() {
		int n = 0;
		int expected = 0;
		Assert.assertTrue(expected == triangle(n));

		n = 1;
		expected = 1;
		Assert.assertTrue(expected == triangle(n));

		n = 2;
		expected = 3;
		Assert.assertTrue(expected == triangle(n));
	}

	/**
	 * Given a non-negative int n, return the sum of its digits recursively (no
	 * loops). Note that mod (%) by 10 yields the rightmost digit (126 % 10 is
	 * 6), while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).
	 * 
	 * sumDigits(126) → 9
	 * sumDigits(49) → 13
	 * sumDigits(12) → 3
	 */
	public int sumDigits(int n) {
		if (n < 10) {
			return n;
		}
		int digit = n % 10;
		return digit + sumDigits(n / 10);
	}

	@Test
	public void testSumDigits() {
		int n = 126;
		int expected = 9;
		Assert.assertTrue(expected == sumDigits(n));

		n = 49;
		expected = 13;
		Assert.assertTrue(expected == sumDigits(n));

		n = 12;
		expected = 3;
		Assert.assertTrue(expected == sumDigits(n));
	}

	/**
	 * Given a non-negative int n, return the count of the occurrences of 7 as a
	 * digit, so for example 717 yields 2. (no loops). Note that mod (%) by 10
	 * yields the rightmost digit (126 % 10 is 6), while divide (/) by 10
	 * removes the rightmost digit (126 / 10 is 12).
	 * 
	 * count7(717) → 2
	 * count7(7) → 1
	 * count7(123) → 0
	 */
	public int count7(int n) {
		if (n < 1) {
			return 0;
		}
		int digit = n % 10;
		int count = (digit == 7) ? 1 : 0;
		return count + count7(n / 10);
	}

	@Test
	public void testCount7() {
		int n = 717;
		int expected = 2;
		Assert.assertTrue(expected == count7(n));

		n = 7;
		expected = 1;
		Assert.assertTrue(expected == count7(n));

		n = 123;
		expected = 0;
		Assert.assertTrue(expected == count7(n));
	}

	/**
	 * 
	 * Given a non-negative int n, compute recursively (no loops) the count of
	 * the occurrences of 8 as a digit, except that an 8 with another 8
	 * immediately to its left counts double, so 8818 yields 4. Note that mod
	 * (%) by 10 yields the rightmost digit (126 % 10 is 6), while divide (/) by
	 * 10 removes the rightmost digit (126 / 10 is 12).
	 * 
	 * count8(8) → 1
	 * count8(818) → 2
	 * count8(8818) → 4
	 */
	public int count8(int n) {
		if (n < 1) {
			return 0;
		}
		int digit = n % 10;
		int count = 0;

		if (digit == 8) {
			count = (((n / 10) % 10) == 8) ? 2 : 1;
		}
		return count + count8(n / 10);
	}

	@Test
	public void testCount8() {
		int n = 8;
		int expected = 1;
		Assert.assertTrue(expected == count8(n));

		n = 818;
		expected = 2;
		Assert.assertTrue(expected == count8(n));

		n = 8818;
		expected = 4;
		Assert.assertTrue(expected == count8(n));

		n = 88888;
		expected = 9;
		Assert.assertTrue(expected == count8(n));
	}

	/**
	 * Given base and n that are both 1 or more, compute recursively (no loops)
	 * the value of base to the n power, so powerN(3, 2) is 9 (3 squared).
	 * 
	 * powerN(3, 1) → 3
	 * powerN(3, 2) → 9
	 * powerN(3, 3) → 27
	 */
	public int powerN(int base, int n) {
		if ((base < 1) || (n < 1)) {
			return 0;
		} else if ((base == 1) || (n == 1)) {
			return base;
		}
		return base * powerN(base, n - 1);
	}

	@Test
	public void testPowerN() {
		int base = 3;
		int n = 1;
		int expected = 3;
		Assert.assertTrue(expected == powerN(base, n));

		base = 3;
		n = 2;
		expected = 9;
		Assert.assertTrue(expected == powerN(base, n));

		base = 3;
		n = 3;
		expected = 27;
		Assert.assertTrue(expected == powerN(base, n));
	}

	/**
	 * Given a string, compute recursively (no loops) the number of lowercase
	 * 'x' chars in the string.
	 * 
	 * countX("xxhixx") → 4
	 * countX("xhixhix") → 3
	 * countX("hi") → 0
	 */
	public int countX(String str) {
		int len = str.length();

		if (len < 1) {
			return 0;
		}
		char letter = str.charAt(0);
		int count = (letter == 'x') ? 1 : 0;

		if (len == 1) {
			return count;
		}
		return count + countX(str.substring(1, len));
	}

	@Test
	public void test() {
		String str = "xxhixx";
		int expected = 4;
		Assert.assertTrue(expected == countX(str));

		str = "xhixhix";
		expected = 3;
		Assert.assertTrue(expected == countX(str));

		str = "hi";
		expected = 0;
		Assert.assertTrue(expected == countX(str));
	}

	/**
	 * Given a string, compute recursively (no loops) the number of times
	 * lowercase "hi" appears in the string.
	 * 
	 * countHi("xxhixx") → 1
	 * countHi("xhixhix") → 2
	 * countHi("hi") → 1
	 */
	public int countHi(String str) {
		if (str.length() < 2) {
			return 0;
		}
		int count = (str.startsWith("hi")) ? 1 : 0;
		return count + countHi(str.substring(1));
	}

	@Test
	public void testCountHi() {
		String str = "xxhixx";
		int expected = 1;
		Assert.assertTrue(expected == countHi(str));

		str = "xhixhix";
		expected = 2;
		Assert.assertTrue(expected == countHi(str));

		str = "hi";
		expected = 1;
		Assert.assertTrue(expected == countHi(str));
	}

	/**
	 * Given a string, compute recursively (no loops) a new string where all the
	 * lowercase 'x' chars have been changed to 'y' chars.
	 * 
	 * changeXY("codex") → "codey"
	 * changeXY("xxhixx") → "yyhiyy"
	 * changeXY("xhixhix") → "yhiyhiy"
	 */
	public String changeXY(String str) {
		if (str.length() < 1) {
			return "";
		}
		char letter = str.charAt(0);

		if (letter == 'x') {
			letter = 'y';
		}
		return letter + changeXY(str.substring(1));
	}

	@Test
	public void testChangeXY() {
		String str = "codex";
		String expected = "codey";
		Assert.assertTrue(expected.equals(changeXY(str)));

		str = "xxhixx";
		expected = "yyhiyy";
		Assert.assertTrue(expected.equals(changeXY(str)));

		str = "xhixhix";
		expected = "yhiyhiy";
		Assert.assertTrue(expected.equals(changeXY(str)));
	}

	/**
	 * Given a string, compute recursively (no loops) a new string where all
	 * appearances of "pi" have been replaced by "3.14".
	 * 
	 * changePi("xpix") → "x3.14x"
	 * changePi("pipi") → "3.143.14"
	 * changePi("pip") → "3.14p"
	 */
	public String changePi(String str) {
		if (str.length() < 1) {
			return "";
		}
		int startIndex = 1;
		String str1;

		if (str.startsWith("pi")) {
			str1 = "3.14";
			startIndex++;
		} else {
			str1 = String.valueOf(str.charAt(0));
		}

		return str1 + changePi(str.substring(startIndex, str.length()));
	}

	@Test
	public void testChangePi() {
		String str = "xpix";
		String expected = "x3.14x";
		Assert.assertTrue(expected.equals(changePi(str)));

		str = "pipi";
		expected = "3.143.14";
		Assert.assertTrue(expected.equals(changePi(str)));

		str = "pip";
		expected = "3.14p";
		Assert.assertTrue(expected.equals(changePi(str)));
	}

	/**
	 * Given a string, compute recursively a new string where all the 'x' chars
	 * have been removed.
	 * 
	 * noX("xaxb") → "ab"
	 * noX("abc") → "abc"
	 * noX("xx") → ""
	 */
	public String noX(String str) {
		if (str.length() < 1) {
			return "";
		}
		char letter = str.charAt(0);
		String str1 = (letter == 'x') ? "" : String.valueOf(letter);
		return str1 + noX(str.substring(1));
	}

	@Test
	public void testNoX() {
		String str = "xaxb";
		String expected = "ab";
		Assert.assertTrue(expected.equals(noX(str)));

		str = "abc";
		expected = "abc";
		Assert.assertTrue(expected.equals(noX(str)));

		str = "xx";
		expected = "";
		Assert.assertTrue(expected.equals(noX(str)));
	}

	/**
	 * Given an array of ints, compute recursively if the array contains a 6.
	 * We'll use the convention of considering only the part of the array that
	 * begins at the given index. In this way, a recursive call can pass index+1
	 * to move down the array. The initial call will pass in index as 0.
	 * 
	 * array6([1, 6, 4], 0) → true
	 * array6([1, 4], 0) → false
	 * array6([6], 0) → true
	 */
	public boolean array6(int[] nums, int index) {
		if (index == nums.length) {
			return false;
		}
		int num = nums[index];

		if (num == 6) {
			return true;
		}
		return array6(nums, index + 1);
	}

	@Test
	public void testArray6() {
		int[] arr = new int[] { 1, 6, 4 };
		boolean expected = true;
		Assert.assertTrue(expected == array6(arr, 0));

		arr = new int[] { 1, 4 };
		expected = false;
		Assert.assertTrue(expected == array6(arr, 0));

		arr = new int[] { 6 };
		expected = true;
		Assert.assertTrue(expected == array6(arr, 0));
	}

	/**
	 * Given an array of ints, compute recursively the number of times that the
	 * value 11 appears in the array. We'll use the convention of considering
	 * only the part of the array that begins at the given index. In this way, a
	 * recursive call can pass index+1 to move down the array. The initial call
	 * will pass in index as 0.
	 * 
	 * array11([1, 2, 11], 0) → 1
	 * array11([11, 11], 0) → 2
	 * array11([1, 2, 3, 4], 0) → 0
	 */
	public int array11(int[] nums, int index) {
		if (index == nums.length) {
			return 0;
		}
		int num = nums[index];
		int count = 0;

		if (num == 11) {
			count++;
		}
		return count + array11(nums, index + 1);
	}

	@Test
	public void testArray11() {
		int[] arr = new int[] { 1, 2, 11 };
		int expected = 1;
		Assert.assertTrue(expected == array11(arr, 0));

		arr = new int[] { 11, 11 };
		expected = 2;
		Assert.assertTrue(expected == array11(arr, 0));

		arr = new int[] { 1, 2, 3, 4 };
		expected = 0;
		Assert.assertTrue(expected == array11(arr, 0));
	}

	/**
	 * Given an array of ints, compute recursively if the array contains
	 * somewhere a value followed in the array by that value times 10. We'll use
	 * the convention of considering only the part of the array that begins at
	 * the given index. In this way, a recursive call can pass index+1 to move
	 * down the array. The initial call will pass in index as 0.
	 * 
	 * array220([1, 2, 20], 0) → true
	 * array220([3, 30], 0) → true
	 * array220([3], 0) → false
	 */
	public boolean array220(int[] nums, int index) {
		if ((nums.length == 0) || (index == (nums.length - 1))) {
			return false;
		}

		if ((nums[index] * 10) == nums[index + 1]) {
			return true;
		}
		return array220(nums, index + 1);
	}

	@Test
	public void testArray220() {
		int[] arr = new int[] { 1, 2, 20 };
		boolean expected = true;
		Assert.assertTrue(expected == array220(arr, 0));

		arr = new int[] { 3, 30 };
		expected = true;
		Assert.assertTrue(expected == array220(arr, 0));

		arr = new int[] { 3 };
		expected = false;
		Assert.assertTrue(expected == array220(arr, 0));

		arr = new int[] { 3, 15, 67 };
		expected = false;
		Assert.assertTrue(expected == array220(arr, 0));
	}

	/**
	 * Print digits of a number in reverse order
	 */
	public void printDigitsReverse(int num) {
		if (num <= 0) {
			return;
		}
		int rightNum = num % 10;
		System.out.print(rightNum);

		num = num / 10;
		printDigitsReverse(num);
	}

	@Test
	public void printDigitsReverseTest() {
		int num = 123;
		printDigitsReverse(num);
		System.out.println();

		num = 1;
		printDigitsReverse(num);
		System.out.println();

		num = 654321;
		printDigitsReverse(num);
	}

	/**
	 * Print digits in order
	 */
	public void printDigitsInOrder(int num) {
		if ((num / 10) > 0) {
			printDigitsInOrder(num / 10);
		}
		System.out.printf("%d ", num % 10);
	}

	@Test
	public void printDigitsInOrderTest() {
		int num = 123;
		printDigitsInOrder(num);
		System.out.println();

		num = 1;
		printDigitsInOrder(num);
		System.out.println();

		num = 654321;
		printDigitsInOrder(num);
	}

}
