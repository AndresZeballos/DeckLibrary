package com.decks.shufflers;

import java.util.List;
import java.util.Random;

import com.decks.Card;
import com.decks.IShuffler;

public class RandomShuffler<T extends Card> implements IShuffler<T> {

	private static Random rand;

	static {
		rand = new Random(12345678);
	}

	/**
	 * Uses Random.nextInt() method to return a pseudo-random card from the list
	 */
	public T nextCard(List<T> cards) {
		if (cards.size() > 0) {
			return cards.get(rand.nextInt(cards.size()));
		}
		return null;
	}

}
