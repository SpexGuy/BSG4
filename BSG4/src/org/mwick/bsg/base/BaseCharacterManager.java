package org.mwick.bsg.base;

import org.mwick.bsg.core.AbstractListManager;
import org.mwick.bsg.core.Board;
import org.mwick.bsg.core.Manager;


public class BaseCharacterManager extends AbstractListManager<Character> {

	private static final long serialVersionUID = 3121910404207281784L;

	public BaseCharacterManager() {
		super(Character.class);
	}

	protected BaseCharacterManager(Board b, AbstractListManager<Character> old) {
		super(b, old);
	}

	@Override
	public Manager<Character> copy(Board newBoard) {
		return new BaseCharacterManager(newBoard, this);
	}
}
