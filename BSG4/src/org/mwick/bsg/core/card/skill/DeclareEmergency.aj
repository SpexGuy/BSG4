package org.mwick.bsg.core.card.skill;

import java.util.List;

import org.mwick.bsg.core.Board;
import org.mwick.bsg.core.Descriptor;

public class DeclareEmergency extends SkillCard {

	public DeclareEmergency(int value, int skill) {
		super(Type.PASSIVE, value, skill);
	}

	public DeclareEmergency(SkillCard old) {
		super(old);
	}

	@Override
	public DeclareEmergency copy() {
		return new DeclareEmergency(this);
	}

	@Override
	public void act(Board b) {
		// TODO:[skill] reduce difficulty by 2
	}
	
	public static aspect Prompt {
		after(Board b, List<Descriptor<SkillCard>> cards) :
			SkillCheck.Pointcuts.tallyCards(b, cards) {
			//TODO:[skill] prompt all users who have DE to use it
		}
	}

}
