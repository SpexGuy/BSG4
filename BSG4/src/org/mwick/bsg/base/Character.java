package org.mwick.bsg.base;

import java.util.HashSet;
import java.util.Set;

import org.mwick.bsg.core.Action;
import org.mwick.bsg.core.BoardDependency;
import org.mwick.bsg.core.Choice;

@BoardDependency
public abstract class Character {
	
	protected Player player;
	
	protected final Location startLocation;
	
	protected Set<Title> titles;
	
	protected Action oncePerGame;
	
	protected boolean inUse;
	
	public Character(Location startLocation, Action oncePerGame) {
		this.startLocation = startLocation;
		this.titles = new HashSet<Title>();
		this.oncePerGame = oncePerGame;
		this.inUse = false;
	}
	
	
	
	protected abstract Choice getChoices();
	
	public void removeTitle(Title title) {
		titles.remove(title);
	}
	public void addTitle(Title title) {
		titles.add(title);
	}



	public boolean canMoveTo(Location target) {
		return !target.isHazardous();
	}
}
