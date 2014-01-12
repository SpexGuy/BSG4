package org.mwick.bsg.base;

import java.util.HashSet;
import java.util.Set;

import org.mwick.bsg.core.Token;
import org.mwick.bsg.core.action.Action;
import org.mwick.bsg.core.action.Choice;
import org.mwick.bsg.core.location.Location;
import org.mwick.bsg.core.player.Player;

public abstract class Character implements Token<Character> {
	
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
