package com.courier.util;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DBPropertyUtil {
    public static String getConnectionString(String propertyFileName) throws IOException {
        Properties props = new Properties();
        FileInputStream fis = new FileInputStream(propertyFileName);
        props.load(fis);
        return props.getProperty("db.url");
    }
}
