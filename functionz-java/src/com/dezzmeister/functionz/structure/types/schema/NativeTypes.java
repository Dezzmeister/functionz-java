package com.dezzmeister.functionz.structure.types.schema;

import java.util.List;

/**
 * A listing of all native Atiki types and their names.
 * 
 * @author Joe Desmond
 */
public final class NativeTypes {
	
	/**
	 * 4-byte signed integer primitive
	 */
	public static final String INT = "int";
	
	/**
	 * 4-byte signed floating point primitive
	 */
	public static final String FLOAT = "float";
	
	/**
	 * 8-byte signed integer primitive
	 */
	public static final String LONG = "long";
	
	/**
	 * 8-byte signed floating point primitive
	 */
	public static final String DOUBLE = "double";
	
	/**
	 * 2-byte unsigned integer primitive
	 */
	public static final String CHAR = "char";
	
	/**
	 * Boolean primitive
	 */
	public static final String BOOLEAN = "boolean";
	
	/**
	 * A list of reserved type names
	 */
	public static final List<String> RESERVED_TYPENAMES = List.of(INT, FLOAT, LONG, DOUBLE, BOOLEAN);

}
