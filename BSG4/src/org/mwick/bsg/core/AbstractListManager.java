package org.mwick.bsg.core;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractListManager<T extends Token<T>> extends AbstractManager<T> {

	private static final long serialVersionUID = 6381731224266479928L;

	protected List<T> tokens;
	
	private final Class<T> tokenType;
	
	public AbstractListManager(Class<T> tokenType) {
		tokens = new ArrayList<T>();
		this.tokenType = tokenType;
	}
	
	protected AbstractListManager(Board b, AbstractListManager<T> old) {
		super(b);
		this.tokens = new ArrayList<T>(old.tokens.size());
		this.tokenType = old.tokenType;
		for (T token : tokens) {
			this.tokens.add(token.copy());
		}
	}

	public T fetch(Descriptor<T> ref) {
		assert(ref instanceof ListDescriptor<?>);
		return tokens.get(((ListDescriptor<T>)ref).getIndex());
	}
	
	protected Descriptor<T> getDescriptor(int index) {
		return new ListDescriptor<T>(tokenType, index);
	}
	
	protected static <T extends Token<T>> Descriptor<T> getDescriptor(Class<T> tokenType, int index) {
		return new ListDescriptor<T>(tokenType, index);
	}

	private static class ListDescriptor<T extends Token<T>> implements Descriptor<T> {
		private final int index;
		private final Class<T> tokenType;
		
		public ListDescriptor(Class<T> type, int index) {
			this.index = index;
			this.tokenType = type;
		}
		
		public int getIndex() {
			return index;
		}

		@Override
		public T get(Board b) {
			return ((AbstractListManager<T>)b.getManager(tokenType)).fetch(this);
		}
	}
	
}
