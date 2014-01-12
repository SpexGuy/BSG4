package org.mwick.bsg.core.card;

import java.util.LinkedList;
import java.util.List;

public class Hand<T> {
	
	private List<T> cards;
	
	public Hand() {
		cards = new LinkedList<T>();
	}
	
	public T get(int index) {
		return cards.get(index);
	}
	
	public T remove(int index) {
		return cards.remove(index);
	}
	
	public void add(T card) {
		cards.add(card);
	}
	
	public int size() {
		return cards.size();
	}
}
