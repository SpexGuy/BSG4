package org.mwick.bsg.core.card.skill;

import org.mwick.bsg.core.Board;
import org.mwick.bsg.core.action.Action;

public class MaximumFirepower extends SkillCard {

	public MaximumFirepower(int value, int skill) {
		super(Action.Type.ACTION, value, skill);
	}

	public MaximumFirepower(MaximumFirepower old) {
		super(old);
	}

	@Override
	public MaximumFirepower copy() {
		return new MaximumFirepower(this);
	}
	
	@Override
	public boolean canAct(Board b) {
		//TODO:[player] return player is in viper
		return true;
	}

	@Override
	public void act(Board b) {
		//TODO:[attack] attack up to four times
	}

}
