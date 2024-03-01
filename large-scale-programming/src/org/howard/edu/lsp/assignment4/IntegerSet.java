package org.howard.edu.lsp.assignment4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a set of integers and provides various operations on it.
 */
public class IntegerSet {

    // Store the set elements in an ArrayList
    private List<Integer> set;

    /**
     * Constructs an empty IntegerSet.
     */
    public IntegerSet() {
        set = new ArrayList<>();
    }

    /**
     * Constructs an IntegerSet from an existing ArrayList of integers.
     *
     * @param set An ArrayList of integers representing the initial set.
     */
    public IntegerSet(ArrayList<Integer> set) {
        this.set = set;
    }

    /**
     * Clears the internal representation of the set.
     */
    public void clear() {
        this.set.clear();
    }

    /**
     * Returns the length of the set.
     *
     * @return The number of elements in the set.
     */
    public int length() {
        return this.set.size();
    }

    /**
     * Checks if two sets are equal.
     *
     * @param o The object to compare.
     * @return True if the sets contain all the same values regardless of order, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof IntegerSet) {
            IntegerSet local = (IntegerSet) o;
            return local.set.containsAll(this.set) && this.set.containsAll(local.set);
        } else {
            return false;
        }
    }

    /**
     * Checks if the set contains a specified value.
     *
     * @param value The value to check for.
     * @return True if the value is in the set, false otherwise.
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Returns the largest item in the set.
     *
     * @return The largest integer in the set.
     * @throws IntegerSetException if the set is empty.
     */
    public int largest() throws IntegerSetException {
        if (set.isEmpty()) {
            throw new IntegerSetException("The IntegerSet is empty.");
        }
        return Collections.max(set);
    }

    /**
     * Returns the smallest item in the set.
     *
     * @return The smallest integer in the set.
     * @throws IntegerSetException if the set is empty.
     */
    public int smallest() throws IntegerSetException {
        if (set.isEmpty()) {
            throw new IntegerSetException("IntegerSet is empty");
        }
        return Collections.min(set);
    }

    /**
     * Adds an item to the set if it's not already present.
     *
     * @param item The integer to add to the set.
     */
    public void add(int item) {
        if (!this.set.contains(item)) {
            this.set.add(item);
        }
    }

    /**
     * Removes an item from the set if it exists.
     *
     * @param item The integer to remove from the set.
     */
    public void remove(int item) {
        if (this.set.contains(item)) {
            int index = this.set.indexOf(item);
            this.set.remove(index);
        }
    }

    /**
     * Performs the union of this set with another set.
     *
     * @param intSetb The other set to perform union with.
     */
    public void union(IntegerSet intSetb) {
        for (int i = 0; i < intSetb.set.size(); i++) {
            if (!this.set.contains(intSetb.set.get(i))) {
                this.set.add(intSetb.set.get(i));
            }
        }
    }

    /**
     * Performs the intersection of this set with another set.
     *
     * @param intSetb The other set to perform intersection with.
     */
    public void intersect(IntegerSet intSetb) {
        for (int i = this.set.size() - 1; i >= 0; i--) {
            if (!intSetb.contains(this.set.get(i))) {
                this.set.remove(i);
            }
        }
    }

    /**
     * Performs the set difference (s1 - s2) between this set and another set.
     *
     * @param intSetb The other set to perform difference with.
     */
    public void diff(IntegerSet intSetb) {
        for (int i = 0; i < this.set.size(); i++) {
            if (intSetb.contains(this.set.get(i))) {
                this.set.remove(i);
            }
        }
    }

    /**
     * Computes the complement of this set with respect to another set.
     *
     * @param intSetb The set to compute the complement with.
     */
    public void complement(IntegerSet intSetb) {
    	for(int i = intSetb.set.size()-1; i >=0; i--) {
    		int item = intSetb.set.get(i);
    		if(this.set.contains(item)){ 
    			intSetb.remove(item);
    		}
    	}
    	this.set.clear();
    	this.set.addAll(intSetb.set);
    }

    /**
     * Checks if the set is empty.
     *
     * @return True if the set is empty, false otherwise.
     */
    boolean isEmpty() {
        return this.set.isEmpty();
    }

    /**
     * Returns the string representation of the set.
     *
     * @return The string representation of the set.
     */
    @Override
    public String toString() {
        return this.set.toString();
    }
}