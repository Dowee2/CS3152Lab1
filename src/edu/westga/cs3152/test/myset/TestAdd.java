package edu.westga.cs3152.test.myset;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.cs3152.sets.MySet;

public class TestAdd {
    @Test
    public void testAddOneElements() {
        MySet<String> set = new MySet<String>();
		
		set.add("A");
	
		assertTrue(set.contains("A"));
        assertTrue(set.size() == 1);
    }

    @Test
	public void testAddMulitpleElements() {
		MySet<String> set = new MySet<String>();
		
		set.add("A");
		set.add("B");
		set.add("C");
		set.add("D");
	
		assertTrue(set.contains("A"));
        assertTrue(set.contains("B"));
        assertTrue(set.contains("C"));
        assertTrue(set.contains("D"));
        assertTrue(set.size() == 4);
	}

    @Test (expected=IllegalArgumentException.class) 
	public void testNullArgument() {
		MySet<String> set = new MySet<String>();
		String str = null; 
		set.add(str);
	}
}
