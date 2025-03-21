package org.howard.edu.lsp.midterm.question5;

/**
 * Interface representing streamable content in a media streaming service
 * Defines common behaviors that all streamable content must support
 */
public interface Streamable {
    /**
     * Plays the media content
     */
    void play();
    
    /**
     * Pauses the media content
     */
    void pause();
    
    /**
     * Stops the media content
     */
    void stop();
}