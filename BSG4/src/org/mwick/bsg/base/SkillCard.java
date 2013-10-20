package org.mwick.bsg.base;

import org.mwick.bsg.core.AbstractAction;
import org.mwick.bsg.core.Action;

public abstract class SkillCard extends AbstractAction {
	private int value;
	
	public SkillCard(Action.Type type, int value) {
		super(type);
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	
}
