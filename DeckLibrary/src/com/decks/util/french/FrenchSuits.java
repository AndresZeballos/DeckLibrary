package com.decks.util.french;

public enum FrenchSuits { Hearts(1), Tiles(2), Clovers(3), Pikes(4);
	private final int value;
	
	private FrenchSuits(final int value) { 
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
