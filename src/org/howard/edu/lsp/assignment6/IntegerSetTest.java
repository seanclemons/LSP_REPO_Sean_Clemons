package org.howard.edu.lsp.assignment6;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.howard.edu.lsp.assignment5.IntegerSet;

public class IntegerSetTest {
    
    private IntegerSet set1;
    private IntegerSet set2;
    
    @Before
    public void setUp() {
        // Initialize sets before each test
        set1 = new IntegerSet();
        set2 = new IntegerSet();
    }
    
    @Test
    public void testAdd() {
        // Test adding to empty set
        set1.add(1);
        assertTrue(set1.contains(1));
        assertEquals(1, set1.length());
        
        set1.add(1);
        assertEquals(1, set1.length());
        
        set1.add(2);
        set1.add(3);
        assertEquals(3, set1.length());
        assertTrue(set1.contains(2));
        assertTrue(set1.contains(3));
    }

    @Test
    public void testClear() {
        // Add elements and then clear
        set1.add(1);
        set1.add(2);
        set1.add(3);
        assertFalse(set1.isEmpty());
        
        set1.clear();
        assertTrue(set1.isEmpty());
        assertEquals(0, set1.length());
    }

    @Test
    public void testComplement() {
        // Set up the sets
        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(4);
        set2.add(5);
        
        set1.add(2);
        set1.add(4);
        
        set1.complement(set2);
        
        assertEquals(5, set1.length());
        assertTrue(set1.contains(1));
        assertTrue(set1.contains(2));
        assertTrue(set1.contains(3));
        assertTrue(set1.contains(4));
        assertTrue(set1.contains(5));
    }

    @Test
    public void testContains() {
        // Test empty set
        assertFalse(set1.contains(1));
        
        set1.add(1);
        set1.add(2);
        set1.add(3);
        
        assertTrue(set1.contains(1));
        assertTrue(set1.contains(2));
        assertTrue(set1.contains(3));
        assertFalse(set1.contains(4));
        
        set1.remove(2);
        assertFalse(set1.contains(2));
    }

    @Test
    public void testDiff() {
        // Set up initial sets
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        
        set2.add(3);
        set2.add(4);
        set2.add(5);
        
        set1.diff(set2);
        
        assertEquals(2, set1.length());
        assertTrue(set1.contains(1));
        assertTrue(set1.contains(2));
        assertFalse(set1.contains(3));
        assertFalse(set1.contains(4));
        assertFalse(set1.contains(5));
    }

    @Test
public void testEquals() {
    // Two empty sets should be equal
    assertTrue("Empty sets should be equal", set1.isEmpty() && set2.isEmpty());
    
    set1.add(1);
    set1.add(2);
    set1.add(3);
    
    set2.add(1);
    set2.add(2);
    set2.add(3);
    
    assertEquals("Sets should have the same length", set1.length(), set2.length());
    assertTrue("Set1 should contain all elements of set2", set1.contains(1) && set1.contains(2) && set1.contains(3));
    assertTrue("Set2 should contain all elements of set1", set2.contains(1) && set2.contains(2) && set2.contains(3));
    
    set2.clear();
    set2.add(3);
    set2.add(1);
    set2.add(2);
    
    assertEquals("Sets should have the same length", set1.length(), set2.length());
    assertTrue("Set1 should contain all elements of set2", set1.contains(1) && set1.contains(2) && set1.contains(3));
    assertTrue("Set2 should contain all elements of set1", set2.contains(1) && set2.contains(2) && set2.contains(3));
    
    set2.clear();
    set2.add(1);
    set2.add(2);
    set2.add(4);
    
    assertFalse("Sets should not be equal",
               set1.length() == set2.length() && 
               set1.contains(1) && set1.contains(2) && set1.contains(4) &&
               set2.contains(1) && set2.contains(2) && set2.contains(3));
}

    @Test
    public void testIntersect() {
        // Set up initial sets with overlap
        set1.add(1);
        set1.add(2);
        set1.add(3);
        
        set2.add(2);
        set2.add(3);
        set2.add(4);
        
        set1.intersect(set2);
        
        // Check result
        assertEquals(2, set1.length());
        assertFalse(set1.contains(1));
        assertTrue(set1.contains(2));
        assertTrue(set1.contains(3));
        assertFalse(set1.contains(4));
    }

    @Test
    public void testIsEmpty() {
        assertTrue(set1.isEmpty());
        
        set1.add(1);
        assertFalse(set1.isEmpty());
        
        set1.clear();
        assertTrue(set1.isEmpty());
        
        set1.add(1);
        set1.remove(1);
        assertTrue(set1.isEmpty());
    }

    @Test
    public void testLargest() {
        // Test with elements
        set1.add(5);
        set1.add(10);
        set1.add(3);
        
        assertEquals(10, set1.largest());
        
        // Test with negative numbers
        set1.clear();
        set1.add(-5);
        set1.add(-3);
        set1.add(-10);
        
        assertEquals(-3, set1.largest());
    }
    
    @Test(expected = IllegalStateException.class)
    public void testLargestWithEmptySet() {
        // This should throw an IllegalStateException
        set1.largest();
    }

    @Test
    public void testLength() {
        // Test empty set
        assertEquals(0, set1.length());
        
        // Test with elements
        set1.add(1);
        assertEquals(1, set1.length());
        
        set1.add(2);
        set1.add(3);
        assertEquals(3, set1.length());
        
        // Test duplicate addition doesn't increase length
        set1.add(2);
        assertEquals(3, set1.length());
        
        // Test after removal
        set1.remove(1);
        assertEquals(2, set1.length());
    }

    @Test
    public void testRemove() {
        // Add elements
        set1.add(1);
        set1.add(2);
        set1.add(3);
        
        // Test removing existing element
        set1.remove(2);
        assertFalse(set1.contains(2));
        assertEquals(2, set1.length());
        
        // Test removing non-existing element
        set1.remove(4);
        assertEquals(2, set1.length());
        
        // Test removing from empty set
        set2.remove(1);
        assertTrue(set2.isEmpty());
    }

    @Test
    public void testSmallest() {
        // Test with elements
        set1.add(5);
        set1.add(10);
        set1.add(3);
        
        assertEquals(3, set1.smallest());
        
        // Test with negative numbers
        set1.clear();
        set1.add(-5);
        set1.add(-3);
        set1.add(-10);
        
        assertEquals(-10, set1.smallest());
    }
    
    @Test(expected = IllegalStateException.class)
    public void testSmallestWithEmptySet() {
        // This should throw an IllegalStateException
        set1.smallest();
    }

    @Test
    public void testToString() {
        // Test empty set
        assertEquals("[]", set1.toString());
        
        // Test with one element
        set1.add(1);
        assertEquals("[1]", set1.toString());
        
        // Test with multiple elements
        set1.add(2);
        set1.add(3);
        
        // The output will depend on the set implementation
        String result = set1.toString();
        assertTrue(result.contains("1"));
        assertTrue(result.contains("2"));
        assertTrue(result.contains("3"));
    }

    @Test
    public void testUnion() {
        // Set up initial sets
        set1.add(1);
        set1.add(2);
        set1.add(3);
        
        set2.add(3);
        set2.add(4);
        set2.add(5);
        
        // Perform union
        set1.union(set2);
        
        // Check result
        assertEquals(5, set1.length());
        assertTrue(set1.contains(1));
        assertTrue(set1.contains(2));
        assertTrue(set1.contains(3));
        assertTrue(set1.contains(4));
        assertTrue(set1.contains(5));
    }
}