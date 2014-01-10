package org.mwick.bsg.core;

public interface Descriptor<T extends Token<T>> {
	public T get(Board b);
}
