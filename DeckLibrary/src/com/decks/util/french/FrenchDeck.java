package com.decks.util.french;

import java.util.ArrayList;

import com.decks.Deck;

public class FrenchDeck extends Deck<FrenchCard> {

	/**
	 * Create a deck of 52 French cards
	 */
	public FrenchDeck() {
		super();
		this.deckCards = new ArrayList<FrenchCard>();
		for (FrenchSuits f : FrenchSuits.values()) {
			for (FrenchRanks r : FrenchRanks.values()) {
				deckCards.add(new FrenchCard(f, r));
			}
		}
	}
}
