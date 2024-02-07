package com.blueyonder.dao;

import java.util.List;

public interface AuthDAO {
    public int addUser(String username, String password, Integer permission);
    public int deleteUser(String username);
    public void changePassword(String username, String password, String newPassword);
    public int changePermission(String username, Integer permission);
    public int getPermission(String username);
    List<String> getAllUsers();
}
