package org.mwick.bsg.core;

import java.util.LinkedList;
import java.util.List;

public class SimpleDeck<T> implements Deck<T> {

	private List<T> cards;
	
	public SimpleDeck() {
		cards = new LinkedList<T>();
	}

	@Override
	public T draw() throws NoSuchTokenException {
		if (cards.size() == 0)
			throw new NoSuchTokenException("No more cards");
		return cards.remove((int) (Math.random() * cards.size()));
	}

	@Override
	public void discard(T card) {
		cards.add(card);
	}

	@Override
	public void bury(T card) {
		discard(card);
	}

	@Override
	public void reshuffle() {
		//SimpleDeck shuffles in O(1)!
	}
	
	@Override
	public int size() {
		return cards.size();
	}
	
}
