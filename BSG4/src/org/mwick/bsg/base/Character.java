package org.mwick.bsg.base;

import org.mwick.bsg.core.Hand;

public class Character {
	
	private Location location;
	
	private Hand<SkillCard> skillCards;
	
	
	
	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
}
