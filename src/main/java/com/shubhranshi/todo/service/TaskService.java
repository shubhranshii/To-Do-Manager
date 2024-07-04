package com.shubhranshi.todo.service;

import com.shubhranshi.todo.dao.TaskDao;
import com.shubhranshi.todo.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskDao taskDao;

    public void saveTask(Task task) {
        taskDao.save(task);
    }

    public List<Task> getAllTasks() {
        try {
            return taskDao.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public Task getById(int id) {
        return taskDao.getReferenceById(id);
    }

    public void deleteViaId(int id) {
        taskDao.deleteById(id);
    }

    public void markComplete(int id) {
        taskDao.markComplete(id);
    }
}
