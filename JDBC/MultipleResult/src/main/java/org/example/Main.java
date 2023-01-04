package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String url = "./";
        String username = "root";
        String password = "123";
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {
            statement.execute("drop table Users");
            statement.executeUpdate("CREATE TABLE IF NOT EXIST Books (id MEDIUMINT NOT NULL AUTO_INCREMENT, name CHAR(30) NOT NULL, dt DATE, PRIMARY KEY (id))");

            CallableStatement callableStatement = connection.prepareCall("{call getCount()}");
            boolean hasResult = callableStatement.execute();
            while (hasResult) {
                ResultSet resultSet = callableStatement.getResultSet();
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("name"));
                }
                hasResult = callableStatement.getMoreResults();
            }

        }
    }
}
