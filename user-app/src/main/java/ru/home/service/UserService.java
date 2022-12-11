package ru.home.service;

import ru.home.model.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    User getUser(Long id);
    List<User> findUserByName(String name);
    Long createUser(String name, Set<String> citiesLive, Set<String> citiesWork);

    List<User> getAllUsers();
    User updateUser(User user);
    void deleteUser(Long id);
}
