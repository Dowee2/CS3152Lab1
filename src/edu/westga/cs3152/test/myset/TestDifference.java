package edu.westga.cs3152.test.myset;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.cs3152.sets.MySet;

public class TestDifference {
    
    @Test
    public void testDifferenceOfSingleElementSetsSimilar() {
        MySet<String> set1 = new MySet<String>();
        MySet<String> set2 = new MySet<String>();

        set1.add("A");
        set2.add("A");

        assertEquals("", set1.difference(set2).toString());
        assertTrue(0 == set1.difference(set2).size());
    }

    @Test
    public void testDifferenceOfSingleElementSetsNotSimilar() {
        MySet<String> set1 = new MySet<String>();
        MySet<String> set2 = new MySet<String>();

        set1.add("A");
        set2.add("B");

        assertEquals("A", set1.difference(set2).toString());
        assertTrue(1 == set1.difference(set2).size());
    }

    @Test
    public void testDifferenceOfEmptySets() {
        MySet<String> set1 = new MySet<String>();
        MySet<String> set2 = new MySet<String>();

        assertEquals("", set1.difference(set2).toString());
        assertEquals(0,set1.difference(set2).size());
    }

    @Test
    public void testDifferenceOfMultipleElementsSetsTwoSimilar() {
        MySet<String> set1 = new MySet<String>();
        MySet<String> set2 = new MySet<String>();

        set1.add("A");
        set2.add("B");
        set1.add("C");
        set2.add("A");
        set1.add("E");
        set2.add("C");
        

        assertEquals("E", set1.difference(set2).toString());
        assertEquals(1,set1.difference(set2).size());
    }
    @Test
    public void testDifferenceOfMultipleElementsSetsWithDuplicates() {
        MySet<String> set1 = new MySet<String>();
        MySet<String> set2 = new MySet<String>();

        set1.add("C");
        set1.add("C");
        set1.add("E");

        set2.add("F");
        set2.add("B");
        set2.add("C");
        set2.add("D");
        

        assertEquals("E", set1.difference(set2).toString());
        assertEquals(1,set1.difference(set2).size());
    }

    @Test (expected=IllegalArgumentException.class) 
	public void testNullArgument() {
		MySet<String> set = new MySet<String>();
				
		set.add("A");
		
		set.difference(null);
	}
}
