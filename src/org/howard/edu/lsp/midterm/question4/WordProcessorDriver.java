package org.howard.edu.lsp.midterm.question4;

import java.util.List;

/**
 * Driver class to test the WordProcessor implementation
 */
public class WordProcessorDriver {
    /**
     * Main method to test WordProcessor functionality
     * 
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Test case 1: Sentence with single longest word
        WordProcessor wp1 = new WordProcessor("This is a test with amazing results amazing achievements");
        List<String> longestWords1 = wp1.findLongestWords();
        System.out.println("Test 1 - Longest words: " + longestWords1); 
        // Expected Output: ["achievements"]

        // Test case 2: Sentence with multiple occurrences of the same longest word and length
        WordProcessor wp2 = new WordProcessor("Java is a powerful  powerful tool");
        List<String> longestWords2 = wp2.findLongestWords();
        System.out.println("Test 2 - Longest words: " + longestWords2); 
        // Expected Output: ["powerful", "powerful"]

        // Test case 3: Sentence with multiple words of the same longest length
        WordProcessor wp3 = new WordProcessor("The quick brown fox jumps over the lazy dogs");
        List<String> longestWords3 = wp3.findLongestWords();
        System.out.println("Test 3 - Longest words: " + longestWords3); 
        // Expected Output: ["quick", "brown", "jumps"]

        // Test case 4: Sentence with single longest word
        WordProcessor wp4 = new WordProcessor("This is a test with amazing results amazing achievements");
        List<String> longestWords4 = wp4.findLongestWords();
        System.out.println("Test 4 - Longest words: " + longestWords4); 
        // Expected Output: ["achievements"]

        // Test case 5: Sentence with single character words
        WordProcessor wp5 = new WordProcessor("A B C D E");
        List<String> longestWords5 = wp5.findLongestWords();
        System.out.println("Test 5 - Longest words: " + longestWords5); 
        // Expected Output: ["A", "B", "C", "D", "E"]

        // Test case 6: Empty string input
        WordProcessor wp6 = new WordProcessor("");
        List<String> longestWords6 = wp6.findLongestWords();
        System.out.println("Test 6 - Longest words: " + longestWords6); 
        // Expected Output: []
        
        // Test case 7: String with only whitespace
        WordProcessor wp7 = new WordProcessor("    ");
        List<String> longestWords7 = wp7.findLongestWords();
        System.out.println("Test 7 - Longest words: " + longestWords7); 
        // Expected Output: []
        
        // Test case 8: Sentence with varying amounts of whitespace
        WordProcessor wp8 = new WordProcessor("This    has    lots    of     spaces");
        List<String> longestWords8 = wp8.findLongestWords();
        System.out.println("Test 8 - Longest words: " + longestWords8); 
        // Expected Output: ["spaces"]
    }
}