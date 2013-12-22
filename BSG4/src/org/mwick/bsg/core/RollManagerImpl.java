package org.mwick.bsg.core;

public class RollManagerImpl implements RollManager {

	/**
	 * use aspects to add modifiers
	 */
	@Override
	public int rollDie() {
		return (int)(Math.random()*8) + 1;
	}

}
