package org.mwick.bsg.core.card.skill;

import org.mwick.bsg.core.Board;
import org.mwick.bsg.core.action.Action;

public class EvasiveManeuvers extends SkillCard {

	public EvasiveManeuvers(int value, int skill) {
		super(Action.Type.PASSIVE, value, skill);
	}

	public EvasiveManeuvers(EvasiveManeuvers old) {
		super(old);
	}

	@Override
	public EvasiveManeuvers copy() {
		return new EvasiveManeuvers(this);
	}

	@Override
	public void act(Board b) {
		
	}
	
	public static aspect Prompt {
		//TODO:[attack] after viper attack prompt and reroll
		//ensure recursion is possible
	}

}
