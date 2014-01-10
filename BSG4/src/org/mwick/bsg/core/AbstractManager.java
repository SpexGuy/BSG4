package org.mwick.bsg.core;

public abstract class AbstractManager<T> implements Manager<T> {

	private static final long serialVersionUID = -6628037143665533536L;
	
	protected transient Board board;
	
	public AbstractManager() {
		this(Board.current);
	}
	
	public AbstractManager(Board b) {
		this.board = b;
	}

}
