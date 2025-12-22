package com.example.todo.service;

import com.example.todo.domain.Priority;
import com.example.todo.domain.Task;
import com.example.todo.domain.TaskCreateDto;
import com.example.todo.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(TaskCreateDto taskCreateDto){
        var newTask = new Task();
        newTask.setTitle(taskCreateDto.title());
        newTask.setDescription(taskCreateDto.description());
        newTask.setPriority(Priority.valueOf(taskCreateDto.priority()));
        taskRepository.save(newTask);
        return newTask;
    }
}
