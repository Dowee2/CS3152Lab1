package edu.westga.cs3152.test.myset;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.westga.cs3152.sets.MySet;

public class TestIsDisjoint {
    
    @Test
    public void TestTwoEmptySets() {
        MySet<String> set1 = new MySet<String>();
        MySet<String> set2 = new MySet<String>();

        assertTrue(set1.isDisjoint(set2));
    }

    @Test
    public void TestSingleElementsButDifferent() {
        MySet<String> set1 = new MySet<String>();
        MySet<String> set2 = new MySet<String>();

        set1.add("element");
        set2.add("NONE");

        assertTrue(set1.isDisjoint(set2));
    }

    @Test
    public void TestMultipleElementsButDifferent() {
        MySet<String> set1 = new MySet<String>();
        MySet<String> set2 = new MySet<String>();

        set1.add("element");
        set1.add("NONE");

        set2.add("E");
        set2.add("A");

        assertTrue(set1.isDisjoint(set2));
    }

    @Test
    public void TestMultipleElementsButOneSimilar() {
        MySet<String> set1 = new MySet<String>();
        MySet<String> set2 = new MySet<String>();

        set1.add("E");
        set1.add("NONE");

        set2.add("E");
        set2.add("A");

        assertFalse(set1.isDisjoint(set2));
    }

    @Test
    public void TestMultipleElementsButAllSimilar() {
        MySet<String> set1 = new MySet<String>();
        MySet<String> set2 = new MySet<String>();

        set1.add("E");
        set1.add("A");

        set2.add("E");
        set2.add("A");

        assertFalse(set1.isDisjoint(set2));
    }
}
