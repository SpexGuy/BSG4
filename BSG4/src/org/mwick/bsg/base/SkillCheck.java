package org.mwick.bsg.base;

import java.util.ArrayList;
import java.util.List;

import org.mwick.bsg.core.Board;
import org.mwick.bsg.core.action.AbstractAction;
import org.mwick.bsg.core.action.Action;

public class SkillCheck extends AbstractAction {
	public interface Evaluator {
		public int getCardValue(SkillCard card);
	}
	
	private Evaluator eval;
	private Action[] actions;
	private int[] values;
	
	public SkillCheck(Action pass, Action fail, int pivot, Evaluator eval) {
		super(Action.Type.PASSIVE);
		assert(pass.getType() == Action.Type.PASSIVE);
		assert(fail.getType() == Action.Type.PASSIVE);
		this.eval = eval;
		this.actions = new Action[] {pass, fail};
		this.values = new int[] {pivot};
	}

	public SkillCheck(Action pass, Action mid, Action fail, int passThresh, int midThresh, Evaluator eval) {
		super(Action.Type.PASSIVE);
		assert(pass.getType() == Action.Type.PASSIVE);
		assert( mid.getType() == Action.Type.PASSIVE);
		assert(fail.getType() == Action.Type.PASSIVE);
		this.eval = eval;
		this.actions = new Action[] {pass, mid, fail};
		this.values = new int[] {passThresh, midThresh};
	}

	@Override
	public boolean canAct(Board b) {
		for (int c = 0; c < actions.length; c++) {
			if (!actions[c].canAct(b)) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public void act(Board b) {
		List<SkillCard> cards = new ArrayList<SkillCard>();
		
		//TODO:[skill] prompt users for cards
		
		int total = 0;
		for (SkillCard c : cards) {
			total += eval.getCardValue(c);
		}
		int index;
		for (index = 0; index < values.length && values[index] > total; index++)
			; //iterate through the thresholds until the check passes.
		assert(actions[index].canAct(b));
		actions[index].act(b);
	}
}
