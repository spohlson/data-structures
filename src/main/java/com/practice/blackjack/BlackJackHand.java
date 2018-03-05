package com.practice.blackjack;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlackJackHand extends Hand {

	private static final Logger LOG = LoggerFactory.getLogger(BlackJackHand.class);

	private int score;

	public BlackJackHand() {
		super();
	}

	public BlackJackHand(List<Card> cards) {
		super(cards);

		for (Card card : cards) {
			score += card.getNumberValue();
		}
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public void addCard(Card card) {
		super.addCard(card);
		score += card.getNumberValue();
	}

	public boolean isBust() {
		return score > 21;
	}

	public boolean isBlackJack() {
		return score == 21;
	}

	/**
	 * For debugging purposes.
	 */
	public void log() {
		LOG.debug("Score: {}", score);

		for (Card card : cards) {
			LOG.debug("{} {}", card.getSuit().name(), card.getNumberValue());
		}
		LOG.debug("----------------");
	}

}
