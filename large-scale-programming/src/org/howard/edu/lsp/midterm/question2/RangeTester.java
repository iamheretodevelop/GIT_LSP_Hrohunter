package org.howard.edu.lsp.midterm.question2;

/**
 * The RangeTester class demonstrates the functionality of the IntegerRange class.
 */
public class RangeTester {
    
    /**
     * The main method of the RangeTester class.
     * 
     * It tests the methods of the IntegerRange class by creating instances of IntegerRange
     * and invoking their methods. It also tests the equals method.
     * 
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Creating IntegerRange objects
        IntegerRange range1 = new IntegerRange(1, 10);
        IntegerRange range2 = new IntegerRange(5, 15);
        IntegerRange range3 = new IntegerRange(16, 19);
        
        // Testing contains method
        System.out.println("Does range1 contain 5? " + range1.contains(5));
        System.out.println("Does range1 contain 15? " + range1.contains(15));
        
        // Testing overlaps method
        System.out.println("Do range1 and range2 overlap? " + range1.overlaps(range2));
        System.out.println("Do range2 and range3 overlap? " + range2.overlaps(range3));
        
        // Testing size method
        System.out.println("Size of range1: " + range1.size());
        System.out.println("Size of range3: " + range3.size());
        
        // Testing equals method
        IntegerRange range4 = new IntegerRange(1, 10);
        System.out.println("Are range1 and range4 equal? " + range1.equals(range4));
        System.out.println("Are range1 and range2 equal? " + range1.equals(range2));
    }
}