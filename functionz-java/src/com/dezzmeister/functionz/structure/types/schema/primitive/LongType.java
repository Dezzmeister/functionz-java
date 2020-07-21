package com.dezzmeister.functionz.structure.types.schema.primitive;

import com.dezzmeister.functionz.structure.Function;
import com.dezzmeister.functionz.structure.types.schema.NativeTypes;
import com.dezzmeister.functionz.structure.types.schema.Supertype;
import com.dezzmeister.functionz.structure.types.schema.TypeSchema;

/**
 * Type definition for the long primitive.
 * 
 * @author Joe Desmond
 */
public class LongType implements TypeSchema {

	@Override
	public Supertype getSupertype() {
		return Supertype.PRIMITIVE;
	}

	@Override
	public String getTypeName() {
		return NativeTypes.LONG;
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
			case NativeTypes.FLOAT:
			case NativeTypes.DOUBLE:
			case NativeTypes.INT:
			case NativeTypes.LONG: {
				return true;
			}
			default: {
				return false;
			}
		}
	}

}
