package org.mwick.bsg.core;

public aspect BoardInjector {

	pointcut needsBoard() : execution((@BoardDependency Object+).new(..));
	
	declare parents : (@BoardDependency Object+) implements BoardHolder;
	
	private static Board board = null;
	
	public static interface BoardHolder {
		public Board getBoard();
	}
	
	public Board BoardHolder.getBoard() {
		return board;
	}
	
	after(Board b) : execution(Board+.new(..)) && this(b) {
		if (board != null) {
			System.err.println("Multiple boards are being created!");
		}
		board = b;
	}
	
}
