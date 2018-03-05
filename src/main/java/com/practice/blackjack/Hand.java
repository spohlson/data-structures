package com.practice.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {

	protected List<Card> cards;

	protected Hand() {
		cards = new ArrayList<>(0);
	}

	protected Hand(List<Card> cards) {
		this.cards = cards;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public void addCard(Card card) {
		cards.add(card);
	}

}
