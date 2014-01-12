package org.mwick.bsg.core.action;

import org.mwick.bsg.core.Board;

public interface Action {
	
	public boolean canAct(Board b);
	
	public void act(Board b);
	
	/**
	 * An action which can always act and does nothing.
	 * It has action type PASSIVE.
	 */
	public static final Action NULL = new Action() {
		@Override
		public boolean canAct(Board b) {
			return true;
		}

		@Override
		public void act(Board b) {
			
		}
	};
	
}
