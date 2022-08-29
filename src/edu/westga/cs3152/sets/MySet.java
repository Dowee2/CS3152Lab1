package edu.westga.cs3152.sets;

import java.util.ArrayList;
import java.util.Iterator;

public class MySet<E> implements Set<E> {

    ArrayList<E> elements;

    public MySet() {
        super();
        elements = new ArrayList<E>();
    }
    @Override
    public Iterator<E> iterator() {
        return elements.iterator();
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public boolean equals(Set set) {
        return elements.equals(set);
    }

    @Override
    public boolean isSubsetOf(Set set) {
        boolean isSubsetOf = false;
        for (E element : this.elements) {
            isSubsetOf = set.contains(element);
        }
        return isSubsetOf;
    }

    @Override
    public boolean isProperSubsetOf(Set set) {
        boolean isPSubsetOf = false;
        for (E element : this.elements) {
            isPSubsetOf = set.contains(element);
        }
        if (this.size() == set.size()) {
            return false;
        }
        return isPSubsetOf;
    }

    @Override
    public boolean isDisjoint(Set set) {
        for (E element : this.elements) {
            if(set.contains(element)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean contains(Object element) {
        if (element == null) {
           throw new IllegalArgumentException("Element cannot be null"); 
        }
        return this.elements.contains(element);
    }

    @Override
    public boolean add(Object element) {
        return this.elements.add((E) element);
    }

    @Override
    public boolean remove(Object element) {
        return this.elements.remove(element);
    }

    @Override
    public Set union(Set set) {
        MySet<E> union = new MySet<E>();
        for (E currElement : this.elements) {
            union.add(currElement);
        }
        while (set.iterator().hasNext()) {
            E currElement = (E)set.iterator().next();
            if (!union.contains(currElement)) {
                union.add(currElement);
            }
        }
        return union;
    }

    @Override
    public Set intersection(Set set) {
        Set<E> intersection = new MySet<E>();
        for (E element : this.elements) {
            if (set.contains(element)) {
                intersection.add(element);
            }
        }
        return intersection;
    }

    @Override
    public Set difference(Set set) {
        MySet<E> difference = new MySet<E>();
        for (E element : this.elements) {
            if (!set.contains(element)) {
                difference.remove(element);
            }
        }
        return difference;
    }
    
}
