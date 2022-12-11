package ru.home.dao;

import ru.home.model.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserDaoImpl implements UserDao {
    @Override
    public User getUser(Long id) {
        //на этом слое заполняется создается объект User и заполняется полями из бд
        User user = new User(7L,"Bob", new HashSet<>(), new HashSet<>());
        return user;
    }

    @Override
    public List<User> findUserByName(String name) {

        List<User> users = new ArrayList<>();
        User user = new User(7L,"Bob", new HashSet<>(), new HashSet<>());
        User user2 = new User(9L,"Tom", new HashSet<>(), new HashSet<>());

        users.add(user);
        users.add(user2);
        return users;
    }

    @Override
    public Long createUser(User user) {
        Long id = 8L;
        return id;
    }

    @Override
    public List<User> getAllUsers() {

        List<User> users = new ArrayList<>();
        User user = new User(8L,"Max", new HashSet<>(), new HashSet<>());
        User user2 = new User(5L,"Mike", new HashSet<>(), new HashSet<>());

        users.add(user);
        users.add(user2);
        return users;
    }

    @Override
    public User updateUser(User user) {
        User user2 = new User(9L,"Fil", new HashSet<>(), new HashSet<>());
        return user2;
    }

    @Override
    public void deleteUser(Long id) {
        System.out.println("Пользователь с id " + id + " удален");
    }
}
