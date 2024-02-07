package com.blueyonder.utils;

public interface UserQueryMapper {
    String addUser = "INSERT INTO users (username, password, permission) VALUES (?, ?, ?)";
    String deleteUser =  "DELETE FROM users WHERE username = ?";
    
    String getUser = "SELECT password FROM users WHERE username = ?";
    String changePassword = "UPDATE users SET password = ? WHERE username = ?";
    String getPermission = "SELECT permission FROM users WHERE username = ?";
    String changePermission = "UPDATE users SET permission = ? WHERE username = ?";
    String getAllUsers = "SELECT username FROM users ORDER BY permissions";
}
