package com.practice.blackjack;

import java.util.ArrayList;
import java.util.List;

public class BlackJackDriver {

	private BlackJackDeck deck;
	private BlackJackDealer dealer;
	private List<BlackJackPlayer> players;

	public BlackJackDriver(int numOfPlayers) {
		deck = new BlackJackDeck(true);
		createDealer();
		createPlayers(numOfPlayers);
	}

	private void createDealer() {
		dealer = new BlackJackDealer(deck.getHand());
	}

	private void createPlayers(int numOfPlayers) {
		players = new ArrayList<>(numOfPlayers);

		int count = 1;

		while (count <= numOfPlayers) {
			String name = "Player " + count;
			BlackJackPlayer player = new BlackJackPlayer(name, deck.getHand());
			players.add(player);

			count++;
		}
	}

	/**
	 * Returns winners of the game.
	 */
	public List<BlackJackPlayer> play() {
		List<BlackJackPlayer> inPlay = new ArrayList<>(0);
		boolean blackJackFound = false;

		for (BlackJackPlayer player : players) {
			BlackJackHand hand = hitPlayerAndShowFinalHand(player);
			player.logHand();

			if (!hand.isBust()) {
				inPlay.add(player);

				if (hand.isBlackJack()) {
					blackJackFound = true;
				}
			}
		}

		BlackJackHand dealerHand = hitPlayerAndShowFinalHand(dealer);
		dealer.logHand();

		List<BlackJackPlayer> winners = new ArrayList<>(0);

		if (dealerHand.isBust()) {
			return inPlay;
		} else if (dealerHand.isBlackJack()) {
			// if a player & dealer both have blackjack then no one wins
			if (!blackJackFound) {
				winners.add(dealer);
			}
			return winners;
		}

		int dealerScore = dealerHand.getScore();
		boolean dealerWins = true;

		for (BlackJackPlayer player : inPlay) {
			int playerScore = player.getScore();

			if (playerScore > dealerScore) {
				winners.add(player);

				dealerWins = false;
			}
		}

		if (dealerWins) {
			// only dealer should be present in winners list
			winners.add(dealer);
		}

		return winners;
	}

	private BlackJackHand hitPlayerAndShowFinalHand(BlackJackPlayer player) {
		while (player.hit()) {
			player.addCardToHand(deck.getTopCard());
		}

		BlackJackHand hand = player.getHand();
		return hand;
	}

	public static void main(String[] args) {
		int numOfPlayers = 3;

		BlackJackDriver driver = new BlackJackDriver(numOfPlayers);
		List<BlackJackPlayer> winners = driver.play();

		System.out.println("Winners: ");
		for (BlackJackPlayer winner : winners) {
			System.out.println(winner.getName());
		}
	}

}
