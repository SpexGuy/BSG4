package org.mwick.bsg.core.card.skill;

import org.mwick.bsg.core.Board;

public class ScientificResearch extends SkillCard {

	public ScientificResearch(int value, int skill) {
		super(Type.PASSIVE, value, skill);
	}

	public ScientificResearch(ScientificResearch old) {
		super(old);
	}

	@Override
	public ScientificResearch copy() {
		return new ScientificResearch(this);
	}

	@Override
	public void act(Board b) {
		//unused
	}
	
	public static aspect Prompt {
		int around(SkillCard card) :
			SkillCheck.Pointcuts.evaluateSkillCard(card)
		{
			if (card.getSkill() == BaseSkillCardManager.ENGINEERING)
				return Math.abs(proceed(card));
			return proceed(card);
		}
	}

}
