package com.example.todo.domain;

import java.time.LocalDateTime;

public record TaskCreatedDto(String title, String description, Priority priority, LocalDateTime createdAt) {
}
