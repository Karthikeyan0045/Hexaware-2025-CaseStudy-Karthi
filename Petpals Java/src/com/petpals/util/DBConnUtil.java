package com.petpals.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnUtil {
    public static Connection getConnection() {
        Connection con = null;
        try {
            Properties props = DBPropertyUtil.loadProperties("db.properties");

            String url = props.getProperty("url");
            String user = props.getProperty("username");
            String pass = props.getProperty("password");

            con = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return con;
    }
}
