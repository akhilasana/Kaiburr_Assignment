package com.example.myproject.service;

import com.example.myproject.models.Task;
import com.example.myproject.models.TaskExecution;
import com.example.myproject.repository.TaskRepository;

import org.springframework.stereotype.Service;
import java.util.*;
import java.util.regex.Pattern;

@Service
public class TaskService {
    private final TaskRepository taskRepository;  // ✅ Use MongoDB Repository

    // Constructor-based injection
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // Fixed regex pattern
    private static final String UNSAFE_COMMAND_REGEX =
            ".*(rm\\s+-rf|shutdown|:\\(\\)\\{:\\||mkfs|dd\\s+if=|wget\\s+|curl\\s+-O).*";
    private static final Pattern UNSAFE_PATTERN = Pattern.compile(UNSAFE_COMMAND_REGEX, Pattern.CASE_INSENSITIVE);

    // ✅ Get all tasks from MongoDB
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // ✅ Get task by ID
    public Optional<Task> getTaskById(String id) {
        return taskRepository.findById(id);
    }

    // ✅ Create or update a task
    public Task createOrUpdateTask(Task task) {
        return taskRepository.save(task); // ✅ Saves task in MongoDB
    }

    // ✅ Delete a task
    public boolean deleteTask(String id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // ✅ Search tasks by name (partial match)
    public List<Task> searchTasksByName(String name) {
        return taskRepository.findByNameContainingIgnoreCase(name);
    }

    // ✅ Validate if a command is safe
    public boolean isCommandSafe(String command) {
        return !UNSAFE_PATTERN.matcher(command).matches();
    }

    // ✅ Execute a task command and store execution details
    public Optional<TaskExecution> executeTask(String id) {
        Optional<Task> taskOptional = taskRepository.findById(id);
        if (taskOptional.isPresent()) {
            Task task = taskOptional.get();

            // Ensure taskExecutions list is initialized
            if (task.getTaskExecutions() == null) {
                task.setTaskExecutions(new ArrayList<>());
            }

            TaskExecution execution = new TaskExecution(UUID.randomUUID().toString(), "Success", new Date());
            task.getTaskExecutions().add(execution);

            taskRepository.save(task); // ✅ Save the updated task with execution details
            return Optional.of(execution);
        }
        return Optional.empty();
    }
}
