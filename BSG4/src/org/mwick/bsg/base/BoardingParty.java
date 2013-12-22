package org.mwick.bsg.base;

import org.mwick.bsg.core.BoardDependency;
import org.mwick.bsg.core.RollManager;

@BoardDependency
public class BoardingParty {
	protected int[] party;
	protected int availables;
	public BoardingParty(int size, int centurions) {
		party = new int[size];
		//java zero-fills!
		availables = centurions;
	}
	
	public void advance() {
		if (party[party.length-1] != 0)
			;//TODO:[win] cylons win
		for (int c = party.length-1; c > 0; c--)
			party[c] = party[c-1];
		party[0] = 0;
	}
	
	public void addCenturion() {
		if (availables > 0) {
			availables--;
			party[0]++;
		}
	}
	
	public void attackCenturion(int space) {
		assert(party[space] > 0);
		int roll = ((RollManager)getBoard().getTokenManager(RollManager.class)).rollDie();
		if (roll >= 7) {
			//hit!
			destroyCenturion(space);
		}
	}
	
	protected void destroyCenturion(int space) {
		availables++;
		party[space]--;
	}
}
