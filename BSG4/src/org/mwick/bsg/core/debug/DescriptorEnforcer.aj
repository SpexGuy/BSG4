package org.mwick.bsg.core.debug;

import org.mwick.bsg.core.action.Action;
import org.mwick.bsg.core.Descriptor;
import org.mwick.bsg.core.Token;

public aspect DescriptorEnforcer {
	declare error :
		set(!final * Descriptor+.*) :
		"Descriptors may not have mutable state";
		
	declare error :
		set(Token<?>+ Action+.*) :
		"Actions may not contain direct references to Tokens. Use a Descriptor instead.";
}
