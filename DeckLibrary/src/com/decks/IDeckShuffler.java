package com.decks;

import java.util.List;

public interface IDeckShuffler<T extends Card> {
	
	public List<T> deckShuffle(List<T> cards);

}
