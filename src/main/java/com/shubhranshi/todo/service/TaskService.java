package com.shubhranshi.todo.service;

import com.shubhranshi.todo.dao.TaskDao;
import com.shubhranshi.todo.dao.UserDao;
import com.shubhranshi.todo.model.Task;
import com.shubhranshi.todo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskDao taskDao;

    @Autowired
    private UserDao userDao;

    public void saveTask(Task task) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username=userDetails.getUsername();
        User current= userDao.findByUsername(username);
        task.setUser(current);
        taskDao.save(task);
    }

    public List<Task> getAllTasksForCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username=userDetails.getUsername();
        User current= userDao.findByUsername(username);
        return taskDao.findAllByUserId(current.getUserId());
    }

    public List<Task> getAllTasksWithSortingForCurrentUser(String field) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username=userDetails.getUsername();
        User current= userDao.findByUsername(username);
        return taskDao.findAllByUserId(current.getUserId(), Sort.by(Sort.Direction.ASC,field));
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
