package org.howard.edu.lspfinal.question2;

/**
 * Custom checked exception thrown when a duplicate task is added.
 */
public class DuplicateTaskException extends Exception {
    public DuplicateTaskException(String message) {
        super(message);
    }
}
