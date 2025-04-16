package com.petpals.main;

import com.petpals.util.DBConnUtil;
import java.sql.Connection;

public class DBTest {
    public static void main(String[] args) {
        Connection con = DBConnUtil.getConnection();
        if (con != null) {
            System.out.println("✅ JDBC CONNECTED SUCCESSFULLY!");
        } else {
            System.out.println("❌ JDBC CONNECTION FAILED.");
        }
    }
}
