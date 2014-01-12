package org.mwick.bsg.core.card.destination;

import org.mwick.bsg.core.AbstractManager;
import org.mwick.bsg.core.Board;
import org.mwick.bsg.core.Manager;
import org.mwick.bsg.core.resource.BaseResourceManager;
import org.mwick.bsg.core.resource.Resource;

public class JumpTrack extends AbstractManager<JumpTrack> {
	
	private static final long serialVersionUID = -5606120866842131601L;
	
	protected int position = 0;
	
	public JumpTrack() {
		super(Board.current);
	}
	private JumpTrack(Board b, JumpTrack old) {
		super(b);
		this.position = old.position;
	}
	
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
		int roll = board.rollDie();
		Resource pop = BaseResourceManager.POPULATION.get(board);
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

	@Override
	public Manager<JumpTrack> copy(Board newBoard) {
		return new JumpTrack(newBoard, this);
	}
}
