package com.decks;

import java.util.List;

public interface IShuffler<T extends Card> {

	/**
	 * This method must return a pseudo-random card from the list of cards
	 * @param cards
	 * @return
	 */
	public T nextCard(List<T> cards);

}
