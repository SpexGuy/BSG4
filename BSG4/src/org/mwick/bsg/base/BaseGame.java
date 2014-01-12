package org.mwick.bsg.base;

import org.mwick.bsg.core.Board;
import org.mwick.bsg.core.card.destination.JumpTrack;
import org.mwick.bsg.core.card.skill.BaseSkillCardManager;
import org.mwick.bsg.core.card.skill.SkillCard;
import org.mwick.bsg.core.location.Location;
import org.mwick.bsg.core.location.LocationManager;
import org.mwick.bsg.core.resource.BaseResourceManager;
import org.mwick.bsg.core.resource.Resource;
import org.mwick.bsg.core.ship.BaseShipManager;
import org.mwick.bsg.core.ship.Ship;
import org.mwick.bsg.core.space.BaseSpaceManager;
import org.mwick.bsg.core.space.SpaceArea;

public class BaseGame {

	public static void main(String[] args) {
		Board.current.addManager(Resource.class, new BaseResourceManager());
		Board.current.addManager(BoardingParty.class, new BoardingParty(4, 4));
		Board.current.addManager(JumpTrack.class, new JumpTrack());
		Board.current.addManager(Location.class, new LocationManager());
		Board.current.addManager(SpaceArea.class, new BaseSpaceManager());
		//the ship manager has a temporal dependency
		//on the presence of the SpaceManager,
		//since it contains a reference to the reserves.
		Board.current.addManager(Ship.class, new BaseShipManager());
		Board.current.addManager(Character.class, new BaseCharacterManager());
		Board.current.addManager(SkillCard.class, new BaseSkillCardManager());
		Board board = Board.current.copy();
		System.out.println("Success!");
	}
}
