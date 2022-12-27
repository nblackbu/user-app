package ru.home.dao;

import ru.home.exception.ApplicationException;
import ru.home.model.User;
import ru.home.sql.SQLConnections;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserDaoImpl implements UserDao {

    SQLConnections worker;

    public UserDaoImpl() {
        this.worker = new SQLConnections();
    }

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

        Long id;
        String name = user.getName();
        Set<String> citiesLive = user.getCitiesLived();
        Set<String> citiesWorked = user.getCitiesWorked();

        try {
            String query = "insert into users (name) values ('" + name + "')";
            //statement  - объект отправляет в бд, генерирует соединение. передали флаг, что в prepareStatement вернется ключ (Statement.RETURN_GENERATED_KEYS)
            PreparedStatement statement = worker.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            //проверяем, была ли создана строка. executeUpdate - возвращает кол-во строк, которое было добавлено в бд
            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0)
                throw new ApplicationException("Пользователь не был создан");

            //поток ResultSet, getGeneratedKeys возвращает экземпляр ResultSet. getLong получаем id
            try (ResultSet generatedKey = statement.getGeneratedKeys()) {
                if (generatedKey.next()) {
                    id = generatedKey.getLong(1);
                } else {
                    throw new ApplicationException("Id не был получен, User не был создан");
                }
            }
            statement.close();

            //id нужен чтобы добавлять города
        } catch (SQLException e) {
            throw new ApplicationException("Не удалось создать User");
        }
        return id;
    }

    //putCityIdUserIdInTable - кладет cityid и userid в таблицу, и мы ему передаем в аргументы имя таблицы, откуда
    public void putCityIdUserIdInTable(Long userId, Long citiesId, String tableName) {
        try {
            String query = "insert into " + tableName + " (user_id, city_id) value (" + userId + ", " + citiesId + ")" ;
            PreparedStatement statement = worker.getConnection().prepareStatement(query);
            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0)
                throw new ApplicationException("putCityIdUserIdInTable error");
            statement.close();
        } catch (SQLException e) {
            throw new ApplicationException("Не удалось поместить citiesId, userId в таблицу " + tableName);
        }
    }

    public Long createCity(String citiesName) {

    }

    public Long getCityId (String nameCity) {
        try {
            Long id = 0L;
            String query = "select id from cities where name = '" + nameCity + "'";
            PreparedStatement statement = worker.getConnection().prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getLong("id");
            }
            statement.close();
            return id;
        } catch (SQLException e) {
            throw new ApplicationException("Не удалось получить id города");
        }
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
