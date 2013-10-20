package org.mwick.bsg.core;

public interface Deck<T> {
	
	public T draw() throws NoSuchTokenException;
	
	public void discard(T card);
	
	public void bury(T card);
	
	public int size();
	
	public void reshuffle();
	
}
