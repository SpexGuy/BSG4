package org.mwick.bsg.base;

import java.util.Arrays;

import org.mwick.bsg.core.AbstractManager;
import org.mwick.bsg.core.Board;
import org.mwick.bsg.core.Manager;

public class BoardingParty extends AbstractManager<BoardingParty> {
	
	private static final long serialVersionUID = 769389019265749945L;
	
	protected int[] party;
	protected int availables;
	
	public BoardingParty(int size, int centurions) {
		super(Board.current);
		party = new int[size];
		//java zero-fills!
		availables = centurions;
	}
	private BoardingParty(Board board, BoardingParty old) {
		super(board);
		this.party = Arrays.copyOf(old.party, old.party.length);
		this.availables = old.availables;
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
		int roll = board.rollDie();
		if (roll >= 7) {
			//hit!
			destroyCenturion(space);
		}
	}
	
	protected void destroyCenturion(int space) {
		availables++;
		party[space]--;
	}

	@Override
	public Manager<BoardingParty> copy(Board newBoard) {
		return new BoardingParty(newBoard, this);
	}
}
