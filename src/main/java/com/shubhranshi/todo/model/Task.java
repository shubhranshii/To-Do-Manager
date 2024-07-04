package com.shubhranshi.todo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name="Task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String title;
    String description;
    String priority;
    LocalDateTime dueDate;
    boolean completed;
    @Column(updatable = false)
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now().withNano(0);
        this.updatedAt = LocalDateTime.now().withNano(0);
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now().withNano(0);
    }
}
