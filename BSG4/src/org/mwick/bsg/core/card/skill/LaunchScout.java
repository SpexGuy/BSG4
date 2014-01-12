package org.mwick.bsg.core.card.skill;

import org.mwick.bsg.core.Board;
import org.mwick.bsg.core.action.AbstractAction;
import org.mwick.bsg.core.action.Action;
import org.mwick.bsg.core.action.Choice;

public class LaunchScout extends SkillCard {

	public LaunchScout(int value, int skill) {
		super(Action.Type.ACTION, value, skill);
	}

	public LaunchScout(LaunchScout old) {
		super(old);
	}

	@Override
	public LaunchScout copy() {
		return new LaunchScout(this);
	}

	@Override
	public void act(Board b) {
		//pick a deck
		new Choice(Action.Type.PASSIVE)
			.addAction(
				new AbstractAction(Action.Type.PASSIVE) {
					@Override
					public void act(Board b) {
						//TODO:[crisis] peek at crisis deck
					}
				})
			.addAction(
				new AbstractAction(Action.Type.PASSIVE) {
					@Override
					public void act(Board b) {
						//TODO:[distance] peek at distance deck
					}
				})
			.act(b);
	}

}
