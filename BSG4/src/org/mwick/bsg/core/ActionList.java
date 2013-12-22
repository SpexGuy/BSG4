package org.mwick.bsg.core;

import java.util.ArrayList;
import java.util.List;

public abstract class ActionList extends AbstractAction {
	
	protected List<Action> actions;
	
	public ActionList(Action.Type type) {
		super(type);
		actions = new ArrayList<Action>();
	}
	
	public ActionList addAction(Action a) {
		assert(a.getType() == this.type);
		actions.add(a);
		return this;
	}
	
	public ActionList addAll(ActionList other) {
		actions.addAll(other.actions);
		return this;
	}
}
