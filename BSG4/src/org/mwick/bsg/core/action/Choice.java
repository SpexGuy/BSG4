package org.mwick.bsg.core.action;

import java.util.ArrayList;
import java.util.List;

import org.mwick.bsg.core.Board;

public class Choice extends ActionList {
	
	public static final Choice NULL = new Choice();
	
	public Choice() {
	}
	
	public Choice(Action action) {
		this.addAction(action);
	}
	
	protected List<Action> getExecutableActions(Board b) {
		List<Action> execs = new ArrayList<Action>(actions.size());
		for (Action a : actions) {
			if (a.canAct(b)) {
				execs.add(a);
			}
		}
		return execs;
	}
	
	@Override
	public void act(Board b) {
		List<Action> choices = getExecutableActions(b);
		if (choices.size() == 1) {
			choices.get(0).act(b);
		} else {
			//TODO:[prompt] consult user for choice
			System.err.println("User choice not yet implemented!");
		}
	}
	
	@Override
	public boolean canAct(Board b) {
		for (Action a : actions) {
			if (a.canAct(b)) {
				return true;
			}
		}
		return false;
	}

}
