package com.practice.blackjack;

import org.junit.Test;

public class BlackJackDriverTest {

	@Test
	public void playTest() {
		int numOfPlayers = 3;
		BlackJackDriver driver = new BlackJackDriver(numOfPlayers);
		driver.play();
	}

}
