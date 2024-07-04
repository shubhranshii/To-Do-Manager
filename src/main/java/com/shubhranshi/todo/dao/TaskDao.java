package com.shubhranshi.todo.dao;

import com.shubhranshi.todo.model.Task;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskDao extends JpaRepository<Task, Integer> {

    @Transactional
    @Modifying
    @Query("UPDATE Task t SET t.completed = true WHERE t.id = :id")
    void markComplete(int id);
}
