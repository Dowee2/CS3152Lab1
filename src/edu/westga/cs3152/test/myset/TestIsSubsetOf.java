package edu.westga.cs3152.test.myset;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.cs3152.sets.MySet;

public class TestIsSubsetOf {

    @Test
    public void testSubsetOneElementEachSimilar() {
        MySet<String> set1 = new MySet<String>();
		MySet<String> set2 = new MySet<String>();

		set1.add("A");
        set2.add("A");

        assertTrue(set1.isSubsetOf(set2));
    }

    @Test
    public void testSubsetOneElementEachNotSimilar() {
        MySet<String> set1 = new MySet<String>();
		MySet<String> set2 = new MySet<String>();

		set1.add("A");
        set2.add("B");

        assertFalse(set1.isSubsetOf(set2));
    }

    @Test
    public void testSubsetMultipleElementEachSimilar() {
        MySet<String> set1 = new MySet<String>();
		MySet<String> set2 = new MySet<String>();

		set1.add("A");
        set1.add("B");
        set1.add("C");

        set2.add("A");
        set2.add("B");
        set2.add("C");

        assertTrue(set1.isSubsetOf(set2));
    }

    @Test
    public void testSubsetDifferentMultipleElement() {
        MySet<String> set1 = new MySet<String>();
		MySet<String> set2 = new MySet<String>();

		set1.add("A");
        set1.add("D");
        set1.add("F");

        set2.add("A");
        set2.add("B");
        set2.add("C");

        assertFalse(set1.isSubsetOf(set2));
    }

    @Test
    public void testSubsetDifferentSizeSet() {
        MySet<String> set1 = new MySet<String>();
		MySet<String> set2 = new MySet<String>();

		set1.add("A");
        set1.add("F");
        set1.add("C");

        set2.add("A");
        set2.add("B");
        set2.add("C");

        assertFalse(set1.isSubsetOf(set2));
    }

    @Test
    public void testSubsetSameSizeSetRepeatElements() {
        MySet<String> set1 = new MySet<String>();
		MySet<String> set2 = new MySet<String>();

		set1.add("A");
        set1.add("C");
        set1.add("C");

        set2.add("A");
        set2.add("B");
        set2.add("C");

        assertTrue(set1.isSubsetOf(set2));
    }

    @Test
    public void testSubsetDifferentSizeSetRepeatElements() {
        MySet<String> set1 = new MySet<String>();
		MySet<String> set2 = new MySet<String>();

		set1.add("A");
        set1.add("C");
        set1.add("C");

        set2.add("A");
        set2.add("B");
        set2.add("C");
        set2.add("F");

        assertTrue(set1.isSubsetOf(set2));
    }

    @Test (expected=IllegalArgumentException.class) 
	public void testNullArgument() {
		MySet<String> set = new MySet<String>();
				
		set.add("A");
		
		set.isSubsetOf(null);
	}

}
