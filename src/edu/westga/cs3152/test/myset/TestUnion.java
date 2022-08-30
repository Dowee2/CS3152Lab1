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

        assertTrue(2 == set1.union(set2).size());
    }
}
