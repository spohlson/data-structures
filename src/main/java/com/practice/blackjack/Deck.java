package com.practice.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Deck {

	protected List<Card> cards;
	protected int index;
	protected boolean allowReShuffling;

	protected Deck() {

	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
		index = 0;
	}

	public void reset() {
		Collections.shuffle(cards);
		index = 0;
	}

	/**
	 * Shuffle remaining active cards (i.e. from index on) so cards already in
	 * play aren't reused.
	 */
	public void shuffle() {
		if (!cardsRemaining()) {

			if (!allowReShuffling) {
				throw new RuntimeException("No cards left to shuffle.");
			}
			reset();
			return;
		}

		List<Card> remaining = cards.subList(index, cards.size());
		List<Card> temp = new ArrayList<>(remaining);

		remaining.clear();

		Collections.shuffle(temp);

		remaining.addAll(temp);
	}

	protected boolean cardsRemaining() {
		return index < cards.size();
	}

	public Card getTopCard() {
		if (!cardsRemaining()) {
			throw new RuntimeException("No more cards to play.");
		}

		Card card = cards.get(index);
		index++;

		return card;
	}

	public List<Card> getCards(int numOfCards) {
		List<Card> topCards = new ArrayList<>(numOfCards);
		int count = 0;

		while (count < numOfCards) {
			Card card = getTopCard();
			topCards.add(card);

			count++;
		}

		return topCards;
	}

	public abstract Hand getHand(int numOfCards);

}
