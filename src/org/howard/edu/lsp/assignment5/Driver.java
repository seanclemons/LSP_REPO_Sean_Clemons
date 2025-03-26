package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;

/**
 * The Driver class contains the main method used to test the IntegerSet class.
 * This class demonstrates various operations on the IntegerSet, such as adding, removing, 
 * and performing set operations like union, intersection, and complement.
 */
public class Driver {

    /**
     * Main method that tests the IntegerSet class by performing various set operations.
     * @param args command line arguments (not used in this implementation).
     */
    public static void main(String[] args) {
        
        // Test case 1: Creating a set and performing basic operations.
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        System.out.println("Value of Set1 is: " + set1.toString());

        System.out.println("Smallest value in Set1 is: " + set1.smallest());
        System.out.println("Largest value in Set1 is: " + set1.largest());

        // Test case 2: Creating another set and performing union.
        IntegerSet set2 = new IntegerSet();
        set2.add(3);
        set2.add(4);
        set2.add(5);
        System.out.println("Union of Set1 and Set2:");
        System.out.println("Value of Set1 is: " + set1.toString());
        System.out.println("Value of Set2 is: " + set2.toString());
        set1.union(set2);
        System.out.println("Result of union of Set1 and Set2: " + set1.toString());

        // Test case 3: Testing intersection operation.
        IntegerSet set3 = new IntegerSet();
        set3.add(1);
        set3.add(4);
        set3.add(5);
        System.out.println("Intersection of Set1 and Set3:");
        set1.intersect(set3);
        System.out.println("Result of intersection: " + set1.toString());

        // Test case 4: Testing difference operation.
        IntegerSet set4 = new IntegerSet();
        set4.add(3);
        set4.add(2);
        System.out.println("Difference of Set1 and Set4:");
        set1.diff(set4);
        System.out.println("Result of difference: " + set1.toString());

        // Test case 5: Testing complement operation.
        IntegerSet set5 = new IntegerSet();
        set5.add(1);
        set5.add(2);
        System.out.println("Complement of Set1 and Set5:");
        set1.complement(set5);
        System.out.println("Result of complement: " + set1.toString());
    }
}
