package org.mwick.bsg.core.card.destination;

import org.mwick.bsg.core.AbstractListManager;
import org.mwick.bsg.core.Board;
import org.mwick.bsg.core.Descriptor;
import org.mwick.bsg.core.Manager;
import org.mwick.bsg.core.card.ComplexDeck;
import org.mwick.bsg.core.card.Deck;

public class DestinationManager extends AbstractListManager<DestinationCard> {

	private static final long serialVersionUID = -4648328320050484035L;

	private int distance = 0;
	
	private Deck<Descriptor<DestinationCard>> deck;
	
	public DestinationManager() {
		super(DestinationCard.class);
		deck = new ComplexDeck<Descriptor<DestinationCard>>();
	}

	public DestinationManager(Board newBoard, DestinationManager old) {
		super(newBoard, old);
		deck = old.deck.copy();
	}
	
	protected void addToken(DestinationCard token) {
		deck.discard(getDescriptor(tokens.size()));
		tokens.add(token);
	}

	@Override
	public Manager<DestinationCard> copy(Board newBoard) {
		return new DestinationManager(newBoard, this);
	}

	public void addDistance(int distance) {
		this.distance += distance;
	}
	
	public int getDistance() {
		return distance;
	}

}
