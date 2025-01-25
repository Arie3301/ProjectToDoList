package asl.ProjectToDoList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import asl.ProjectToDoList.model.Task;
import asl.ProjectToDoList.service.TaskService;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping
    public Task createTask(@RequestBody String title) {
        return taskService.createTask(title);
    }

    @PutMapping("/{id}/status")
    public Task updateTaskStatus(
        @PathVariable Long id,
        @RequestBody String status
    ) {
        return taskService.updateTaskStatus(id, status);
    }
} 