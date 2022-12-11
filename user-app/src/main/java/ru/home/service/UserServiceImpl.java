package ru.home.service;

import ru.home.dao.UserDao;
import ru.home.model.User;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = Objects.requireNonNull(userDao);
    }

    @Override
    public User getUser(Long id) {
        //какая-то логика работы, которая от нас требуется (б-логика)
        return userDao.getUser(id);
    }

    @Override
    public List<User> findUserByName(String name) {
        return userDao.findUserByName(name);
    }

    @Override
    public Long createUser(String name, Set<String> citiesLive, Set<String> citiesWork) {
        User user = new User(name, citiesLive, citiesWork);
        return userDao.createUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }
}
