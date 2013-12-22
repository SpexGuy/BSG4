package org.mwick.bsg.base;

import java.util.ArrayList;
import java.util.List;

import org.mwick.bsg.core.Action;

public abstract class Location {

	private List<Player> occupants;
	private boolean hazardous;
	private boolean binding;
	private int group;
	
	public Location(int group, boolean hazard, boolean binding) {
		this.occupants = new ArrayList<Player>();
		this.hazardous = hazard;
		this.binding = binding;
		this.group = group;
	}
	
	public abstract Action getAction();
	
	public List<Player> getOccupants() {
		return occupants;
	}
	
	public void addPlayer(Player p) {
		occupants.add(p);
	}
	
	public void removePlayer(Player p) {
		boolean success = occupants.remove(p);
		assert(success);
	}

	public boolean isHazardous() {
		return hazardous;
	}
	
	public int getGroup() {
		return group;
	}

	public boolean isBinding() {
		return binding;
	}

}
