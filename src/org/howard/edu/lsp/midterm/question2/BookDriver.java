package org.howard.edu.lsp.midterm.question2;

/**
 * Driver class to test the Book class functionality
 */
public class BookDriver {
    
    /**
     * Main method to test Book class implementation
     * 
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Create book instances
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "123456789", 1925);
        Book book2 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "123456789", 1925);
        Book book3 = new Book("A Promised Land", "Barack Obama", "9780593239681", 2020);
        
        // Test equals method
        System.out.println(book1.equals(book2)); // Should print: true
        System.out.println(book1.equals(book3)); // Should print: false
        
        // Test toString method
        System.out.println(book1); // Should print: Title: The Great Gatsby, Author: F. Scott Fitzgerald, ISBN: 123456789, Year Published: 1925
    }
}