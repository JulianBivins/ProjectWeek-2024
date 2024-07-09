package com.grb.abihelper.backendend.AbiHelper.main;

import com.grb.abihelper.backendend.AbiHelper.model.User;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Service
public class LoginService {

    private static Set<User> userList = new HashSet<>();

    public  LoginService() {
        User paulo = new User( "paulobonifacio2005@gmail.com", "hehehe", "Paulo.b.d");
        userList.add(paulo);
        User julien = new User("Bulien@jivins.com", "hihihi", "J.B");
        userList.add(julien);
    }

    public User authenticateUser(String email, String passwort)  {
        User user = findByUsername(email);
        if (user != null && Objects.hash(passwort) == user.getPasswort()) return user;
        else return null;
    }



    public static User findByUsername(String email) {
        for (User user : userList) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }
}

