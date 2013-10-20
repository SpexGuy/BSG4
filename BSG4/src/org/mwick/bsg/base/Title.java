package org.mwick.bsg.base;

import org.mwick.bsg.core.Choice;

public abstract class Title {

	public static interface Line {
		public Character getFirstCharacter();
		public Character getNextCharacter(Character current);
	}
	
	private Character current;
	private Line chainOfCommand;
	
	public Title(Line succession) {
		chainOfCommand = succession;
		current = succession.getFirstCharacter();
		current.addTitle(this);
	}
	
	public abstract Choice getChoices();
	
	/**
	 * returns whether the given character is eligible for the title.
	 * For example, Someone in the brig is ineligible for the Admiral title.
	 * @param c the candidate for the title
	 * @return whether the candidate is eligible
	 */
	protected abstract boolean isEligible(Character candidate);
	
	/**
	 * assigns the title to the next person in the line of succession
	 */
	public void reassign() {
		Character candidate = current;
		
		do {
			candidate = chainOfCommand.getNextCharacter(candidate);
		} while(!isEligible(candidate) && current != candidate);
		
		if (current == candidate) {
			candidate = chainOfCommand.getNextCharacter(candidate);
		}
		
		assign(candidate);
	}
	
	/**
	 * directly assigns the title to the given character, regardless
	 * of where that character is in the line of succession and whether the
	 * character is currently eligible.
	 * @param elect the recipient of the title
	 */
	public void assign(Character elect) {
		current.removeTitle(this);
		elect.addTitle(this);
		current = elect;
	}
}
