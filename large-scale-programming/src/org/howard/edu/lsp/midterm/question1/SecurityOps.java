package org.howard.edu.lsp.midterm.question1;

/**
 * The SecurityOps class provides a method to encrypt text by rearranging characters.
 */
public class SecurityOps {
    
    /**
     * Encrypts the given text by rearranging characters after removing punctuation and whitespace.
     * 
     * This method removes all punctuation and whitespace from the input text,
     * then rearranges the remaining characters by appending even-indexed characters first,
     * followed by odd-indexed characters.
     * 
     * @param text The text to be encrypted.
     * @return The encrypted text.
     */
    public static String encrypt(String text) {
        // Remove punctuation and whitespace from the input text
        text = text.replaceAll("[\\p{Punct}\\s]", "");
        
        StringBuilder encryptedText = new StringBuilder();

        // Append even-indexed characters first
        for (int i = 0; i < text.length(); i += 2) {
            encryptedText.append(text.charAt(i));
        }

        // Append odd-indexed characters
        for (int i = 1; i < text.length(); i += 2) {
            encryptedText.append(text.charAt(i));
        }
        
        // Return the encrypted text
        return encryptedText.toString();
    }
}