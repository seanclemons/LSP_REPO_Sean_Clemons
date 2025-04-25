package org.howard.edu.lspfinal.question2;

import java.util.*;

/**
 * Manages a collection of tasks using a HashMap for efficient access
 */
public class TaskManager {
    private Map<String, Task> tasks = new HashMap<>();

    /**
     * Adds new task to the system
     * 
     * @param name     the unique name of the task
     * @param priority the priority of the task
     * @param status   the initial status of the task
     * @throws DuplicateTaskException if a task with the same name already exists
     */
    public void addTask(String name, int priority, String status) throws DuplicateTaskException {
        if (tasks.containsKey(name)) {
            throw new DuplicateTaskException("Task '" + name + "' already exists.");
        }
        tasks.put(name, new Task(name, priority, status));
    }

    /**
     * Retrieves task by its name
     * 
     * @param name the name of the task
     * @return the Task object
     * @throws TaskNotFoundException if the task is not found
     */
    public Task getTaskByName(String name) throws TaskNotFoundException {
        Task task = tasks.get(name);  // Fast lookup using HashMap
        if (task == null) {
            throw new TaskNotFoundException("Task '" + name + "' not found.");
        }
        return task;
    }

    /**
     * Updates the status of existing task
     * 
     * @param name   the name of the task
     * @param status the new status
     * @throws TaskNotFoundException if the task is not found
     */
    public void updateStatus(String name, String status) throws TaskNotFoundException {
        Task task = getTaskByName(name);  // Lookup and validate using map
        task.setStatus(status);  // Update in-place
    }

    /**
     * Prints all tasks grouped by their status
     */
    public void printTasksGroupedByStatus() {
        System.out.println("Tasks grouped by status:");

        Map<String, List<Task>> grouped = new HashMap<>();

        for (Task task : tasks.values()) {
            grouped.putIfAbsent(task.getStatus(), new ArrayList<>());
            grouped.get(task.getStatus()).add(task);
        }

        for (String status : Arrays.asList("TODO", "IN_PROGRESS", "DONE")) {
            System.out.println(status + ":");
            List<Task> taskList = grouped.getOrDefault(status, new ArrayList<>());
            for (Task t : taskList) {
                System.out.println("  " + t);
            }
        }
    }
}

/**
 * Sources:
 * https://docs.oracle.com/javase/tutorial/essential/exceptions/
 * https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html
 */