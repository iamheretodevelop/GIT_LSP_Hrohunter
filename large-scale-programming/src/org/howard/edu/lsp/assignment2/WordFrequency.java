/** 
 * Name: Hrishav Sapkota
 */
package org.howard.edu.lsp.assignment2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;

public class WordFrequency {

    public static void main(String[] args) {
        // Relative path to the file from the root directory of your project
        String wordsFilePath = "src/org/howard/edu/lsp/assignment2/words.txt";

        // Get the current working directory
        String currDirectory = System.getProperty("user.dir");

        // Construct the absolute path to the file
        Path filePath = Paths.get(currDirectory, wordsFilePath);

        // Read the content of the file into a string
        String fileWords = readFileToString(filePath);

        // Check if fileWords is null (indicating an error)
        if (fileWords != null) {
            // Print the content of the file
        	System.out.println(fileWords);
        	System.out.println("For the paragraph above, the word frequencies are as follows:\n\n");

            // Split the words based on whitespace and store them in an array
            String[] words = fileWords.split("\\s+");

            // Create a LinkedHashMap to store word frequencies
            LinkedHashMap<String, Integer> wordMap = new LinkedHashMap<>();

            // Process the words to compute word frequencies
            for (String word : words) {
            	if (!Character.isLetter(word.charAt(0))) {
                    continue; // Skip strings that aren't words
                }
            	
                // Check if the word length is less than 3 characters
                if (word.length() < 3) {
                    continue; // Skip words with length less than 3
                }

                // Check for contractions in the word
                if (word.contains("'")) {
                    // Split the word into parts based on the apostrophe
                    String[] parts = word.split("'");
                    if (parts[0].length() > 3) {
                    	wordMap.put(parts[0].toLowerCase(), wordMap.getOrDefault(parts[0].toLowerCase(), 0) + 1);
                    }
                    if (parts[1].length() > 3) {
                    	wordMap.put(parts[1].toLowerCase(), wordMap.getOrDefault(parts[1].toLowerCase(), 0) + 1);
                    }
                    continue;
                }

                // Convert the word to lowercase to ensure case-insensitive matching
                String lowercaseWord = word.toLowerCase();

                // Update the frequency count for the word
                wordMap.put(lowercaseWord, wordMap.getOrDefault(lowercaseWord, 0) + 1);
            }

            // Output the word frequencies
            for (String word : wordMap.keySet()) {
                System.out.println(word + ": " + wordMap.get(word));
            }
        } else {
            // Handle the case where fileWords is null (e.g., file not found)
            System.out.println("Error: Unable to read the content of the file.");
        }
    }

    public static String readFileToString(Path filePath) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath.toFile()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n"); // Append the line to the StringBuilder
            }
            return sb.toString();
        } catch (IOException e) {
            // Handle any IO exception that may occur (e.g., file not found)
            e.printStackTrace();
            return null;
        }
    }
}