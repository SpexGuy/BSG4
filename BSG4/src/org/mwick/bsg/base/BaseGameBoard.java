package org.mwick.bsg.base;

import java.util.HashMap;
import java.util.Map;

import org.mwick.bsg.core.Board;
import org.mwick.bsg.core.Resource;
import org.mwick.bsg.core.RollManager;
import org.mwick.bsg.core.RollManagerImpl;
import org.mwick.bsg.core.Ship;

public class BaseGameBoard implements Board {

	private Map<Class<?>, Object> managers = new HashMap<Class<?>, Object>();

	public BaseGameBoard() {
		managers.put(Resource.class, new BaseResourceManager());
		managers.put(BoardingParty.class, new BoardingParty(4, 4));
		managers.put(JumpTrack.class, new JumpTrack());
		managers.put(RollManager.class, new RollManagerImpl());
		//the ship manager has a temporal dependency
		//on the presence of the resource manager,
		//since it instantiates CivilianShips, which use Resource.Change
		managers.put(Ship.class, new BaseShipManager());
		managers.put(Character.class, new BaseCharacterSelector());
	}

	@Override
	public Object getTokenManager(Class<?> tokenClass) {
		return managers.get(tokenClass);
	}

}
