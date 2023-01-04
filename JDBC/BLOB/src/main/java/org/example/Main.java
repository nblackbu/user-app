package org.example;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        String url = "./";
        String username = "root";
        String password = "123";
        //class приводит к загрузке класса и инициализации его стат.части. С свою очередь многие JDBC драйвера при стат.
        //иниц. регистририруют себя в DriverManager. Длео в side эффектах
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(url, username,  password);
        Statement statement = connection.createStatement()) {
            statement.execute("drop table Users");
            statement.executeUpdate("CREATE TABLE IF NOT EXIST Books (id MEDIUMINT NOT NULL AUTO_INCREMENT, name CHAR(30) NOT NULL, img BLOB PRIMARY KEY (id))");
            BufferedImage img = ImageIO.read(new File("smile.jpg"));
            Blob blob = connection.createBlob();
            try (OutputStream outputStream = blob.setBinaryStream(1)) {
                // имэдж записали в блоб таким образом
                ImageIO.write(img, "jpg", outputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            PreparedStatement preparedStatement = connection.prepareStatement("insert into Books (name, img) values (?, ?)");
            preparedStatement.setString(1, "inferno");
            preparedStatement.setBlob(2, blob);
            preparedStatement.execute();

            //читаем картинку с бд

            ResultSet resultSet = statement.executeQuery("select * from Books");
            while (resultSet.next()) {
                Blob blob2 = resultSet.getBlob("img");
                // берем поток nputstream и читаем его в img
                BufferedImage image2 = ImageIO.read(blob2.getBinaryStream());
                File outputFile = new File("saved.png");
                //берем поток outputfile и записываем его в файл image2
                ImageIO.write(image2,"png", outputFile);
            }
        }
    }
}