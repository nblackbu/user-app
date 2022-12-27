package ru.home.sql;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
// считываем данные с файла проперти

public class PropertyProvider {
    private static final Properties appProperties = new Properties();

    static {
        try {
            appProperties.load(new FileInputStream("src/main/resources/application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //defence copy - почитать (возвр защищенную копию)
    public static Properties getAppProperties() {
        return new Properties(appProperties);
     }
}
