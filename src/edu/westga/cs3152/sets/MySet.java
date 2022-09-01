package edu.westga.cs3152.sets;

import java.util.ArrayList;
import java.util.Iterator;

import javax.lang.model.element.Element;

public class MySet<E> implements Set<E> {

    public ArrayList<E> elements;

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
        if (set == null) {
            throw new IllegalArgumentException("Set cannot be null"); 
         }

         if (!(this.size() == set.size())) {
            return false;
        }

         Iterator<E> it = set.iterator();
         while (it.hasNext()) {
             E currentElement = it.next();
             if (!this.isContainedIn(currentElement)) {
                 return false;
             }
         }
        
        return true;
    }

    @Override
    public boolean isSubsetOf(Set set) {
        if (set == null) {
            throw new IllegalArgumentException("Set cannot be null"); 
         }
         if (this.size() > set.size()) {
            return false;
        }
        for (E currElement : this.elements) {
            Iterator<E> it = set.iterator();
            if (!this.imContainedIn(it, currElement)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isProperSubsetOf(Set set) {
        if (set == null) {
            throw new IllegalArgumentException("Set cannot be null"); 
         }

         if (this.size() >= set.size()) {
            return false;
        }
        for (E currElement : this.elements) {
            Iterator<E> it = set.iterator();
            if (!this.imContainedIn(it, currElement)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isDisjoint(Set set) {
        if (set == null) {
            throw new IllegalArgumentException("Set cannot be null"); 
         }

        Iterator<E> it = set.iterator();
        while (it.hasNext()) {
            E currentElement = it.next();
            for (E element : this.elements) {
                if(currentElement.equals(element)){
                    return false;
                }
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
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null"); 
         }
        return this.elements.add((E) element);
    }

    @Override
    public boolean remove(Object element) {
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null"); 
         }
        return this.elements.remove((E) element);
    }

    @Override
    public Set union(Set set) {
        if (set == null) {
            throw new IllegalArgumentException("Set cannot be null"); 
         }

        MySet<E> union = new MySet<E>();
        Iterator<E> it = set.iterator();
        
        for (E currElement : this.elements) {
            union.add(currElement);
        }
        while (it.hasNext()) {
            E currentElement = it.next();
            if (!this.isContainedIn(currentElement)) {
                union.add(currentElement);
            }
        }
        return union;
    }

    @Override
    public Set intersection(Set set) {
        if (set == null) {
            throw new IllegalArgumentException("Set cannot be null"); 
         }

        Set<E> intersection = new MySet<E>();
        Iterator<E> it = set.iterator();
        while (it.hasNext()) {
            E currentElement = it.next();
            if (this.isContainedIn(currentElement) &&!intersection.contains(currentElement)) {
                intersection.add(currentElement);
            }
        }
        return intersection;
    }

    @Override
    public Set difference(Set set) {
        if (set == null) {
            throw new IllegalArgumentException("Set cannot be null"); 
         }
         
        MySet<E> difference = new MySet<E>();
        for (E currElement : this.elements) {
            Iterator<E> it = set.iterator();
            if (!this.imContainedIn(it, currElement)) {
                difference.add(currElement);
            }
        }
        return difference;
    }

    public String toString() {
        String elements = "";

        for (E element : this.elements) {
            elements += element.toString();
        }
        
        return elements;
    }

    /**
     * Call this when you would like to test if elements in another are contained in this set
     * 
     */
    private boolean isContainedIn(E element) {
        for (E currElement : this.elements) {
            
            if (currElement.equals(element)) {
                return true;
            }
        }
        
        return false;
    }

    /**
     * Call this when you would like to test if elements in this set are contained in another set
     * 
     * 
     */
    private boolean imContainedIn(Iterator<E> it,E element) {
        while (it.hasNext()) {
            E currElement = it.next();
            System.out.println("Set1: " + element + " " +  currElement);
            if (currElement.equals(element)) {
                return true;
            }
        }
        return false;
    }
}
