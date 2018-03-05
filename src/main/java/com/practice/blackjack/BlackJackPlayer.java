package com.practice.blackjack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlackJackPlayer extends Player {

	private static final Logger LOG = LoggerFactory.getLogger(BlackJackPlayer.class);

	protected BlackJackHand hand;

	public BlackJackPlayer(String name, BlackJackHand hand) {
		super(name);
		this.hand = hand;
	}

	public BlackJackHand getHand() {
		return hand;
	}

	public void setHand(BlackJackHand hand) {
		this.hand = hand;
	}

	public void addCardToHand(Card card) {
		hand.addCard(card);
	}

	public boolean hit() {
		int score = hand.getScore();
		return score < 17;
	}

	public int getScore() {
		return hand.getScore();
	}

	public void logHand() {
		LOG.debug("{} Hand:", name);
		hand.log();
	}

}
