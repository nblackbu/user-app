package ru.home.ui;

import ru.home.controller.UserController;
import ru.home.controller.UserControllerImpl;
import ru.home.dao.UserDaoImpl;
import ru.home.model.User;
import ru.home.service.UserServiceImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WebUserInterface {
    UserController userController = new UserControllerImpl(new UserServiceImpl(new UserDaoImpl()));

    public User getUser(Long id) {
        User user = userController.getUser(7l);
        return user;
    }

    public List<User> findUserByName(String name) {
        List<User> users = userController.findUserByName("Bob");
        return users;
    }

    public Long createUser(String name, Set<String> citiesLive, Set<String> citiesWork) {
        User user = new User(5L,"Masha", new HashSet<>(), new HashSet<>());
        Long id = userController.createUser(name, citiesLive, citiesWork);
        return id;
    }

    public List<User> getAllUsers() {
        List<User> users = userController.getAllUsers();
        return users;
    }

    public User updateUser(User user) {
        User user2 = new User(5L,"Elena", new HashSet<>(), new HashSet<>());
        return userController.updateUser(user2);
    }

    public void deleteUser(Long id) {
        userController.deleteUser(8L);
    }
}