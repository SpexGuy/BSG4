package org.mwick.bsg.core.card;

import java.util.LinkedList;
import java.util.List;

import org.mwick.bsg.core.Descriptor;
import org.mwick.bsg.core.NoSuchTokenException;

public class SimpleDeck<T extends Descriptor<?>> implements Deck<T> {

	private List<T> cards;
	
	public SimpleDeck() {
		cards = new LinkedList<T>();
	}
	
	protected SimpleDeck(SimpleDeck<T> old) {
		cards = new LinkedList<T>(old.cards);
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

	@Override
	public Deck<T> copy() {
		return new SimpleDeck<T>(this);
	}
	
}
