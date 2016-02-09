package com.decks;

import java.util.List;

public interface IDeckShuffler<T extends Card> {
	
	/**
	 * This method receives a list of cards, randomize and return it
	 * @param cards
	 * @return
	 */
	public List<T> deckShuffle(List<T> cards);

}
