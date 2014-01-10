package org.mwick.bsg.core.action;

import org.mwick.bsg.core.Board;

public abstract class AbstractAction implements Action {

	protected Action.Type type;
	
	public AbstractAction(Action.Type type) {
		this.type = type;
	}
	
	@Override
	public Action.Type getType() {
		return type;
	}
	
	@Override
	public boolean canAct(Board b) {
		return true;
	}

}
