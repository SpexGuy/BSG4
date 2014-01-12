package org.mwick.bsg.core;

import java.io.Serializable;

/**
 * A Manager represents a part of the game's mutable state. Through serialization and deserialization
 * of only the managers, the game should be able to save and load itself.
 * By copying the managers, the game should effectively have a deep copy of itself, tied to the Board
 * instance.
 */
public interface Manager<T> extends Serializable {

	/** Should return a deep copy of the manager, for which any
	 * modifications will not effect the original in any way.
	 */
	public Manager<T> copy(Board newBoard);

}
