package com.dezzmeister.functionz.errors;

/**
 * A compilation error; occurs when trying to build the abstract syntax tree. The parser can
 * call {@link #getFullErrorMessage(int)} with a line number to print a more specific error message.
 * 
 * @author Joe Desmond
 */
public class CompilationError extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4401798460652480926L;
	
	/**
	 * Error message
	 */
	private final String message;
	
	/**
	 * Constructs a compilation error with the given error message.
	 * 
	 * @param _message error message
	 */
	public CompilationError(final String _message) {
		super(_message);
		
		message = _message;
	}
	
	/**
	 * Returns this error message with a line number and file name. If <code>fileName</code> is null
	 * (for instance if this error message occured in a REPL), the filename string is omitted.
	 * 
	 * @param lineNumber line number at which this error occurred
	 * @param fileName file name in which this error occurred
	 * @return full error message
	 */
	public String getFullErrorMessage(final int lineNumber, final String fileName) {
		String out = "";
		if (fileName != null) {
			out += "Compilation error in \"" + fileName + "\":" + System.lineSeparator(); 
		}
		
		out += "Line " + lineNumber + ": \"" + message + "\"";
		
		return out;
	}
	
	/**
	 * Returns this error message with a line number. To include a file name, call {@link #getFullErrorMessage(int, String)}.
	 * 
	 * @param lineNumber line number at which this error occurred
	 * @return full error message
	 */
	public String getFullErrorMessage(final int lineNumber) {
		return getFullErrorMessage(lineNumber, null);
	}

}
