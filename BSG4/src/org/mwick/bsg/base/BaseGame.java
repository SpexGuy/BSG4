package org.mwick.bsg.base;

import org.mwick.bsg.core.Board;
import org.mwick.bsg.core.location.Location;
import org.mwick.bsg.core.location.LocationManager;
import org.mwick.bsg.core.resource.BaseResourceManager;
import org.mwick.bsg.core.resource.Resource;
import org.mwick.bsg.core.ship.BaseShipManager;
import org.mwick.bsg.core.ship.Ship;

public class BaseGame {

	public static void main(String[] args) {
		Board.current.addManager(Resource.class, new BaseResourceManager());
		Board.current.addManager(BoardingParty.class, new BoardingParty(4, 4));
		Board.current.addManager(JumpTrack.class, new JumpTrack());
		Board.current.addManager(Location.class, new LocationManager());
		//the ship manager has a temporal dependency
		//on the presence of the resource manager,
		//since it instantiates CivilianShips, which use Resource.Change
		Board.current.addManager(Ship.class, new BaseShipManager());
		Board.current.addManager(Character.class, new BaseCharacterManager());
	}
}
