package com.shubhranshi.todo.dao;

import com.shubhranshi.todo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    User findByUsername(String username);
}
