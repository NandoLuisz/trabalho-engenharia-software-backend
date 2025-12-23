package com.example.todo.controller;

import com.example.todo.domain.TaskCreateDto;
import com.example.todo.domain.TaskCreatedDto;
import com.example.todo.domain.TaskUpdateDto;
import com.example.todo.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
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
        return ResponseEntity.ok(new TaskCreatedDto(task.getId(), task.getTitle(), task.getDescription(), task.getPriority().toString(), task.isCompleted(), task.getCreatedAt()));
    }

    @GetMapping()
    public ResponseEntity<List<TaskCreatedDto>> getTasks(){
        var tasks = taskService.findAll()
                .stream()
                .map(task -> new TaskCreatedDto(task.getId(), task.getTitle(), task.getDescription(), task.getPriority().toString(), task.isCompleted(), task.getCreatedAt())).toList();

        return ResponseEntity.ok(tasks);
    }

    @PutMapping()
    public ResponseEntity<List<TaskCreatedDto>> updateTask(@RequestBody TaskUpdateDto todoUpdateDto){
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return ResponseEntity.ok("Tarefa deletada com sucesso.");
    }

}
