package edu.westga.cs3152.test.myset;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.cs3152.sets.MySet;

public class TestIsProperSubsetOf {
    
    @Test
    public void testisProperSubsetOneElementEachSimilar() {
        MySet<String> set1 = new MySet<String>();
		MySet<String> set2 = new MySet<String>();

		set1.add("A");
        set2.add("A");

        assertFalse(set1.isProperSubsetOf(set2));
    }

    @Test
    public void testIsProperSubsetMultipleElementEachSimilar() {
        MySet<String> set1 = new MySet<String>();
		MySet<String> set2 = new MySet<String>();

		set1.add("A");
        set1.add("B");
        set1.add("C");

        set2.add("A");
        set2.add("B");
        set2.add("C");

        assertFalse(set1.isProperSubsetOf(set2));
    }

    @Test
    public void testIsProperSubsetSameElementDifferentSize() {
        MySet<String> set1 = new MySet<String>();
		MySet<String> set2 = new MySet<String>();

        set1.add("B");
        set1.add("C");

        set2.add("A");
        set2.add("B");
        set2.add("C");

        assertFalse(set1.isProperSubsetOf(set2));
    }

    @Test
    public void testsIsProperSubsetDifferentSizeAndElements() {
        MySet<String> set1 = new MySet<String>();
		MySet<String> set2 = new MySet<String>();

		set1.add("A");
        set1.add("D");

        set2.add("A");
        set2.add("B");
        set2.add("C");

        assertFalse(set1.isProperSubsetOf(set2));
    }

    @Test
    public void testIsProperSubsetSameSizeSetRepeatElements() {
        MySet<String> set1 = new MySet<String>();
		MySet<String> set2 = new MySet<String>();

		set1.add("A");
        set1.add("C");
        set1.add("C");
        set1.add("A");

        set2.add("A");
        set2.add("B");
        set2.add("C");

        assertFalse(set1.isProperSubsetOf(set2));
    }

    @Test
    public void testIsProperSubsetDifferentSizeSetRepeatElements() {
        MySet<String> set1 = new MySet<String>();
		MySet<String> set2 = new MySet<String>();

        set1.add("C");
        set1.add("C");

        set2.add("A");
        set2.add("B");
        set2.add("C");

        assertTrue(set1.isProperSubsetOf(set2));
    }

    @Test (expected=IllegalArgumentException.class) 
	public void testNullArgument() {
		MySet<String> set = new MySet<String>();
				
		set.add("A");
		
		set.isProperSubsetOf(null);
	}
    
}
