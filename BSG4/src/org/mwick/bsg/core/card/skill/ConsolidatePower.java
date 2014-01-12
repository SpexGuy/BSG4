package org.mwick.bsg.core.card.skill;

import org.mwick.bsg.core.Board;

public class ConsolidatePower extends SkillCard {

	public ConsolidatePower(int value, int skill) {
		super(Type.ACTION, value, skill);
	}

	public ConsolidatePower(SkillCard old) {
		super(old);
	}

	@Override
	public ConsolidatePower copy() {
		return new ConsolidatePower(this);
	}

	@Override
	public void act(Board b) {
		((SkillCardManager) b.getManager(SkillCard.class)).chooseDeck();
	}

}
