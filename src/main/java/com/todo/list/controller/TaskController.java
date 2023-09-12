package com.todo.list.controller;

import com.todo.list.entity.Task;
import com.todo.list.service.TaskService;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
@CrossOrigin(origins = "*")
public class TaskController {

  private final TaskService taskService;

  public TaskController(TaskService taskService) {
    this.taskService = taskService;
  }

  @PostMapping
  public Task create(@RequestBody Task task) {
    return taskService.createTask(task);
  }

  @GetMapping
  public List<Task> read() {
    return taskService.readTask();
  }

  @PutMapping(value = "/{id}")
  public Optional<Task> update(@PathVariable Long id, @RequestBody Task task) {
    return taskService.updateTask(id, task);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<String> delete(@PathVariable Long id) {
    taskService.deleteTask(id);
    return ResponseEntity.ok().body("Item deletado!");
  }
}
