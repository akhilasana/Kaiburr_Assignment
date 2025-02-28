package com.example.myproject.controller;

import com.example.myproject.models.Task;
import com.example.myproject.models.TaskExecution;
import com.example.myproject.service.TaskService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080/tasks", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // ✅ GET all tasks or a single task by ID
    @GetMapping
    public ResponseEntity<?> getTasks(@RequestParam(required = false) String id) {
        if (id == null) {
            List<Task> tasks = taskService.getAllTasks();
            return ResponseEntity.ok(tasks);
        }

        Optional<Task> task = taskService.getTaskById(id);
        return task.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    // ✅ PUT a task (Create/Update with validation)
    @PutMapping
    public ResponseEntity<String> putTask(@RequestBody Task task) {
        try {
            if (task.getCommand() == null || task.getCommand().trim().isEmpty()) {
                return ResponseEntity.badRequest().body("Command cannot be null or empty.");
            }

            if (!taskService.isCommandSafe(task.getCommand())) {
                return ResponseEntity.badRequest().body("Unsafe command detected. Task not allowed.");
            }

            taskService.createOrUpdateTask(task);
            return ResponseEntity.ok("Task added/updated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Internal Server Error: " + e.getMessage());
        }
    }

    // ✅ DELETE a task by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable String id) {
        boolean deleted = taskService.deleteTask(id);
        return deleted ? ResponseEntity.ok("Task deleted.")
                       : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found.");
    }

    // ✅ GET tasks by name (substring search)
    @GetMapping("/search")
    public ResponseEntity<?> searchTasksByName(@RequestParam String name) {
        List<Task> foundTasks = taskService.searchTasksByName(name);
        return foundTasks.isEmpty() ? ResponseEntity.status(HttpStatus.NOT_FOUND)
                                             .body(Map.of("error", "No tasks found"))
                                   : ResponseEntity.ok(foundTasks);
    }

    // ✅ PUT a TaskExecution (Execute task & store execution details)
    @PutMapping("/{id}/execute")
    public ResponseEntity<?> executeTask(@PathVariable String id) {
        Optional<TaskExecution> execution = taskService.executeTask(id);
        return execution.map(ResponseEntity::ok) .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }
}
