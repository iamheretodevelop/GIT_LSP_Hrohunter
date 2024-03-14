package org.howard.edu.lsp.midterm.question1;

/**
 * The Driver class provides a main method to demonstrate the encryption functionality.
 */
public class Driver {
    
    /**
     * The main method of the Driver class.
     * 
     * It demonstrates the encryption functionality by encrypting a sample text
     * and printing both the original and encrypted texts to the console.
     * 
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Sample input text
        String input = "I love CSCI363";
        
        // Encrypt the input text
        String encrypted = SecurityOps.encrypt(input);
        
        // Print the original text
        System.out.println("Original Text: " + input);
        
        // Print the encrypted text
        System.out.println("Encrypted Text: " + encrypted);
    }
}