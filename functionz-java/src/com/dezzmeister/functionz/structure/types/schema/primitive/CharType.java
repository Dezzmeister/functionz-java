package com.dezzmeister.functionz.structure.types.schema.primitive;

import com.dezzmeister.functionz.structure.Function;
import com.dezzmeister.functionz.structure.types.schema.NativeTypes;
import com.dezzmeister.functionz.structure.types.schema.Supertype;
import com.dezzmeister.functionz.structure.types.schema.TypeSchema;

/**
 * Type definition for the char primitive.
 * 
 * @author Joe Desmond
 */
public class CharType implements TypeSchema {

	@Override
	public Supertype getSupertype() {
		return Supertype.PRIMITIVE;
	}

	@Override
	public String getTypeName() {
		return NativeTypes.CHAR;
	}

	@Override
	public TypeSchema getParent() {
		return null;
	}

	@Override
	public boolean hasMember(final String memberName, final TypeSchema memberType) {
		return false;
	}

	@Override
	public Function getFunction(final String functionName) {
		return null;
	}

	@Override
	public boolean canBeCastTo(final TypeSchema otherType) {
		switch (otherType.getTypeName()) {
			case NativeTypes.LONG:
			case NativeTypes.INT:
			case NativeTypes.CHAR: {
				return true;
			}
			default: {
				return false;
			}
		}
	}

}
