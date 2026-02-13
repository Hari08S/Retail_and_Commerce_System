package com.wipro.retail.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBUtil {
    public static Connection getDBConnection() {
        Connection con = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe",
                    "RETAIL COMMERCE SYSTEM",
                    "hari2005");   
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
