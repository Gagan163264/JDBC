package com.blueyonder.dao;

import com.blueyonder.utils.DBConn;
import com.blueyonder.utils.UserQueryMapper;

import java.security.InvalidKeyException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AuthDAOImpl implements AuthDAO, UserQueryMapper {
    Connection conn = DBConn.createConn();
    public int addUser(String username, String password, Integer permission) {
        int res = 0;
        try{
            PreparedStatement stm = conn.prepareStatement(UserQueryMapper.addUser);
            stm.setString(1, username);
            stm.setInt(2, password.hashCode());
            stm.setInt(3, permission);
            res = stm.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }  
        return res;  
    }

    public int deleteUser(String username) {
        int res = 0;
        try{
            PreparedStatement stm = conn.prepareStatement(UserQueryMapper.deleteUser);
            stm.setString(1, username);
            res = stm.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    public void changePassword(String username, String password, String newPassword) {
        int res = 0;
        try{
            PreparedStatement stm = conn.prepareStatement(UserQueryMapper.getUser);
            stm.setString(1, username);
            ResultSet rs = stm.executeQuery();
            rs.next();
            if(rs.getInt(1)==password.hashCode()){
                PreparedStatement stm2 = conn.prepareStatement(UserQueryMapper.changePassword);
                stm2.setInt(1, newPassword.hashCode());
                stm2.setString(2, username);
                stm2.executeUpdate();
            }
            else{
                throw new RuntimeException();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int changePermission(String username, Integer permission) {
        int res = 0;
        try{
            PreparedStatement stm = conn.prepareStatement(UserQueryMapper.changePermission);
            stm.setInt(1, permission);
            stm.setString(2, username);
            res = stm.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    public int getPermission(String username) {
        int permission = -1;
        try{
            PreparedStatement stm = conn.prepareStatement(UserQueryMapper.getPermission);
            stm.setString(1, username);
            ResultSet rs = stm.executeQuery();
            while (rs.next())
                return rs.getInt(1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return permission;
    }

    public java.util.List<String> getAllUsers() {
        java.util.List<String> users = new java.util.ArrayList<>();
        try{
            PreparedStatement stm = conn.prepareStatement(UserQueryMapper.getAllUsers);
            ResultSet rs = stm.executeQuery();
            while (rs.next())
                users.add(rs.getString(1));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return users;
    }
    
}
