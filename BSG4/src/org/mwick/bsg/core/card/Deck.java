package org.mwick.bsg.core.card;

import org.mwick.bsg.core.Descriptor;
import org.mwick.bsg.core.NoSuchTokenException;

public interface Deck<T extends Descriptor<?>> {
	
	public T draw() throws NoSuchTokenException;
	
	public void discard(T card);
	
	public void bury(T card);
	
	public int size();
	
	public void reshuffle();

	public Deck<T> copy();
	
}
