package edu.westga.cs3152.test.myset;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.cs3152.sets.MySet;

public class TestMySetContains {

	@Test
	public void testOneElementShouldBeTrue() {
		MySet<String> set = new MySet<String>();
		
		set.add("A");
	
		assertTrue(set.contains("A"));
	}
	
	@Test
	public void testOneElementShouldBeFalse() {
		MySet<String> set = new MySet<String>();

		set.add("B");
	
		assertFalse(set.contains("A"));
	}
	
	@Test
	public void testEmptySetShouldBeFalse() {
		MySet<String> set = new MySet<String>();
	
		assertFalse(set.contains("D"));
	}
	
	@Test
	public void testMultipleElementShouldBeTrue() {
		MySet<String> set = new MySet<String>();
		
		set.add("A");
		set.add("B");
		set.add("C");
		set.add("D");
	
		assertTrue(set.contains("B"));
	}
	
	@Test
	public void testMultipleElementShouldBeFalse() {
		MySet<String> set = new MySet<String>();
		
		set.add("A");
		set.add("B");
		set.add("C");
		set.add("D");
	
		assertFalse(set.contains("E"));
	}

	@Test (expected=IllegalArgumentException.class) 
	public void testNullArgument() {
		MySet<String> set = new MySet<String>();
		String str = null; 
				
		set.add("A");
		
		set.contains(str);
	}
}
