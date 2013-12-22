package org.mwick.bsg.base;

import org.mwick.bsg.core.BoardDependency;
import org.mwick.bsg.core.Resource;
import org.mwick.bsg.core.ResourceManager;
import org.mwick.bsg.core.RollManager;

@BoardDependency
public class JumpTrack {
	
	protected int position = 0;
	
	public void advance() {
		position++;
		if (position > 4)
			jump();
	}
	
	public void decrement() {
		position--;
		if (position < 0)
			position = 0;
	}
	
	public void forceJump() {
		assert(position >= 3);
		int roll = ((RollManager)getBoard().getTokenManager(RollManager.class)).rollDie();
		Resource pop = ((ResourceManager)getBoard().getTokenManager(Resource.class)).getResource(BaseResourceManager.POPULATION);
		if (position == 3) {
			if (roll < 7)
				pop.addAmount(-3);
		} else if (position == 4) {
			if (roll < 7)
				pop.addAmount(-1);
		} else {
			System.err.println("forceJump called but position > 4 ?!");
		}
		jump();
	}
	protected void jump() {
		position = 0;
		//TODO:[destination] select destination cards
	}
}
