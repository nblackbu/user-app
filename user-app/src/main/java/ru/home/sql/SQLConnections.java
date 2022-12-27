package ru.home.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//для создания подключения к нашей бд

public class SQLConnections {
    private final Connection connection;

    public SQLConnections () {
        try {
            String url = PropertyProvider.getAppProperties().getProperty("datasource.url");
            String userName = PropertyProvider.getAppProperties().getProperty("datasource.username");
            String password = PropertyProvider.getAppProperties().getProperty("datasource.password");

            connection = DriverManager.getConnection(url,userName, password);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
