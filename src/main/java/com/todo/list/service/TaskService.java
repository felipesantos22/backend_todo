package com.todo.list.service;

import com.todo.list.entity.Task;
import com.todo.list.repository.TaskRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

  private final TaskRepository repository;

  public TaskService(TaskRepository repository) {
    this.repository = repository;
  }

  public Task createTask(Task task) {
    return repository.save(task);
  }

  public List<Task> readTask() {
    return repository.findAll();
  }

  public Optional<Task> updateTask(Long id, Task task) {
    return repository.findById(id).map(record -> {
      record.setName(task.getName());
      record.setStatus(task.getStatus());
      return repository.save(record);
    });
  }

  public Optional<Task> deleteTask(Long id) {
    return repository.findById(id).map(record -> {
      repository.deleteById(id);
      return record;
    });
  }

}
