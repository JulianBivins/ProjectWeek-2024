package com.grb.abihelper.backendend.AbiHelper.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.ResultSet;
import java.util.*;

public class User {


//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable = false, unique = true)
//    private String username;
//
//    @Column(nullable = false)
//    private String passwordHash;
//
//    @Column(nullable = false, unique = true)
//    private String email;
//
//    @ElementCollection(fetch = FetchType.EAGER)
//    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
//    @Column(name = "role")
//    private Set<String> roles = new HashSet<>();

    private String email;
    @JsonIgnore
    private int passwortHash;
    private String username; //Displayname, der von der ui verwendet wird. Für backend basically useless
    //private Set<String> roles = new HashSet<>();
    //Roles wird defacto nicht gebraucht.
    //Notfalls machen wir ne isAdmin funktion
    public User() {
    }
    public User (ResultSet set) {
       // this.passwortHash = hashPasswort(set.getString(""));
    }
    public User(  String email, String passwort, String username) {
        this.passwortHash = hashPasswort(passwort);
        this.email = email;
        this.username = username;
    }


    public void setPasswortHash(int passwortHash) {
        this.passwortHash = passwortHash;
    }

    public int getPasswort() {
        return passwortHash;
    }

    public String getEmail() {
        return email;
    }

    public int hashPasswort(String passwort) {
        return Objects.hash(passwort);
    }

    //chatgpt
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return  email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

}
