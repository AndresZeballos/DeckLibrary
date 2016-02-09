package com.decks;

public class SimpleCard extends Card {

	private int value;

	public SimpleCard(int value) {
		super();
		this.value = value;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SimpleCard other = (SimpleCard) obj;
		if (value != other.value)
			return false;
		return true;
	}
	
}
