package com.grb.abihelper.backendend.AbiHelper.main;

import com.grb.abihelper.backendend.AbiHelper.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;

@RestController
public class LoginController {

    PasswordEncoder passwordEncoder;

    public LoginController() {
        passwordEncoder = new BCryptPasswordEncoder();
    }

    @Autowired
    LoginService loginService;

    @GetMapping("/loginToken") //html macht das frontend
    public ResponseEntity<String> successfulLogin(@RequestParam String email, @RequestParam String password) {
        User user = loginService.authenticateUser(email, password);
        if (user != null) return ResponseEntity.ok("Login successful for user: " + user.getEmail());
        else return ResponseEntity.status(401).body("Invalid email or password");
    }


    public void registerUser(User user) {
        String hashedPasswort = passwordEncoder.encode(String.valueOf(user.getPasswort()));
        user.setPasswortHash(Integer.parseInt(hashedPasswort));
        UserRepository.save(user);
    }
}
