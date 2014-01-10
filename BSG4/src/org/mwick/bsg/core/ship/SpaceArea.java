package org.mwick.bsg.core.ship;

import org.mwick.bsg.core.Descriptor;

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
	
	<T extends Ship<T>>
	int getNumShips(Class<T> type);
	
	<T extends Ship<T>>
	boolean remove(Descriptor<T> ship);
	
	<T extends Ship<T>>
	Descriptor<T> remove(Class<T> type);
	
	<T extends Ship<T>>
	void add(Descriptor<T> ship);
}
