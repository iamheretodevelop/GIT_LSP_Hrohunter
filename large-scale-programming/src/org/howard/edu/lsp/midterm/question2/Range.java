package org.howard.edu.lsp.midterm.question2;

/**
 * The Range interface represents a range of integers.
 */
public interface Range {
    
    /**
     * Gets the lower bound of the range.
     * 
     * @return The lower bound of the range.
     */
    public int getLowerBound();
    
    /**
     * Gets the upper bound of the range.
     * 
     * @return The upper bound of the range.
     */
    public int getUpperBound();
    
    /**
     * Checks if the range contains the specified value.
     * 
     * @param value The value to check.
     * @return true if the value is within the range, false otherwise.
     */
    public boolean contains(int value);
    
    /**
     * Checks if the range overlaps with another range.
     * 
     * @param other The other range to check for overlap.
     * @return true if there is at least one value in common, false otherwise.
     */
    public boolean overlaps(Range other);
    
    /**
     * Returns the number of integers in the range.
     * 
     * @return The size of the range.
     */
    public int size();
    
    /**
     * Compares this range to another object for equality.
     * 
     * @param obj The object to compare to.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj);
}