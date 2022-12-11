package ru.home.controller;

import ru.home.model.User;

import java.util.List;
import java.util.Set;

public interface UserController {
    Long createUser(String name, Set<String> citiesLive, Set<String> citiesWork);
    User getUser(Long id);
    List<User> getAllUsers();
    User updateUser(User user);
    void deleteUser(Long id);
    List<User> findUserByName(String name);
}
