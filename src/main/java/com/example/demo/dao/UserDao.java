package com.example.demo.dao;

import com.example.demo.model.User;

import java.util.List;

public interface UserDao {

    public void addUser(User user);
    public List<User> listUsers();
    public void updateUser(User user);
    public void deleteUser(Long id);
    public User getUserById(Long id);
    public User getUserByLogin(String login);
}
