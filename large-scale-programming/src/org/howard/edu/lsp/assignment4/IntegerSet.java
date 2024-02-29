package org.howard.edu.lsp.assignment4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntegerSet {

	// Store the set elements in an ArrayList
	private List<Integer> set;

	// Default Constructor
	public IntegerSet() {
		set = new ArrayList<Integer>();
	}

	// Constructor if you want to pass in already initialized
	public IntegerSet(ArrayList<Integer> set) {
		this.set = set;
	}

	// Clears the internal representation of the set
	public void clear() {
		this.set.clear();
	}
	
	// Returns the length of the set
	public int length() {
		return this.set.size();
	}
	
	/*
	 * Returns true if the 2 sets are equal, false otherwise;
	 * Two sets are equal if they contain all of the same values in ANY order.  This overrides
	 * the equal method from the Object class.
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof IntegerSet) {
			IntegerSet local = (IntegerSet)o;
			return local.set.containsAll(this.set) && this.set.containsAll(local.set);
		}
		else {
			return false;
		}
	}
		
	
	// Returns true if the set contains the value, otherwise false
	public boolean contains(int value) {
		return set.contains(value);
	}   
	
	// Returns the largest item in the set; Throws a IntegerSetException if the set is empty 
	public int largest() throws IntegerSetException {
		if (set.isEmpty()){
			throw new IntegerSetException("IntegerSet is empty");
		}
		return Collections.max(set);
	}
	
	// Returns the smallest item in the set; Throws a IntegerSetException if the set is empty
	public int smallest() throws IntegerSetException {
		if (set.isEmpty()){
			throw new IntegerSetException("IntegerSet is empty");
		}
		return Collections.min(set);
	}
	 
	// Adds an item to the set or does nothing if it is already there	
 	public void add(int item) {
 		if (!(this.set.contains(item))) {
 			this.set.add(item);
 		}
 	} 
	
	// Removes an item from the set or does nothing if not there
	public void remove(int item) {
		if ((this.set.contains(item))) {
			int index = this.set.indexOf(item);
 			this.set.remove(index);
 		}
	}
	
	// Set union
	public void union(IntegerSet intSetb) {
		
	}
	
	// Set intersection, all elements in s1 and s2
	public void intersect(IntegerSet intSetb) {
		
	}
	
	// Set difference, i.e., s1 –s2
	public void diff(IntegerSet intSetb) {
		
	} // set difference, i.e. s1 - s2
	
	// Set complement, all elements not in s1
	public void complement(IntegerSet intSetb) {
		
	}
	
	// Returns true if the set is empty, false otherwise
	boolean isEmpty() {
		return this.set.isEmpty();
	} 
	
	// Return String representation of your set.  This overrides the equal method from
	// the Object class.
	public String toString() {
		return this.set.toString();
	}
}
