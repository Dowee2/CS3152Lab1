package edu.westga.cs3152.test.myset;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.cs3152.sets.MySet;

public class TestIntersection {
    
    @Test
    public void testIntersectOfSingleElementSetsSimilar() {
        MySet<String> set1 = new MySet<String>();
        MySet<String> set2 = new MySet<String>();

        set1.add("A");
        set2.add("A");

        assertEquals("A", set1.intersection(set2).toString());
        assertTrue(1 == set1.intersection(set2).size());
    }

    @Test
    public void testIntersectOfSingleElementSetsNotSimilar() {
        MySet<String> set1 = new MySet<String>();
        MySet<String> set2 = new MySet<String>();

        set1.add("A");
        set2.add("B");

        assertEquals("", set1.intersection(set2).toString());
        assertTrue(0 == set1.intersection(set2).size());
    }

    @Test
    public void testIntersectOfEmptySets() {
        MySet<String> set1 = new MySet<String>();
        MySet<String> set2 = new MySet<String>();

        assertEquals("", set1.intersection(set2).toString());
        assertEquals(0,set1.intersection(set2).size());
    }

    @Test
    public void testIntersectOfMultipleElementsSetsTwoSimilar() {
        MySet<String> set1 = new MySet<String>();
        MySet<String> set2 = new MySet<String>();

        set1.add("A");
        set2.add("B");
        set1.add("C");
        set2.add("A");
        set1.add("E");
        set2.add("C");
        

        assertEquals("AC", set1.intersection(set2).toString());
        assertEquals(2,set1.intersection(set2).size());
    }
    @Test
    public void testIntersectOfMultipleElementsSetsWithDuplicates() {
        MySet<String> set1 = new MySet<String>();
        MySet<String> set2 = new MySet<String>();

        set1.add("C");
        set1.add("C");
        set1.add("E");

        set2.add("F");
        set2.add("B");
        set2.add("C");
        set2.add("D");
        

        assertEquals("C", set1.intersection(set2).toString());
        assertEquals(1,set1.intersection(set2).size());
    }

    @Test (expected=IllegalArgumentException.class) 
	public void testNullArgument() {
		MySet<String> set = new MySet<String>();
				
		set.add("A");
		
		set.intersection(null);
	}
}
