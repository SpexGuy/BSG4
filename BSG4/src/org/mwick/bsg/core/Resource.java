package org.mwick.bsg.core;

public class Resource {
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
		if (amount < 0) {
			amount = 0;
			//TODO:[win] cylons win
		}
	}
}
