package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.List;

/**
 * The IntegerSet class represents a set of integers.
 * It provides operations to manipulate and query the set, including adding, removing, 
 * and performing set operations like union, intersection, and complement.
 */
public class IntegerSet {

    // Store the set elements in an ArrayList.
    private List<Integer> set = new ArrayList<Integer>();

    // Default constructor.
    /**
     * Default constructor that creates an empty set.
     */
    public IntegerSet() {
    }

    /**
     * Constructor that initializes the set with the provided ArrayList of integers.
     * @param set the ArrayList of integers to initialize the set.
     */
    public IntegerSet(ArrayList<Integer> set) {
        this.set = set;
    }

    /**
     * Clears the internal representation of the set.
     * This removes all elements from the set.
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns the length of the set.
     * @return the number of elements in the set.
     */
    public int length() {
        return set.size();
    }

    /**
     * Checks if this set is equal to another set.
     * Two sets are equal if they contain the same elements, in any order.
     * @param o the object to compare with this set.
     * @return true if the sets are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntegerSet otherSet = (IntegerSet) o;
        return set.equals(otherSet.set);
    }

    /**
     * Checks if the set contains a specific value.
     * @param value the value to check for in the set.
     * @return true if the set contains the value, false otherwise.
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Returns the largest integer in the set.
     * @return the largest integer in the set.
     * @throws IllegalStateException if the set is empty.
     */
    public int largest() {
        if (set.isEmpty()) {
            throw new IllegalStateException("Set is empty.");
        }
        return set.stream().max(Integer::compare).get();
    }

    /**
     * Returns the smallest integer in the set.
     * @return the smallest integer in the set.
     * @throws IllegalStateException if the set is empty.
     */
    public int smallest() {
        if (set.isEmpty()) {
            throw new IllegalStateException("Set is empty.");
        }
        return set.stream().min(Integer::compare).get();
    }

    /**
     * Adds an item to the set if it's not already present.
     * @param item the integer to add to the set.
     */
    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes an item from the set if it exists.
     * @param item the integer to remove from the set.
     */
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    /**
     * Performs the union of this set with another set.
     * The union adds all elements from the other set that are not already in this set.
     * @param intSetb the other IntegerSet to union with.
     */
    public void union(IntegerSet intSetb) {
        for (int item : intSetb.set) {
            this.add(item); // Adds item to this set if not already present.
        }
    }

    /**
     * Performs the intersection of this set with another set.
     * The intersection keeps only elements that are present in both sets.
     * @param intSetb the other IntegerSet to intersect with.
     */
    public void intersect(IntegerSet intSetb) {
        List<Integer> intersection = new ArrayList<>();
        for (int item : intSetb.set) {
            if (this.contains(item)) {
                intersection.add(item);
            }
        }
        this.set = intersection;
    }

    /**
     * Performs the set difference operation, removing elements of intSetb from this set.
     * @param intSetb the IntegerSet to subtract from this set.
     */
    public void diff(IntegerSet intSetb) {
        this.set.removeAll(intSetb.set);
    }

    /**
     * Performs the complement of this set, adding all elements not in this set.
     * @param intSetb the IntegerSet to complement against.
     */
    public void complement(IntegerSet intSetb) {
        for (int item : intSetb.set) {
            if (!this.contains(item)) {
                this.add(item);
            }
        }
    }

    /**
     * Returns true if the set is empty, false otherwise.
     * @return true if the set is empty, false otherwise.
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Returns a string representation of the set.
     * @return a string representation of the set in the form [item1, item2, ...]
     */
    @Override
    public String toString() {
        return set.toString();
    }
}