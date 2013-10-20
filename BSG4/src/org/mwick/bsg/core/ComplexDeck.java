package org.mwick.bsg.core;

import java.util.LinkedList;
import java.util.List;

public class ComplexDeck<T> implements Deck<T> {
	private Deck<T> discard;
	private List<T> cards;
	
	public ComplexDeck() {
		cards = new LinkedList<T>();
		discard = new SimpleDeck<T>();
	}

	@Override
	public T draw() throws NoSuchTokenException {
		if (cards.size() == 0)
			if (discard.size() == 0)
				throw new NoSuchTokenException("No more cards");
			reshuffle();
		return cards.remove(0);
	}

	@Override
	public void discard(T card) {
		discard.discard(card);
	}

	@Override
	public void bury(T card) {
		cards.add(card);
	}

	@Override
	/**
	 * dump all cards into the discard, shuffle it, and then transfer them to the <code>cards</code> list
	 */
	public void reshuffle() {
		try {
			while(cards.size() > 0)
				discard.discard(cards.remove(0));
			discard.reshuffle();
			while(discard.size() > 0) {
				bury(discard.draw());
			}
		} catch(Exception e) {
			System.err.println("Something impossible has happened. Possibly due to synchronization issues?");
			assert(false);
		}
	}
	
	@Override
	public int size() {
		return cards.size() + discard.size();
	}

}
