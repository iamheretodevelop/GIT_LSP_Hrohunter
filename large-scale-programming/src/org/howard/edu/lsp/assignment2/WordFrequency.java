package org.howard.edu.lsp.assignment2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;

public class WordFrequency {

	public static void main(String[] args) {
		String wordsFilePath = "/src/org/howard/edu/lsp/assignment2.words.txt";
		
		String currDirectory = System.getProperty("user.dir");
		Path filePath = Paths.get(currDirectory, wordsFilePath);
		
		try {
			String fileWords = new String(Files.readAllBytes(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LinkedHashMap<String, Integer> wordMap = new LinkedHashMap<>;
		StringBuilder var = new StringBuilder();
		
		String[] arr = fileWords.split("\\s+");
	}
	
	private static boolean checkWord(String word) {
		for (String letter : word) {
			if letter.isalpha()
		}
		return true;
		
		return false;
	}
		

}
