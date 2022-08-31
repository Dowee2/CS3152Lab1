package edu.westga.cs3152.test.myset;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.cs3152.sets.MySet;

public class TestUnion {
    
    @Test
    public void testUnionOfSingleElementSets() {
        MySet<String> set1 = new MySet<String>();
        MySet<String> set2 = new MySet<String>();

        set1.add("element");
        set2.add("NONE");

        assertEquals("elementNONE", set1.union(set2).toString());
        assertTrue(2 == set1.union(set2).size());
    }

    @Test
    public void testUnionOfEmptySets() {
        MySet<String> set1 = new MySet<String>();
        MySet<String> set2 = new MySet<String>();

        assertEquals("", set1.union(set2).toString());
        assertEquals(0,set1.union(set2).size());
    }

    @Test
    public void testUnionOfMultipleElementsSets() {
        MySet<String> set1 = new MySet<String>();
        MySet<String> set2 = new MySet<String>();

        set1.add("A");
        set2.add("B");
        set1.add("C");
        set2.add("D");
        set1.add("E");
        set2.add("F");
        

        assertEquals("ACEBDF", set1.union(set2).toString());
        assertEquals(6,set1.union(set2).size());
    }
    @Test
    public void testUnionOfMultipleElementsSetsWithDuplicates() {
        MySet<String> set1 = new MySet<String>();
        MySet<String> set2 = new MySet<String>();

        set1.add("A");
        set2.add("B");
        set1.add("C");
        set2.add("C");
        set2.add("D");
        set1.add("E");
        set2.add("F");
        

        assertEquals("ACEBDF", set1.union(set2).toString());
        assertEquals(6,set1.union(set2).size());
    }

    @Test (expected=IllegalArgumentException.class) 
	public void testNullArgument() {
		MySet<String> set = new MySet<String>();
				
		set.add("A");
		
		set.union(null);
	}
}
