package com.decks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck<T extends Card> {

	protected static Random rand = new Random(12345678);

	protected int currentCard;
	protected List<T> deckCards;

	protected Deck() {
		this.currentCard = 0;
	}

	public Deck(List<T> deckCards) {
		this.currentCard = 0;
		this.deckCards = deckCards;
	}

	public List<T> getDeckCards() {
		return deckCards;
	}

	public void shuffle() {
		this.currentCard = 0;
		Collections.shuffle(deckCards, rand);
	}

	public void shuffle(IDeckShuffler<T> shuffler) {
		this.currentCard = 0;
		deckCards = shuffler.deckShuffle(deckCards);
	}

	public void shuffle(IShuffler<T> shuffler) {
		this.currentCard = 0;
		List<T> cards = new ArrayList<T>(deckCards);
		T next;
		for (int i = 0; i < deckCards.size(); i++) {
			next = shuffler.nextCard(cards);
			deckCards.set(i, next);
			cards.remove(next);
		}
	}

	public void shuffleRemain() {
		List<T> cards = deckCards.subList(currentCard, deckCards.size());
		Collections.shuffle(cards, rand);
	}

	public void shuffleRemain(IShuffler<T> shuffler) {
		List<T> cards = new ArrayList<T>(deckCards.subList(currentCard, deckCards.size()));
		T next;
		for (int i = currentCard; i < deckCards.size(); i++) {
			next = shuffler.nextCard(cards);
			deckCards.set(i, next);
			cards.remove(next);
		}
	}

	public boolean addBottom(T card) {
		if (card != null)
			return deckCards.add(card);
		return false;
	}

	public boolean addTop(T card) {
		if (card != null) {
			int oldSize = deckCards.size();
			deckCards.add(currentCard, card);
			return oldSize + 1 == deckCards.size();
		}
		return false;
	}

	public boolean removeCard(T card) {
		if (card != null)
			return deckCards.remove(card);
		return false;
	}

	@Override
	public String toString() {
		return "Deck [deckCards=" + deckCards + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Deck<?> other = (Deck<?>) obj;
		if (currentCard != other.currentCard)
			return false;
		if (deckCards == null) {
			if (other.deckCards != null)
				return false;
		} else if (!deckCards.equals(other.deckCards))
			return false;
		return true;
	}

	public boolean hasCards() {
		return (currentCard < deckCards.size());
	}

	public T nextCard() {
		if (currentCard < deckCards.size())
			return deckCards.get(currentCard++);
		return null;
	}

}
