package org.howard.edu.lsp.assignment5;

/**
 * The IntegerSetException class represents an exception specific to the IntegerSet class.
 * It is thrown when an error occurs during operations on IntegerSet objects.
 */
public class IntegerSetException extends Exception {
    
    /**
     * Constructs a new IntegerSetException with the specified error message.
     * 
     * @param message The detail message of the exception.
     */
    public IntegerSetException(String message) {
        super(message);
    }
}