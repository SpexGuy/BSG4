package org.mwick.bsg.base;

import java.util.HashMap;
import java.util.Map;

import org.mwick.bsg.core.Board;
import org.mwick.bsg.core.Resource;
import org.mwick.bsg.core.Ship;

public class BaseGameBoard implements Board {

	private Map<Class<?>, Object> managers = new HashMap<Class<?>, Object>();

	public BaseGameBoard() {
		managers.put(Resource.class, new BaseResourceManager());
		managers.put(BoardingParty.class, new BoardingParty(4, 4));
		managers.put(JumpTrack.class, new JumpTrack());
		//the ship manager has a temporal dependency
		//on the presence of the resource manager
		managers.put(Ship.class, new BaseShipManager());
		managers.put(Character.class, new BaseCharacterSelector());
	}

	@Override
	public Object getTokenManager(Class<?> tokenClass) {
		return managers.get(tokenClass);
	}

}
