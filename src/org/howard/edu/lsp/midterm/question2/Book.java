package org.howard.edu.lsp.midterm.question2;

/**
 * Represents a book in a library system
 */
public class Book {
    private String title;
    private String author;
    private String ISBN;
    private int yearPublished;
    
    /**
     * Constructor for creating a new Book object
     * 
     * @param title The title of the book
     * @param author The author of the book
     * @param ISBN The ISBN number of the book (a unique identifier)
     * @param yearPublished The year the book was published
     */
    public Book(String title, String author, String ISBN, int yearPublished) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.yearPublished = yearPublished;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public String getISBN() {
        return ISBN;
    }
    
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    
    public int getYearPublished() {
        return yearPublished;
    }
    
    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Book)) {
            return false;
        }
        
        Book otherBook = (Book) obj;
        
        return this.ISBN.equals(otherBook.ISBN) && this.author.equals(otherBook.author);
    }
    
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + ISBN + 
               ", Year Published: " + yearPublished;
    }
}