package asl.ProjectToDoList.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import asl.ProjectToDoList.model.Task;
import asl.ProjectToDoList.service.TaskService;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    
    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAllTasks() {
        logger.debug("REST request to get all tasks");
        return taskService.getAllTasks();
    }

    @PostMapping
    public Task createTask(@RequestBody String title) {
        logger.debug("REST request to create Task with title: {}", title);
        return taskService.createTask(title);
    }

    @PutMapping("/{id}/status")
    public Task updateTaskStatus(
        @PathVariable Long id,
        @RequestBody String status
    ) {
        logger.debug("REST request to update Task {} status to: {}", id, status);
        return taskService.updateTaskStatus(id, status);
    }
} 