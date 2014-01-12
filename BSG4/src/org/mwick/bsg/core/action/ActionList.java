package org.mwick.bsg.core.action;

import java.util.ArrayList;
import java.util.List;

public abstract class ActionList extends AbstractAction {
	
	protected List<Action> actions;
	
	public ActionList() {
		actions = new ArrayList<Action>();
	}
	
	public ActionList addAction(Action a) {
		actions.add(a);
		return this;
	}
	
	public ActionList addAll(ActionList other) {
		actions.addAll(other.actions);
		return this;
	}
}
