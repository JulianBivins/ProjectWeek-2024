package com.grb.abihelper.backendend.AbiHelper.main;

import com.grb.abihelper.backendend.AbiHelper.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Service
public class LoginService {

    @Autowired
    DatabaseService service;
    private  Set<User> userList = new HashSet<>();

    //Die Login Methode ist *noch* case sensitive. Wird wenn die Datenbank als Quelle benutzt wird von alleine gelöst.
    public  LoginService() {
        User paulo = new User( "paulobonifacio2005@gmail.com", "hehehe", "Paulo.b.d");
        userList.add(paulo);
        User julian = new User("bulien@jivins.com", "hihihi", "J.B");
        userList.add(julian);
    }

    public User authenticateUser(String email, String passwort)  {
        User user = null;
        try {
            user = findByUsername(email);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (user != null && Objects.hash(passwort) == user.getPasswort()) return user;
        else return null;
    }

    public  User findByUsername(String email) throws SQLException {
        try {
            Connection con = service.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM User WHERE Email = ?");
            ps.setString(1, email);
            ResultSet set = ps.executeQuery();
            if (set.getRow() == 0) set.next();
            return new User(set);
        }
        catch (Exception ex) {
            return null;
        }
    }
}

