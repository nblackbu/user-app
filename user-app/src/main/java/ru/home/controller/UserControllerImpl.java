package ru.home.controller;

import ru.home.model.User;
import ru.home.service.UserService;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class UserControllerImpl implements UserController {

    private final UserService userService;

    public UserControllerImpl(UserService userService) {
        this.userService = Objects.requireNonNull(userService, "UserService must be provided");
    }

    @Override
    public Long createUser(String name, Set<String> citiesLive, Set<String> citiesWork) {
        return userService.createUser(name, citiesLive, citiesWork);
    }

    @Override
    public User getUser(Long id) {
        //валидация данных, т.к он первый. контроллер - распределитель и проверяет валидность. больше ничего не делаем
        return userService.getUser(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @Override
    public User updateUser(User user) {
        return userService.updateUser(user);
    }

    @Override
    public void deleteUser(Long id) {
        userService.deleteUser(id);
    }

    @Override
    public List<User> findUserByName(String name) {
        return userService.findUserByName(name);
    }
}
