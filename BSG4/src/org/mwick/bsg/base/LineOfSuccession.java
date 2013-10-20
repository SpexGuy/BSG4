package org.mwick.bsg.base;

import java.util.List;

public abstract class LineOfSuccession implements Title.Line {

	protected List<Character> players;
	
	public LineOfSuccession(List<Character> players) {
		this.players = players;
	}
	
	@Override
	public Character getFirstCharacter() {
		return players.get(0);
	}

	@Override
	public Character getNextCharacter(Character current) {
		return players.get((players.indexOf(current) + 1) % players.size());
	}
}
