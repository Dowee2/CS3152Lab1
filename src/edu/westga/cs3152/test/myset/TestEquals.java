package edu.westga.cs3152.test.myset;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.cs3152.sets.MySet;

public class TestEquals {

    @Test
    public void testEqualsOneElementEachSimilar() {
        MySet<String> set1 = new MySet<String>();
		MySet<String> set2 = new MySet<String>();

		set1.add("A");
        set2.add("A");

        assertTrue(set1.equals(set2));
    }

    @Test
    public void testEqualsOneElementEachNotSimilar() {
        MySet<String> set1 = new MySet<String>();
		MySet<String> set2 = new MySet<String>();

		set1.add("A");
        set2.add("B");

        assertFalse(set1.equals(set2));
    }

    @Test
    public void testEqualMultipleElementEachSimilar() {
        MySet<String> set1 = new MySet<String>();
		MySet<String> set2 = new MySet<String>();

		set1.add("A");
        set1.add("B");
        set1.add("C");

        set2.add("A");
        set2.add("B");
        set2.add("C");

        assertTrue(set1.equals(set2));
    }

    @Test
    public void testEqualDifferentMultipleElement() {
        MySet<String> set1 = new MySet<String>();
		MySet<String> set2 = new MySet<String>();

		set1.add("A");
        set1.add("D");
        set1.add("F");

        set2.add("A");
        set2.add("B");
        set2.add("C");

        assertFalse(set1.equals(set2));
    }

    @Test
    public void testEqualDifferentSizeSet() {
        MySet<String> set1 = new MySet<String>();
		MySet<String> set2 = new MySet<String>();

		set1.add("A");
        set1.add("F");
        set1.add("C");

        set2.add("A");
        set2.add("B");
        set2.add("C");

        assertFalse(set1.equals(set2));
    }

    @Test
    public void testEqualSameSizeSetRepeatElements() {
        MySet<String> set1 = new MySet<String>();
		MySet<String> set2 = new MySet<String>();

		set1.add("A");
        set1.add("C");
        set1.add("C");
        set1.add("A");

        set2.add("A");
        set2.add("B");
        set2.add("C");

        assertFalse(set1.equals(set2));
    }

    @Test
    public void testSubsetSameSizeSetRepeatElements() {
        MySet<String> set1 = new MySet<String>();
		MySet<String> set2 = new MySet<String>();

		set1.add("A");
        set1.add("C");
        set1.add("C");

        set2.add("A");
        set2.add("C");
        set2.add("C");

        assertTrue(set1.equals(set2));
    }

    @Test (expected=IllegalArgumentException.class) 
	public void testNullArgument() {
		MySet<String> set = new MySet<String>();
				
		set.add("A");
		
		set.equals(null);
	}

}
