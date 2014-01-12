package org.mwick.bsg.core.card.skill;

import java.util.ArrayList;
import java.util.List;

import org.mwick.bsg.core.AbstractListManager;
import org.mwick.bsg.core.Board;
import org.mwick.bsg.core.Descriptor;
import org.mwick.bsg.core.card.Deck;

public abstract class SkillCardManager extends AbstractListManager<SkillCard> {

	private static final long serialVersionUID = 2851498917431671195L;
	
	private List<Deck<Descriptor<SkillCard>>> decks;

	public SkillCardManager() {
		super(SkillCard.class);
		decks = new ArrayList<Deck<Descriptor<SkillCard>>>();
	}
	
	protected void addCard(SkillCard card) {
		int skill = card.getSkill();
		for (int c = decks.size(); c <= skill; c++) {
			decks.add(newSkillDeck(c));
		}
		decks.get(skill).discard(getDescriptor(tokens.size()));
		tokens.add(card);
	}
	
	protected abstract Deck<Descriptor<SkillCard>> newSkillDeck(int index);
	
	protected SkillCardManager(Board b, SkillCardManager old) {
		super(b, old);
		decks = new ArrayList<Deck<Descriptor<SkillCard>>>(old.decks.size());
		for (Deck<Descriptor<SkillCard>> deck : old.decks) {
			decks.add(deck.copy());
		}
	}

	public Deck<Descriptor<SkillCard>> chooseDeck() {
		// TODO:[skill] choose deck
		throw new UnsupportedOperationException("chooseDeck not implemented yet");
	}
}
