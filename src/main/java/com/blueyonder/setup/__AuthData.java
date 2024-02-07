package com.blueyonder.setup;

import com.blueyonder.utils.DBConn;
import com.blueyonder.utils.UserQueryMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class __AuthData implements UserQueryMapper {
    private final Connection conn = DBConn.createConn();

    private void CreateTable(){
        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate("CREATE TABLE users (username VARCHAR(255) PRIMARY KEY, password INT, permission INT)");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void InsertUser(String username, String password, Integer permission)
    {
        try{
            PreparedStatement stm = conn.prepareStatement(UserQueryMapper.addUser);
            stm.setString(1, username);
            stm.setInt(2, password.hashCode());
            stm.setInt(3, permission);
            stm.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private int deleteUser(String username)
    {
        int res;
        try{
            PreparedStatement stm = conn.prepareStatement(UserQueryMapper.deleteUser);
            stm.setString(1, username);
            res = stm.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    private int clearTable()
    {
        int res;
        try{
            Statement stm = conn.createStatement();
            res = stm.executeUpdate("DELETE FROM users");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    public void init_auth() {
        __AuthData authData = new __AuthData();
        authData.CreateTable();
        //authData.clearTable();
        authData.InsertUser("admin", "admin", 0);
        authData.InsertUser("user", "user", 1);
        authData.InsertUser("viewer", "viewer", 2);
    }
    
}
