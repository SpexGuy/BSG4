package org.mwick.bsg.core;

import java.util.ArrayList;
import java.util.List;

public class Choice extends ActionList {
	
	public Choice(Action.Type type) {
		super(type);
	}
	
	protected List<Action> getExecutableActions() {
		List<Action> execs = new ArrayList<Action>(actions.size());
		for (Action a : actions) {
			if (a.canAct()) {
				execs.add(a);
			}
		}
		return execs;
	}
	
	@Override
	public void act() {
		List<Action> choices = getExecutableActions();
		if (choices.size() == 1) {
			choices.get(0).act();
		} else {
			//TODO:[prompt] consult user for choice
			System.err.println("User choice not yet implemented!");
		}
	}
	
	@Override
	public boolean canAct() {
		for (Action a : actions) {
			if (a.canAct()) {
				return true;
			}
		}
		return false;
	}

}
