package com.blueyonder.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
    public static Connection conn = null;

    public static Connection createConn(){
        if(conn != null){
            return conn;
        }
        String URL = "jdbc:postgresql://localhost:5432/bydb";
        Connection conn = null;
        {
            try{
                conn = DriverManager.getConnection(URL, "postgres","postgres");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return conn;
    }
}
