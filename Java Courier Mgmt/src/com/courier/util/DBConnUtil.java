package com.courier.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.FileInputStream;

public class DBConnUtil {
	
    public static Connection getConnection(String propertyFileName) {
        Connection conn = null;
        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream(propertyFileName));

            String url = prop.getProperty("db.url");
            String user = prop.getProperty("db.username");
            String password = prop.getProperty("db.password");

            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
