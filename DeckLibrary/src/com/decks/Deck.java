package com.decks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.decks.exceptions.CardNotInDeckException;

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

	/**
	 * Shuffle the cards and restart the Deck. This method would be useful in
	 * the begin of each game to set the deck to a random state Internally use
	 * the Collections.shuffle method
	 */
	public void shuffle() {
		this.currentCard = 0;
		Collections.shuffle(deckCards, rand);
	}

	/**
	 * Shuffle the cards and restart the Deck. Delegate the shuffle of the deck
	 * to the IDeckShuffler passed
	 */
	public void shuffle(IDeckShuffler<T> shuffler) {
		this.currentCard = 0;
		deckCards = shuffler.deckShuffle(deckCards);
	}

	/**
	 * Call deck.size times the nextCard method of IShuffler to Shuffle the
	 * deck. The IShuffler must return card in the list passed.
	 * 
	 * @throws CardNotInDeckException
	 */
	public void shuffle(IShuffler<T> shuffler) throws CardNotInDeckException {
		this.currentCard = 0;
		List<T> cards = new ArrayList<T>(deckCards);
		T next;
		for (int i = 0; i < deckCards.size(); i++) {
			next = shuffler.nextCard(cards);
			if (!cards.remove(next))
				throw new CardNotInDeckException("The nextCard method must return a card contained in cards recived");
			deckCards.set(i, next);
		}
	}

	/**
	 * Shuffle the remaining cards in the deck. Internally use the
	 * Collections.shuffle method
	 */
	public void shuffleRemain() {
		List<T> cards = deckCards.subList(currentCard, deckCards.size());
		Collections.shuffle(cards, rand);
	}

	/**
	 * Shuffle the remaining cards in the deck using IShuffler. The nextCard
	 * method is called (deck.size - cardUsed) times
	 * 
	 * @throws CardNotInDeckException
	 */
	public void shuffleRemain(IShuffler<T> shuffler) throws CardNotInDeckException {
		List<T> cards = new ArrayList<T>(deckCards.subList(currentCard, deckCards.size()));
		T next;
		for (int i = currentCard; i < deckCards.size(); i++) {
			next = shuffler.nextCard(cards);
			if (!cards.remove(next))
				throw new CardNotInDeckException("The nextCard method must return a card contained in cards recived");
			deckCards.set(i, next);
		}
	}

	/**
	 * Add the card to the bottom of the deck. 
	 * Returns false when the card == null
	 * @param card to be added
	 * @return
	 */
	public boolean addBottom(T card) {
		if (card != null)
			return deckCards.add(card);
		return false;
	}

	/**
	 * Add the card to the top of the deck. 
	 * Returns false when the card == null
	 * The next call to nextCard() must return the card added.
	 * @param card to be added
	 * @return
	 */
	public boolean addTop(T card) {
		if (card != null) {
			int oldSize = deckCards.size();
			deckCards.add(currentCard, card);
			return oldSize + 1 == deckCards.size();
		}
		return false;
	}

	/** 
	 * Remove the first occurrence of the card passed
	 * @param card
	 * @return
	 */
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

	/** 
	 * Return true if the deck has more cards to be used.
	 * Return false when the deck has no more cards (or empty)
	 * @return
	 */
	public boolean hasCards() {
		return (currentCard < deckCards.size());
	}

	/**
	 * Returns the next card to be used
	 * Returns null when the deck has no more cards (or empty)
	 * @return
	 */
	public T nextCard() {
		if (currentCard < deckCards.size())
			return deckCards.get(currentCard++);
		return null;
	}

}
