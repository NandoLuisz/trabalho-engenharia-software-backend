package com.example.todo.controller;

import com.example.todo.domain.Task;
import com.example.todo.domain.TaskCreateDto;
import com.example.todo.domain.TaskCreatedDto;
import com.example.todo.domain.TaskUpdateDto;
import com.example.todo.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/task")
@RestController
public class TodoController {
    private final TaskService taskService;

    public TodoController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping()
    public ResponseEntity<TaskCreatedDto> createTask(@RequestBody TaskCreateDto taskCreateDto){
        var task = taskService.createTask(taskCreateDto);
        return ResponseEntity.ok(new TaskCreatedDto(task.getTitle(), task.getDescription(), task.getPriority(), task.getCreatedAt()));
    }

    @GetMapping()
    public ResponseEntity<List<TaskCreatedDto>> createTask(){
        return null;
    }

    @PutMapping()
    public ResponseEntity<List<TaskCreatedDto>> updateTask(@RequestBody TaskUpdateDto todoUpdateDto){
        return null;
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteTask(@PathVariable Long id){
        return null;
    }

}
