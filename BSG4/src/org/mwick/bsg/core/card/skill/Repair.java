package org.mwick.bsg.core.card.skill;

import org.mwick.bsg.core.Board;

public class Repair extends SkillCard {

	public Repair(int value, int skill) {
		super(Type.ACTION, value, skill);
	}

	public Repair(Repair old) {
		super(old);
	}

	@Override
	public Repair copy() {
		return new Repair(this);
	}
	
	@Override
	public boolean canAct(Board b) {
		//TODO:[damage] return space is damaged
		return true;
	}

	@Override
	public void act(Board b) {
		//TODO:[damage] repair space
	}

}
