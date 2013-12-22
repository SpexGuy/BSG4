package org.mwick.bsg.base;

import org.mwick.bsg.core.BoardDependency;
import org.mwick.bsg.core.Resource;
import org.mwick.bsg.core.ResourceManager;

@BoardDependency
public class JumpTrack {
	int position = 0;
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
		if (position == 3) {
			if (/* TODO:[roll] */ 0 < 7)
				((ResourceManager)getBoard().getTokenManager(Resource.class)).getResource(BaseResourceManager.POPULATION).addAmount(-3);
		} else if (position == 4) {
			if (/* TODO:[roll] */ 0 < 7)
				((ResourceManager)getBoard().getTokenManager(Resource.class)).getResource(BaseResourceManager.POPULATION).addAmount(-1);
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
