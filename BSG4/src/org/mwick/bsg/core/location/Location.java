package org.mwick.bsg.core.location;

import org.mwick.bsg.core.Descriptor;
import org.mwick.bsg.core.Token;
import org.mwick.bsg.core.action.Action;

public abstract class Location implements Token<Location> {

	private boolean hazardous;
	private boolean binding;
	private int group;
	private Descriptor<Location> desc;
	
	public Location(Descriptor<Location> desc, int group, boolean hazard, boolean binding) {
		this.hazardous = hazard;
		this.binding = binding;
		this.group = group;
		this.desc = desc;
	}
	
	public abstract Action getAction();

	public boolean isHazardous() {
		return hazardous;
	}
	
	public int getGroup() {
		return group;
	}

	public boolean isBinding() {
		return binding;
	}

	public Descriptor<Location> getDescriptor() {
		return desc;
	}

}