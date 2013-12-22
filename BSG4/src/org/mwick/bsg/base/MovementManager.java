package org.mwick.bsg.base;

import org.mwick.bsg.core.Choice;

public interface MovementManager {
	
	Choice getMoveChoices(Player p);

	int getMoveCost(Location from, Location to);
	
	void movePlayer(Player p, Location target);

}
