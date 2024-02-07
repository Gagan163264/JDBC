package com.blueyonder.setup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class __TableOperations {
    String URL = "jdbc:postgresql://localhost:5432/bydb";
    Connection conn = null;
    {
        try{
            conn = DriverManager.getConnection(URL, "postgres","postgres");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createDatabase(){
        try{
            String URL = "jdbc:postgresql://localhost:5432/";
            conn = DriverManager.getConnection(URL, "postgres","postgres");
            conn.createStatement().executeUpdate("CREATE DATABASE bydb");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createTable(){
        try{
            conn.createStatement().executeUpdate("CREATE TABLE customer(customerID INTEGER PRIMARY KEY, customerName VARCHAR(50), dateOfBirth DATE, address VARCHAR(100))");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void dropTable(){
        try{
            conn.createStatement().executeUpdate("DROP TABLE customer");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertData(){
        try{
            conn.createStatement().executeUpdate("INSERT INTO customer(customerID, customerName, dateOfBirth, address) VALUES (1, 'John', '1990-01-01', '123 Main St')");
            conn.createStatement().executeUpdate("INSERT INTO customer(customerID, customerName, dateOfBirth, address) VALUES (2, 'Jane', '1991-01-01', '124 Main St')");
            conn.createStatement().executeUpdate("INSERT INTO customer(customerID, customerName, dateOfBirth, address) VALUES (3, 'Jack', '1992-01-01', '125 Main St')");
            conn.createStatement().executeUpdate("INSERT INTO customer(customerID, customerName, dateOfBirth, address) VALUES (4, 'Jill', '1993-01-01', '126 Main St')");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void init_data() {
        __TableOperations to = new __TableOperations();
        to.createDatabase();
        to.createTable();
        to.insertData();
    }


}
