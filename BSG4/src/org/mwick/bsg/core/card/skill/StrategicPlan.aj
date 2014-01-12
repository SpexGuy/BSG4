package org.mwick.bsg.core.card.skill;

import org.mwick.bsg.core.Board;

public class StrategicPlan extends SkillCard {

	public StrategicPlan(int value, int skill) {
		super(Type.PASSIVE, value, skill);
	}

	public StrategicPlan(StrategicPlan old) {
		super(old);
	}

	@Override
	public StrategicPlan copy() {
		return new StrategicPlan(this);
	}

	@Override
	public void act(Board b) {
		//unused - the aspect takes care of everything.
	}
	
	public static aspect Prompt {
		int around(Board b) : execution(int Board+.rollDie(..)) && this(b) {
			//TODO:[skill] prompt all users who have SP to use it
			return proceed(b)+2;
		}
	}

}
