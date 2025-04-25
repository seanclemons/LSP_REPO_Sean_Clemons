package org.howard.edu.lspfinal.question2;

/**
 *  Checked exception thrown when a task is not found
 */
public class TaskNotFoundException extends Exception {
    public TaskNotFoundException(String message) {
        super(message);
    }
}
