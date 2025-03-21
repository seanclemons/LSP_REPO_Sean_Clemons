package org.howard.edu.lsp.midterm.question5;

/**
 * Driver class to demonstrate the usage of the streaming service
 */
public class StreamingServiceDriver {
    /**
     * Main method to test functionality of the streaming service
     * 
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Create instances of different media types
        Streamable music = new Music("Still a Friend - Incognito");
        Streamable movie = new Movie("Avengers End Game");
        Streamable audiobook = new Audiobook("A Promised Land - Barack Obama");

        // Test the common behaviors for all media types (play, pause, stop)
        System.out.println("Testing common behaviors for all media types:\n");
        
        // Test Music
        System.out.println("Testing Music:");
        music.play();  // Output: "Playing music: Still a Friend - Incognito"
        music.pause();  // Output: "Paused music: Still a Friend - Incognito"
        music.stop();   // Output: "Stopped music: Still a Friend - Incognito"
        System.out.println();
        
        // Test Movie
        System.out.println("Testing Movie:");
        movie.play();  // Output: "Playing movie: Avengers End Game"
        movie.pause();  // Output: "Paused movie: Avengers End Game"
        movie.stop();   // Output: "Stopped movie: Avengers End Game"
        System.out.println();
        
        // Test Audiobook
        System.out.println("Testing Audiobook:");
        audiobook.play();  // Output: "Playing audiobook: A Promised Land – Barack Obama"
        audiobook.pause();  // Output: "Paused audiobook: A Promised Land – Barack Obama"
        audiobook.stop();   // Output: "Stopped audiobook: A Promised Land – Barack Obama"
        System.out.println();
        
        // Test unique behaviors for each media type
        System.out.println("Testing unique behaviors for each media type:\n");
        
        // Test Movie-specific behavior (rewind)
        System.out.println("Testing Movie-specific behavior (rewind):");
        Movie movieWithRewind = (Movie) movie;  // Cast to Movie for specific method
        movieWithRewind.rewind(30);  // Output: "Rewinding movie: Avengers End Game by 30 seconds"
        System.out.println();
        
        // Test Audiobook-specific behavior (setPlaybackSpeed)
        System.out.println("Testing Audiobook-specific behavior (setPlaybackSpeed):");
        Audiobook audiobookWithSpeed = (Audiobook) audiobook;  // Cast to Audiobook for specific method
        audiobookWithSpeed.setPlaybackSpeed(1.5);  // Output: "Setting playback speed of audiobook: A Promised Land – Barack Obama to 1.5x"
        System.out.println();
        
        // Test Music-specific behavior (addToPlaylist)
        System.out.println("Testing Music-specific behavior (addToPlaylist):");
        Music musicWithPlaylist = (Music) music;  // Cast to Music for specific method
        musicWithPlaylist.addToPlaylist("Favorites");  // Output: "Added Still a Friend - Incognito to Favorites playlist"
        System.out.println();
    }
}