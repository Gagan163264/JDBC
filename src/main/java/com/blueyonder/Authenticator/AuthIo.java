package com.blueyonder.Authenticator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.blueyonder.utils.DBConn;
import com.blueyonder.utils.UserQueryMapper;

public class AuthIo implements Authenticator, UserQueryMapper {
    private Connection conn = DBConn.createConn();
    public AuthIo() {
    }
    public boolean authenticate(String username, String password)
    {
        Integer passwordHash = getPasswordHash(username);
        return passwordHash != null && passwordHash.equals(password.hashCode());
    }

    private Integer getPasswordHash(String username) {
        try{
            PreparedStatement stm = conn.prepareStatement(UserQueryMapper.getUser);
            stm.setString(1, username);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
