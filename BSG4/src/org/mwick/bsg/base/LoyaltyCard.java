package org.mwick.bsg.base;

import org.mwick.bsg.core.BoardDependency;
import org.mwick.bsg.core.Choice;

@BoardDependency
public abstract class LoyaltyCard {

	public abstract Choice getChoices();
}
