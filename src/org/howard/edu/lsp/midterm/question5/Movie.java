package org.howard.edu.lsp.midterm.question5;

/**
 * Represents a movie in the streaming service
 * Implements the Streamable interface and adds movie-specific functionality
 */
public class Movie implements Streamable {
    private String title;
    
    /**
     * Constructor to initialize movie with a title
     * 
     * @param title The title of the movie
     */
    public Movie(String title) {
        this.title = title;
    }
    
    @Override
    public void play() {
        System.out.println("Playing movie: " + title);
    }
    
    @Override
    public void pause() {
        System.out.println("Paused movie: " + title);
    }
    
    @Override
    public void stop() {
        System.out.println("Stopped movie: " + title);
    }
    
    /**
     * Rewinds the movie by a specified number of seconds
     * 
     * @param seconds The number of seconds to rewind
     */
    public void rewind(int seconds) {
        System.out.println("Rewinding movie: " + title + " by " + seconds + " seconds");
    }
}