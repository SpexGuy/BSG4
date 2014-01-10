package org.mwick.bsg.core.action;

import org.mwick.bsg.core.Board;

public interface Action {
	public static enum Type {
		MOVEMENT,
		ACTION,
		PASSIVE;
	}
	
	public Type getType();
	
	public boolean canAct(Board b);
	
	public void act(Board b);
	
	/**
	 * An action which can always act and does nothing.
	 * It has action type PASSIVE.
	 */
	public static final Action NULL = new Action() {
		@Override
		public Type getType() {
			return Action.Type.PASSIVE;
		}

		@Override
		public boolean canAct(Board b) {
			return true;
		}

		@Override
		public void act(Board b) {
			
		}
	};
	
}
