package org.mwick.bsg.core.resource;

import org.mwick.bsg.core.Token;

public class Resource implements Token<Resource> {
	private int amount;
	public Resource(int startAmount) {
		amount = startAmount;
	}
	public int getAmount() {
		return amount;
	}
	public void addAmount(int change) {
		amount += change;
		if (amount > 15)
			amount = 15;
		if (amount <= 0) {
			amount = 0;
			//TODO:[win] cylons win
		}
	}
	
	@Override
	public Resource copy() {
		return new Resource(amount);
	}
}
