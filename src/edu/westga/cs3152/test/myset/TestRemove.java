package edu.westga.cs3152.test.myset;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.cs3152.sets.MySet;

public class TestRemove {
    @Test
    public void testRemoveOneElement() {
        MySet<String> set = new MySet<String>();
		
		set.add("A");
        set.remove("A");
		assertFalse(set.contains("A"));
        assertTrue(set.size() == 0);
    }

    @Test
	public void testRemoveOneElementFromMulitple() {
		MySet<String> set = new MySet<String>();
		
		set.add("A");
		set.add("B");
		set.add("C");
		set.add("D");
	
        set.remove("B");

		assertTrue(set.contains("A"));
        assertFalse(set.contains("B"));
        assertTrue(set.contains("C"));
        assertTrue(set.contains("D"));
        assertTrue(set.size() == 3);
	}

    @Test
	public void testRemoveMultipleElementsFromMulitple() {
		MySet<String> set = new MySet<String>();
		
		set.add("A");
		set.add("B");
		set.add("C");
		set.add("D");
	
        set.remove("A");
        set.remove("D");

		assertFalse(set.contains("A"));
        assertTrue(set.contains("B"));
        assertTrue(set.contains("C"));
        assertFalse(set.contains("D"));
        assertTrue(set.size() == 2);
	}

    @Test (expected=IllegalArgumentException.class) 
	public void testNullArgument() {
		MySet<String> set = new MySet<String>();
		String str = null; 
		set.add(str);
	}
}
