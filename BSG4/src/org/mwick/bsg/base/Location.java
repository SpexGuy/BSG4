package org.mwick.bsg.base;

import java.util.ArrayList;
import java.util.List;

import org.mwick.bsg.core.Action;
import org.mwick.bsg.core.ActionContainer;

public class Location extends ActionContainer {

	private List<Character> occupants;
	
	public Location(Action action) {
		super(action);
		occupants = new ArrayList<Character>();
	}
	
	public List<Character> getOccupants() {
		return occupants;
	}
	
	public void addCharacter(Character c) {
		occupants.add(c);
	}
	
	public void removeCharacter(Character c) {
		boolean success = occupants.remove(c);
		assert(success);
	}

}
