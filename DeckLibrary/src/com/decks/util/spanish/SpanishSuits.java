package com.decks.util.spanish;

public enum SpanishSuits { Cups(1), Coins(2), Clubs(3), Swords(4);
	private final int value;
	
	private SpanishSuits(final int value) { 
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
