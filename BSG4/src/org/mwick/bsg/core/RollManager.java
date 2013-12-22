package org.mwick.bsg.core;

public interface RollManager {
	/**
	 * Even though the die is 8-sided, this method may return any integer.
	 * Anything below 1 should be treated as 1, and anything above 8 should be treated as 8.
	 * @return the modified outcome of the die roll.
	 */
	public int rollDie();
}
