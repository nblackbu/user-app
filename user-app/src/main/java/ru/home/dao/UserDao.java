package ru.home.dao;

import ru.home.model.User;

import java.util.List;
import java.util.Set;

public interface UserDao {
    User getUser(Long id);
    List<User> findUserByName(String name);
    Long createUser(User user);
    List<User> getAllUsers();
    User updateUser(User user);
    void deleteUser(Long id);
}
