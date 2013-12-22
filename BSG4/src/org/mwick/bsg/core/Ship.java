package org.mwick.bsg.core;

public interface Ship {
	/**
	 * returns whether the ship can move from its current position to space b under normal conditions
	 * if the ship is inactive, this returns whether the ship can spawn there.
	 * @param target the proposed move area
	 */
	boolean canMoveTo(SpaceArea target);
	
	/**
	 * @return the current area that this ship occupies
	 */
	SpaceArea getArea();
	
	/**
	 * moves unconditionally to the target space.  Does not worry about two-sided dependencies (that's the manager's job).
	 * @param target the space area this will move to
	 */
	void moveTo(SpaceArea target);
	
	/**
	 * @return whether the ship is currently active (in play)
	 */
	boolean isActive();
	
	/**
	 * sets active to the given value
	 * should only be called by the manager
	 * @param active
	 */
	void setActive(boolean active);
	
	void activate();
	
	void destroy();
	
}
