package org.mwick.bsg.core.card;

import java.util.LinkedList;
import java.util.List;

import org.mwick.bsg.core.Descriptor;
import org.mwick.bsg.core.NoSuchTokenException;

public class ComplexDeck<T extends Descriptor<?>> implements Deck<T> {
	private Deck<T> discard;
	private List<T> cards;
	
	public ComplexDeck() {
		cards = new LinkedList<T>();
		discard = new SimpleDeck<T>();
	}
	
	protected ComplexDeck(ComplexDeck<T> old) {
		cards = new LinkedList<T>(old.cards);
		discard = old.discard.copy();
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

	/**
	 * dump all cards into the discard, shuffle it, and then transfer them to the <code>cards</code> list
	 */
	@Override
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

	@Override
	public Deck<T> copy() {
		return new ComplexDeck<T>(this);
	}

}
