package org.howard.edu.lsp.assignment4;

/**
 * The Driver class contains the main method to test the functionality of the IntegerSet class.
 * It demonstrates various operations on IntegerSet objects and validates their behavior.
 */
public class Driver {
    /**
     * The main method to test the functionality of the IntegerSet class.
     *
     * @param args Command-line arguments (not used).
     * @throws IntegerSetException If an error occurs during operations on IntegerSet objects.
     */
	public static void main(String[] args) throws IntegerSetException {
        // Create a new IntegerSet
        IntegerSet set1 = new IntegerSet();
        
        // Attempt to get the largest value from an empty set to test the IntegerSetException
        try {
            System.out.println("Trying to get the largest value from an empty set...");
            System.out.println("Largest value in Set1 is: " + set1.largest());
        } catch (IntegerSetException e) {
            System.out.println(e.getMessage());
        }

        // Add elements to set1
        set1.add(1);
        set1.add(2);
        set1.add(3);

        // Display contents of set1
        System.out.println("Value of Set1 is: " + set1.toString());

        // Test length method
        System.out.println("Length of Set1 is: " + set1.length());

        // Test isEmpty method
        System.out.println("Is Set1 empty? " + set1.isEmpty());

        // Test contains method
        System.out.println("Does Set1 contain 2? " + set1.contains(2));
        
        // Test smallest and largest methods
        try {
            System.out.println("Smallest value in Set1 is: " + set1.smallest());
            System.out.println("Largest value in Set1 is: " + set1.largest());
        } catch (IntegerSetException e) {
            System.out.println(e.getMessage());
        }

        // Test remove method
        set1.remove(2);
        System.out.println("After removing 2, Set1 is: " + set1.toString());

        // Create another IntegerSet
        IntegerSet set2 = new IntegerSet();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        // Test equals method
        System.out.println("Are Set1 and Set2 equal? " + set1.equals(set2));

        // Create another IntegerSet equal to set1
        IntegerSet set3 = new IntegerSet();
        set3.add(1);
        set3.add(3);

        // Test equals method with equal sets
        System.out.println("Are Set1 and Set3 equal? " + set1.equals(set3));

        // Test union method
        System.out.println("\nUnion of Set1 and Set2");
        System.out.println("Value of Set1 is: " + set1.toString());
        System.out.println("Value of Set2 is: " + set2.toString());
        set1.union(set2);
        System.out.println("Result of union of Set1 and Set2");
        System.out.println("Set1: " + set1.toString());

        // Test intersection method
        System.out.println("\nIntersection of Set1 and Set2");
        System.out.println("Value of Set1 is: " + set1.toString());
        System.out.println("Value of Set2 is: " + set2.toString());
        set1.intersect(set2);
        System.out.println("Result of intersection of Set1 and Set2");
        System.out.println("Set1: " + set1.toString());

        // Test difference method
        System.out.println("\nDifference of Set1 and Set3");
        System.out.println("Value of Set1 is: " + set1.toString());
        System.out.println("Value of Set3 is: " + set3.toString());
        set1.diff(set3);
        System.out.println("Result of difference of Set1 and Set3");
        System.out.println("Set1: " + set1.toString());

        // Test complement method
        System.out.println("\nComplement of Set1 with respect to Set2");
        System.out.println("Value of Set1 is: " + set1.toString());
        System.out.println("Value of Set2 is: " + set2.toString());
        set1.complement(set2);
        System.out.println("Result of complement of Set1 with respect to Set2");
        System.out.println("Set1: " + set1.toString());

        // Test clear method
        System.out.println("\nClearing Set1");
        set1.clear();
        System.out.println("Set1 after clearing: " + set1.toString());
    }
}