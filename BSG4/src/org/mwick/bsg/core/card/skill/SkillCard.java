package org.mwick.bsg.core.card.skill;

import org.mwick.bsg.core.Token;
import org.mwick.bsg.core.action.AbstractAction;
import org.mwick.bsg.core.action.Action;

public abstract class SkillCard extends AbstractAction implements Token<SkillCard> {
	
	private int value;
	private int skill;
	
	public SkillCard(Action.Type type, int value, int skill) {
		super(type);
		this.value = value;
		this.skill = skill;
	}
	
	protected SkillCard(SkillCard old) {
		super(old.getType());
		this.value = old.value;
		this.skill = old.skill;
	}
	
	public int getValue() {
		return value;
	}
	
	int getSkill() {
		return skill;
	}
}
