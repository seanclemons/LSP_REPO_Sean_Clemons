package org.howard.edu.lsp.midterm.question4;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that processes a sentence and finds all longest words.
 */
public class WordProcessor {
    private String sentence; // Stores the sentence to be processed

    /**
     * Constructor to initialize the WordProcessor with a sentence
     * 
     * @param sentence The sentence to be processed
     */
    public WordProcessor(String sentence) {
        this.sentence = sentence;
    }

    /**
     * Finds all words with the maximum length in the order they appear in the sentence
     * 
     * @return A list containing all words with the maximum length
     */
    public List<String> findLongestWords() {
        if (sentence == null || sentence.trim().isEmpty()) {
            return new ArrayList<>();
        }

        String[] words = sentence.trim().split("\\s+");
        
        int maxLength = 0;
        for (String word : words) {
            String cleanWord = word.replaceAll("[,!.]", "");
            if (cleanWord.length() > maxLength) {
                maxLength = cleanWord.length();
            }
        }

        List<String> longestWords = new ArrayList<>();
        for (String word : words) {
            String cleanWord = word.replaceAll("[,!.]", "");
            if (cleanWord.length() == maxLength) {
                longestWords.add(cleanWord);
            }
        }

        return longestWords;
    }
}