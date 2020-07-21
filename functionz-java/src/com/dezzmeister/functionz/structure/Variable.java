package com.dezzmeister.functionz.structure;

import com.dezzmeister.functionz.errors.CompilationError;

/**
 * A named variable. May or may not have a value.
 * 
 * @author Joe Desmond
 */
public class Variable extends Element {
	
	public final boolean isConst;

	protected Variable(final String _name, final Element _parent, final boolean _isConst) throws CompilationError {
		super(_name, _parent);
		isConst = _isConst;
	}

}
