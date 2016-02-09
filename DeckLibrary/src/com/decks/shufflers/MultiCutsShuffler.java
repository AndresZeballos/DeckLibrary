package com.decks.shufflers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.decks.Card;
import com.decks.IDeckShuffler;

public class MultiCutsShuffler<T extends Card> implements IDeckShuffler<T> {

	private static Random rand;
	private int minCuts;
	private int delta;

	static {
		rand = new Random(12345678);
	}

	public MultiCutsShuffler() {
		this.minCuts = 20;
		this.delta = 10;
	}

	public MultiCutsShuffler(int minCuts, int delta) {
		this.minCuts = minCuts;
		this.delta = delta;
	}

	public List<T> deckShuffle(List<T> cards) {
		ArrayList<T> shuffledCards = new ArrayList<T>(cards);
		int size = cards.size();

		int cuts = (int) (minCuts + rand.nextDouble() * delta);
		List<T> shuffled = new ArrayList<>();
		while (cuts > 0) {
			int middle = (int) (rand.nextDouble() * size / 3 + size / 2.0);
			int index1 = 0;
			int index2 = 0;
			Double ratio = (double) (middle) / (size - middle);
			while (index1 < middle && index2 < (size - middle)) {
				if (index1 + 1 < (index2 + 1) * ratio) {
					shuffled.add(shuffledCards.get(index1));
					index1++;
				} else {
					shuffled.add(shuffledCards.get(middle + index2));
					index2++;
				}
			}
			while (index1 < middle) {
				shuffled.add(shuffledCards.get(index1));
				index1++;
			}
			while (index2 < (size - middle)) {
				shuffled.add(shuffledCards.get(middle + index2));
				index2++;
			}
			shuffledCards.clear();
			shuffledCards.addAll(shuffled);
			shuffled.clear();
			cuts--;
		}
		return shuffledCards;
	}
}
