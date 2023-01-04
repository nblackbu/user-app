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

            CallableStatement callableStatement = connection.prepareCall("{call BooksCount(?)}");
            //регистрируем параметры registerOutParameter
            callableStatement.registerOutParameter(1, Types.INTEGER);
            callableStatement.execute();
            System.out.println(callableStatement.getInt(1));

            // пример, когда мы передаем в процедуры значения
            CallableStatement callableStatement1 = connection.prepareCall("{call getBooks(?)}");
            //Метод setInt - Задает для указанного параметра указанное значение int.
            callableStatement1.setInt(1, 1);
            if (callableStatement1.execute()) {
                ResultSet resultSet = callableStatement1.getResultSet();
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt("id"));
                    System.out.println(resultSet.getString("name"));
                }
            }
        }
    }
}