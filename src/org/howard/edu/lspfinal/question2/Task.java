package org.howard.edu.lspfinal.question2;

/**
 * Represents a task with a unique name, priority, and status
 */
public class Task {
    private String name;
    private int priority;
    private String status;

    /**
     * Constructor for task
     * 
     * @param name     the unique name of the task
     * @param priority the task's priority (lower number = higher priority)
     * @param status   the status of the task
     */
    public Task(String name, int priority, String status) {
        this.name = name;
        this.priority = priority;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{name='" + name + "', priority=" + priority + ", status='" + status + "'}";
    }
}
