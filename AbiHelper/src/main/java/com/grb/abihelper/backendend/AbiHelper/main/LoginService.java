package com.grb.abihelper.backendend.AbiHelper.main;

import com.grb.abihelper.backendend.AbiHelper.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import javax.naming.AuthenticationException;
import java.util.HashSet;
import java.util.Objects;

@Service
public class LoginService {


    public User authenticateUser(String email, String passwort)  {
        User user = findByUsername(email);
        if (user != null && Objects.hash(passwort) == user.getPasswort()) return user;
        else return null;
    }



    public static User findByUsername(String email) {
        for (User user : User.getUserList()) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }
}

