package org.mwick.bsg.core;

public class UnanimousSequence extends Sequence {

	public UnanimousSequence(Action.Type type) {
		super(type);
	}

	@Override
	public boolean canAct() {
		for (Action a : actions) {
			if (!a.canAct()) {
				return false;
			}
		}
		return true;
	}

}
