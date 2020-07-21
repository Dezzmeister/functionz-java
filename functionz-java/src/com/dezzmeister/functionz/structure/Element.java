package com.dezzmeister.functionz.structure;

import com.dezzmeister.functionz.errors.CompilationError;

/**
 * The parent of all code elements. An Element can be an individual component, or an abstract
 * syntax tree containing multiple components and representing some logical program structure.
 * 
 * Every Element has a name. Names are used to locate Elements in the syntax tree, as if the tree were
 * a filesystem. The Element class even defines a {@link #getPath()} method, which returns a
 * path to the calling element (delimited by forward slashes). 
 * 
 * @author Joe Desmond
 */
public abstract class Element {
	
	/**
	 * Simple name of this element
	 */
	public final String name;
	
	/**
	 * The parent element. If the parent is null, then this element is the root.
	 */
	private final Element parent;
	
	/**
	 * Constructs an element with the given name and parent element. Basic checks are performed to ensure that the name
	 * is valid.
	 * 
	 * @param _name element name
	 * @param _parent the parent element (can be null to indicate that this element is the root)
	 * @throws CompilationError if the name is invalid
	 */
	protected Element(final String _name, final Element _parent) throws CompilationError {
		ensureIsClean(_name);
		name = _name;
		parent = _parent;
	}
	
	/**
	 * Ensures that a given element name is valid. If the name is invalid, throws an exception
	 * with the reason why.
	 * 
	 * @param in element name
	 * @throws CompilationError if the name is invalid
	 */
	private final void ensureIsClean(final String in) throws CompilationError {
		if (in.contains("\\")) {
			throw new CompilationError("Backslashes are not allowed in names");
		}
		
		if (in.contains("/")) {
			throw new CompilationError("Forward slashes are not allowed in names");
		}
	}
	
	/**
	 * Returns the simple name of this Element. The simple name is a name given to this element upon
	 * construction.
	 * 
	 * @return name
	 */
	public String getSimpleName() {
		return name;
	}
	
	/**
	 * Returns the path to this element, from the root.
	 * 
	 * @return full path to this element
	 */
	public String getPath() {
		if (parent == null) {
			return "/" + name;
		}
		
		return parent.getPath() + "/" + name;
	}

	
	/**
	 * Returns the parent of this element in the tree. The parent can be null.
	 * 
	 * @return parent parent element
	 */
	public Element getParent() {
		return parent;
	}
}
