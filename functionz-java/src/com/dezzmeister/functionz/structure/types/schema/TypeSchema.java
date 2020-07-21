package com.dezzmeister.functionz.structure.types.schema;

import com.dezzmeister.functionz.structure.Function;

/**
 * A type definition in the language. Implemented by native and custom type definitions.
 * 
 * @author Joe Desmond
 */
public interface TypeSchema {
	
	/**
	 * Returns the supertype of this type. Type definitions themselves can have different types;
	 * for instance, classes and primitives are different supertypes.
	 * 
	 * @return the supertype of this type
	 */
	public Supertype getSupertype();
	
	/**
	 * Returns the name of this type.
	 * 
	 * @return the name of this type
	 */
	public String getTypeName();
	
	/**
	 * The parent of this type, or null if this type does not have a parent.
	 * A type may not have a parent if it doesn't inherit from anything, or if it
	 * is a native type.
	 * 
	 * @return the parent of this type, or null if none exists
	 */
	public TypeSchema getParent();
	
	/**
	 * True if this type or any of its parents has a member with the given name and type.
	 * This method always returns null on primitive types.
	 * 
	 * @param memberName name of the member
	 * @param memberType type of the member
	 * @return true if this type or its parents contains a member with the given name and type
	 */
	public boolean hasMember(final String memberName, final TypeSchema memberType);
	
	/**
	 * If this type (or its parents) contains a function with the given name, that function will be returned.
	 * If not, this method will return null. This method always returns null on primitive types.
	 * 
	 * @param functionName name of the function
	 * @return The function, if it exists. Null if not
	 */
	public Function getFunction(final String functionName);
	
	/**
	 * Returns true if this type can be SAFELY cast to the given type. In some cases when this
	 * method returns false, an unsafe cast can still be performed.
	 * <p>
	 * Example: Two classes are defined, <code>Parent</code> and <code>Child</code>. <code>Child</code>
	 * is a subclass of <code>Parent</code>. A function expects an object of type <code>Parent</code>,
	 * and an object of type <code>Child</code> is passed in. Using the <code>is-a</code> operator,
	 * the function determines that the object is of type <code>Child</code>. In this case, an unsafe cast
	 * can be performed to cast the object from <code>Parent</code> to <code>Child</code>.
	 * 
	 * @param otherType the other type
	 * @return true if this type can be cast to the other one
	 */
	public boolean canBeCastTo(final TypeSchema otherType);
	
	@Override
	public boolean equals(final Object other);
	
	@Override
	public int hashCode();
}
