package org.mwick.bsg.core.card.skill;

import org.aspectj.lang.Aspects;
import org.mwick.bsg.core.Board;
import org.mwick.bsg.core.action.Action;
import org.mwick.bsg.core.card.skill.SkillCheck;
import org.mwick.bsg.core.Pointcuts;

public class InvestigativeCommittee extends SkillCard {

	public InvestigativeCommittee(int value, int skill) {
		super(Action.Type.PASSIVE, value, skill);
	}

	public InvestigativeCommittee(InvestigativeCommittee old) {
		super(old);
	}

	@Override
	public InvestigativeCommittee copy() {
		return new InvestigativeCommittee(this);
	}
	
	@Override
	public boolean canAct(Board b) {
		return !Aspects.aspectOf(Effect.class, b).triggered;
	}

	@Override
	public void act(Board b) {
		Aspects.aspectOf(Effect.class, b).triggered = true;
	}
	
	public static aspect Prompt {
		
		before(Board b) : SkillCheck.Pointcuts.getCardsFromPlayers(b) {
			//TODO:[skill] prompt all users who have IC to use it
			
		}
		
	}
	
	public static aspect Effect perthis(Pointcuts.BoardOperation(Board)) {
		private boolean triggered = false;
		
		after(Board b) : SkillCheck.Pointcuts.getCardsFromPlayers(b) {
			triggered = false;
		}
	}

}
