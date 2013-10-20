package org.mwick.bsg.base;

import java.util.ArrayList;
import java.util.List;

import org.mwick.bsg.core.Choice;

public abstract class Location {

	private List<Character> occupants;
	
	public Location() {
		occupants = new ArrayList<Character>();
	}
	
	public abstract Choice getChoices();
	
	public List<Character> getOccupants() {
		return occupants;
	}
	
	public void addCharacter(Character c) {
		occupants.add(c);
		c.setLocation(this);
	}
	
	public void removeCharacter(Character c) {
		boolean success = occupants.remove(c);
		assert(success);
	}

}
