package org.howard.edu.lsp.assignment5;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class IntegerSetTest {

    private IntegerSet emptySet;
    private IntegerSet populatedSet;

    @BeforeEach
    public void setUp() {
        emptySet = new IntegerSet();
        populatedSet = new IntegerSet(new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9)));
    }

    @Test
    @DisplayName("Test case for clear")
    public void testClear() {
    	assertFalse(populatedSet.isEmpty());
        populatedSet.clear();
        assertTrue(populatedSet.isEmpty());
    }

    @Test
    @DisplayName("Test case for length")
    public void testLength() {
        assertEquals(0, emptySet.length());
        assertEquals(5, populatedSet.length());
        assertNotEquals(4, populatedSet.length());
    }

    @Test
    @DisplayName("Test case for equals")
    public void testEquals() {
        IntegerSet set1 = new IntegerSet(new ArrayList<>(Arrays.asList(1, 9, 5, 3, 7)));
        assertTrue(populatedSet.equals(set1));
        assertFalse(populatedSet.equals(emptySet));
    }

    @Test
    @DisplayName("Test case for contains")
    public void testContains() {
        assertTrue(populatedSet.contains(3));
        assertTrue(populatedSet.contains(5));
        assertFalse(populatedSet.contains(2));
    }

    @Test
    @DisplayName("Test case for largest")
    public void testLargest() throws IntegerSetException {
    	// Test standard largest
    	assertEquals(9, populatedSet.largest());
    	/**
    	 * Test exception handling
    	 */
        Throwable exception = assertThrows(IntegerSetException.class, () -> emptySet.largest());
        assertEquals("IntegerSet is empty.", exception.getMessage());
        assertDoesNotThrow(() -> populatedSet.largest());
    }

    @Test
    @DisplayName("Test case for smallest")
    public void testSmallest() throws IntegerSetException {
    	// Test standard smallest
    	assertEquals(1, populatedSet.smallest());
    	/**
    	 * Test exception handling
    	 */
    	Throwable exception = assertThrows(IntegerSetException.class, () -> emptySet.smallest());
        assertEquals("IntegerSet is empty.", exception.getMessage());
        assertDoesNotThrow(() -> populatedSet.smallest());
    }

    @Test
    @DisplayName("Test case for add")
    public void testAdd() {
    	assertFalse(emptySet.contains(2));
        emptySet.add(2);
        assertTrue(emptySet.contains(2));
        
        // Adding a duplicate element to populatedSet
        populatedSet.add(5);
        // Assert that size remains unchanged
        assertEquals(5, populatedSet.length());
    }

    @Test
    @DisplayName("Test case for remove")
    public void testRemove() {
    	assertTrue(populatedSet.contains(3));
    	populatedSet.remove(3);
        assertFalse(populatedSet.contains(3));
        
        // Removing a non-existent element from populatedSet
        assertEquals(4, populatedSet.length());
        populatedSet.remove(4);
        // Assert that size remains unchanged
        assertEquals(4, populatedSet.length());
    }

    @Test
    @DisplayName("Test case for union")
    public void testUnion() {
    	emptySet.add(2);
    	emptySet.add(3);
    	emptySet.add(9);
        emptySet.union(populatedSet);
        assertEquals(new ArrayList<>(Arrays.asList(2, 3, 9, 1, 5, 7)), emptySet.set);
    }

    @Test
    @DisplayName("Test case for intersect")
    public void testIntersect() {
    	emptySet.add(3);
    	emptySet.add(5);
    	emptySet.add(6);
        emptySet.intersect(populatedSet);
        assertEquals(new ArrayList<>(Arrays.asList(3, 5)), emptySet.set);
        
        // Testing when intersection is empty
        setUp();
        emptySet.intersect(populatedSet);
        assertTrue(emptySet.isEmpty());
    }

    @Test
    @DisplayName("Test case for diff")
    public void testDiff() {
        emptySet.add(3);
        populatedSet.diff(emptySet);
        assertEquals(new ArrayList<>(Arrays.asList(1, 5, 7, 9)), populatedSet.set);
        
        // Testing when two sets are the same
        setUp();
        IntegerSet newSet = new IntegerSet(new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9)));
        newSet.diff(populatedSet);
        assertTrue(newSet.isEmpty());
    }

    @Test
    @DisplayName("Test case for complement")
    public void testComplement() {
        emptySet.add(3);
        emptySet.add(4);
        emptySet.complement(populatedSet);
        assertEquals(new ArrayList<>(Arrays.asList(1, 5, 7, 9)), emptySet.set);
        
        setUp();
        emptySet.add(3);
        emptySet.add(4);
        emptySet.add(8);
        populatedSet.complement(emptySet);
        assertEquals(new ArrayList<>(Arrays.asList(4, 8)), populatedSet.set);
    }

    @Test
    @DisplayName("Test case for isEmpty")
    public void testIsEmpty() {
        assertTrue(emptySet.isEmpty());
        assertFalse(populatedSet.isEmpty());
    }

    @Test
    @DisplayName("Test case for toString")
    public void testToString() {
        assertEquals("[1, 3, 5, 7, 9]", populatedSet.toString());
    }
}