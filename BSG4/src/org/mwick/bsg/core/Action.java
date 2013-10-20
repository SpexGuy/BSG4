package org.mwick.bsg.core;

public interface Action {
	public static enum Type {
		MOVEMENT,
		ACTION,
		PASSIVE;
	}
	
	public static final Action NULL = new NullAction();
	
	public Type getType();
	
	public boolean canAct();
	
	public void act();
	
}
