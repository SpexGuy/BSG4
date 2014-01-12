package org.mwick.bsg.core.card.skill;

import org.mwick.bsg.core.Token;
import org.mwick.bsg.core.action.AbstractAction;

public abstract class SkillCard extends AbstractAction implements Token<SkillCard> {
	
	public static enum Type {
		MOVEMENT,
		ACTION,
		PASSIVE;
	}
	
	private int value;
	private int skill;
	private SkillCard.Type type;
	
	public SkillCard(SkillCard.Type type, int value, int skill) {
		this.type = type;
		this.value = value;
		this.skill = skill;
	}
	
	protected SkillCard(SkillCard old) {
		this.type = old.type;
		this.value = old.value;
		this.skill = old.skill;
	}
	
	public int getValue() {
		return value;
	}
	
	int getSkill() {
		return skill;
	}
	
	public Type getType() {
		return type;
	}
}
