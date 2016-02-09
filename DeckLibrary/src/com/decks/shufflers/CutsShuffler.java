package com.decks.shufflers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.decks.Card;
import com.decks.IDeckShuffler;

public class CutsShuffler<T extends Card> implements IDeckShuffler<T> {

	private static Random rand;
	private int minCuts;
	private int delta;

	static {
		rand = new Random(12345678);
	}

	public CutsShuffler() {
		this.minCuts = 20;
		this.delta = 10;
	}

	public CutsShuffler(int minCuts, int delta) {
		this.minCuts = minCuts;
		this.delta = delta;
	}

	public List<T> deckShuffle(List<T> cards) {
		if (cards.isEmpty())
			return cards;
		ArrayList<T> shuffledCards = new ArrayList<T>(cards);
		int size = cards.size();
		int cuts = (int) (minCuts + rand.nextDouble() * delta);
		List<T> shuffled = new ArrayList<>();
		while (cuts > 0) {
			int up = rand.nextInt(size - 1) + 1;
			int down = rand.nextInt(up);
			if (cuts % 3 == 0) {
				shuffled.addAll(shuffledCards.subList(0, down));
				shuffled.addAll(shuffledCards.subList(up, size));
				shuffled.addAll(shuffledCards.subList(down, up));
			} else if (cuts % 3 == 1) {
				shuffled.addAll(shuffledCards.subList(up, size));
				shuffled.addAll(shuffledCards.subList(down, up));
				shuffled.addAll(shuffledCards.subList(0, down));
			} else {
				shuffled.addAll(shuffledCards.subList(down, up));
				shuffled.addAll(shuffledCards.subList(0, down));
				shuffled.addAll(shuffledCards.subList(up, size));
			}
			shuffledCards.clear();
			shuffledCards.addAll(shuffled);
			shuffled.clear();
			cuts--;
		}
		return shuffledCards;
	}
}
