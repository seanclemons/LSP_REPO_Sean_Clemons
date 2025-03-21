package org.howard.edu.lsp.midterm.question5;

/**
 * Represents music in the streaming service
 * Implements the Streamable interface and adds music-specific functionality
 */
public class Music implements Streamable {
    private String title;
    
    /**
     * Constructor to initialize music with a title
     * 
     * @param title The title of the music
     */
    public Music(String title) {
        this.title = title;
    }
    
    @Override
    public void play() {
        System.out.println("Playing music: " + title);
    }
    
    @Override
    public void pause() {
        System.out.println("Paused music: " + title);
    }
    
    @Override
    public void stop() {
        System.out.println("Stopped music: " + title);
    }
    
    /**
     * Adds the music to a specified playlist
     * 
     * @param playlistName The name of the playlist to add the music to
     */
    public void addToPlaylist(String playlistName) {
        System.out.println("Added " + title + " to " + playlistName + " playlist");
    }
}