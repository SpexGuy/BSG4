package org.mwick.bsg.core;

@BoardDependency
public interface Action {
	public static enum Type {
		MOVEMENT,
		ACTION,
		PASSIVE;
	}
	
	/**
	 * An action which can always act and does nothing.
	 * It has action type PASSIVE.
	 */
	public static final Action NULL = new NullAction();
	
	public Type getType();
	
	public boolean canAct();
	
	public void act();
	
}
