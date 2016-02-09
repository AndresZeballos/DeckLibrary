package com.MTG.deck;

import com.decks.Card;

public class MTGCard extends Card implements IUntap {
	
	private String name;
	private int cost;
	private int priority; 
	private boolean isTapped;
	
	public MTGCard() {
		super();
	}

	public MTGCard(String name, int cost, int priority) {
		super();
		this.name = name;
		this.cost = cost;
		this.priority = priority;
		this.isTapped = false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cost;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + priority;
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
		MTGCard other = (MTGCard) obj;
		if (cost != other.cost)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (priority != other.priority)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MTGCard [name=" + name + ", cost=" + cost + ", priority=" + priority + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	@Override
	public void untap() {
		this.isTapped = false;
	}

	public boolean isTapped() {
		return isTapped;
	}
	
}
