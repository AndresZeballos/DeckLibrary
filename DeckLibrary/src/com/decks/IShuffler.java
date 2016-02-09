package com.decks;

import java.util.List;

public interface IShuffler<T extends Card> {
	
	public T nextCard(List<T> cards);

}
