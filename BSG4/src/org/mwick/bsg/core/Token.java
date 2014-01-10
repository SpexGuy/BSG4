package org.mwick.bsg.core;

public interface Token<T extends Token<T>> {
	public T copy();
}
