package org.mwick.bsg.core.space;

import org.mwick.bsg.core.Board;
import org.mwick.bsg.core.Descriptor;
import org.mwick.bsg.core.Token;
import org.mwick.bsg.core.ship.Ship;

public interface SpaceArea extends Token<SpaceArea> {
	/**
	 * returns the distance to the other space area
	 * @param other
	 * @return
	 */
	int distanceTo(Board b, Descriptor<SpaceArea> other);
	
	boolean canSpawnVipers();
	
	Descriptor<SpaceArea> getCW();
	Descriptor<SpaceArea> getCCW();
	
	<T extends Ship<T>>
	int getNumShips(Class<T> type);
	
	<T extends Ship<T>>
	boolean remove(Descriptor<T> ship);
	
	<T extends Ship<T>>
	Descriptor<T> remove(Class<T> type);
	
	<T extends Ship<T>>
	void add(Descriptor<T> ship);

	Descriptor<SpaceArea> getDescriptor();
}
