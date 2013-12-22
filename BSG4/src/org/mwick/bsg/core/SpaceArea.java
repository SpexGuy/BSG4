package org.mwick.bsg.core;

public interface SpaceArea {
	/**
	 * returns the distance to the other space area
	 * @param other
	 * @return
	 */
	int distanceTo(SpaceArea other);
	boolean canSpawnVipers();
	SpaceArea getCW();
	SpaceArea getCCW();
	int getNumShips(Class<? extends Ship> type);
	boolean remove(Ship ship);
	Ship remove(Class<? extends Ship> type);
	void add(Ship ship);
}
