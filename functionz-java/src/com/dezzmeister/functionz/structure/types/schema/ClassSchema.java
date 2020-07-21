package com.dezzmeister.functionz.structure.types.schema;

import java.util.HashMap;
import java.util.Objects;

import com.dezzmeister.functionz.errors.CompilationError;
import com.dezzmeister.functionz.structure.Function;

/**
 * A custom class definition. A class can contain custom fields and functions. 
 * 
 * @author Joe Desmond
 */
public class ClassSchema implements TypeSchema {
	
	/**
	 * The name of this type
	 */
	public final String typeName;
	
	/**
	 * The parent type, or null if this type has no parent. This type inherits all properties from the parent.
	 */
	public final ClassSchema parent;
	
	/**
	 * The fields in this custom type. Names are mapped to their types.
	 */
	public final HashMap<String, TypeSchema> fields;
	
	/**
	 * The functions of this custom type. Names are mapped to function definitions. 
	 * These functions have an implicit object parameter, into which an object of this type is passed.
	 */
	public final HashMap<String, Function> functions;
	
	/**
	 * Constructs a class definition with the given name, parent, fields, and functions.
	 * 
	 * @param _typeName class name
	 * @param _parent parent class (null if this class does not inherit from anything)
	 * @param _fields data fields
	 * @param _functions member functions
	 * @throws CompilationError 
	 */
	public ClassSchema(final String _typeName, final ClassSchema _parent, final HashMap<String, TypeSchema> _fields, final HashMap<String, Function> _functions) throws CompilationError {
		typeName = _typeName;
		parent = _parent;
		fields = _fields;
		functions = _functions;
	}

	@Override
	public Supertype getSupertype() {
		return Supertype.CLASS;
	}

	@Override
	public String getTypeName() {
		return typeName;
	}

	@Override
	public TypeSchema getParent() {
		return parent;
	}

	@Override
	public boolean hasMember(final String memberName, final TypeSchema memberType) {
		if (fields.containsKey(memberName)) {
			return true;
		}
		
		return (parent != null && parent.hasMember(memberName, memberType));
	}

	@Override
	public Function getFunction(final String functionName) {
		final Function function = functions.get(functionName);
		
		if (function != null) {
			return function;
		}
		
		if (parent != null) {
			return parent.getFunction(functionName);
		}
		
		return null;
	}

	@Override
	public boolean canBeCastTo(final TypeSchema otherType) {
		if (this.equals(otherType)) {
			return true;
		}
		
		if (parent == null) {
			return false;
		}
		
		return parent.canBeCastTo(otherType);
	}
	
	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof ClassSchema)) {
			return false;
		}
		
		final ClassSchema otherClass = (ClassSchema) other;
		
		return (
				typeName.equals(otherClass.typeName) &&
				parent.equals(otherClass.parent) &&
				fields.equals(otherClass.fields) &&
				functions.equals(otherClass.functions)
			   );
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(typeName, parent, fields, functions);
	}
}
