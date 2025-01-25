package asl.ProjectToDoList.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import asl.ProjectToDoList.model.Task;
import asl.ProjectToDoList.repository.TaskRepository;
import asl.ProjectToDoList.exception.TaskNotFoundException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class TaskService {
    
    private static final Logger logger = LoggerFactory.getLogger(TaskService.class);
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        logger.info("Fetching all tasks");
        return taskRepository.findAll();
    }

    public Task createTask(String title) {
        logger.info("Creating new task with title: {}", title);
        Task task = new Task(title);
        return taskRepository.save(task);
    }

    public Task updateTaskStatus(Long id, String status) {
        logger.info("Updating status of task {} to {}", id, status);
        Task task = taskRepository.findById(id)
            .orElseThrow(() -> {
                logger.error("Task not found with id: {}", id);
                return new TaskNotFoundException(id);
            });
        task.setStatus(status);
        return taskRepository.save(task);
    }
} 