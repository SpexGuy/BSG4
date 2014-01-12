package org.mwick.bsg.core.card.skill;

import org.mwick.bsg.core.Board;
import org.mwick.bsg.core.Pointcuts;

public class ExecutiveOrder extends SkillCard {

	public ExecutiveOrder(int value, int skill) {
		super(Type.ACTION, value, skill);
	}

	public ExecutiveOrder(ExecutiveOrder old) {
		super(old);
	}

	@Override
	public ExecutiveOrder copy() {
		return new ExecutiveOrder(this);
	}
	
	@Override
	public boolean canAct(Board b) {
		return super.canAct(b);
	}

	@Override
	public void act(Board b) {
		//TODO:[player] choose a different player
	}
	
	public static aspect NoRecursion perthis(Pointcuts.BoardOperation(Board)) {
		boolean around() : execution(boolean ExecutiveOrder+.canAct(..)) &&
					cflowbelow(execution(* ExecutiveOrder+.act(..))) {
			return false;
		}
	}
}
