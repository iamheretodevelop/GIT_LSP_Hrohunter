package org.howard.edu.lsp.midterm.question2;

/**
 * The IntegerRange class represents a range of integers.
 */
public class IntegerRange implements Range {
    private int lowerBound;
    private int upperBound;
    
    /**
     * Constructs an IntegerRange with the specified lower and upper bounds.
     * 
     * @param lowerBound The lower bound of the range.
     * @param upperBound The upper bound of the range.
     */
    public IntegerRange(int lowerBound, int upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public int getLowerBound() {
        return this.lowerBound;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public int getUpperBound() {
        return this.upperBound;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean contains(int value) {
        return value >= this.lowerBound && value <= this.upperBound;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean overlaps(Range other) {
        return this.contains(other.getLowerBound()) || this.contains(other.getUpperBound());
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return Math.abs(upperBound - lowerBound) + 1;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
    	if (!(obj instanceof IntegerRange))
            return false;
    	if (this == obj)
            return true;
        IntegerRange other = (IntegerRange) obj;
        return this.lowerBound == other.lowerBound && this.upperBound == other.upperBound;
    }
}