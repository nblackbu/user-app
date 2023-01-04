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

            Statement statement1 = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            //PreparedStatement preparedStatement = connection.prepareStatement("", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = statement1.executeQuery("select * from Books");
            if(resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }
            if (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }
            //previous - бегать в обе стороны
            if (resultSet.previous()) {
                System.out.println(resultSet.getString("name"));
            }
            // relative - на сколько колонок сдвинуться вперед или назад (-2 в rows)
            if (resultSet.relative(2)) {
                System.out.println(resultSet.getString("name"));
            }
            if (resultSet.absolute(2)) {
            }
            if (resultSet.first()) {

            }
            if (resultSet.last()) {

            }
            //absolute -
        }
    }
}