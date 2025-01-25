package asl.ProjectToDoList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import asl.ProjectToDoList.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    // JpaRepository provides basic CRUD operations:
    // findAll(), findById(), save(), deleteById(), etc.
} 