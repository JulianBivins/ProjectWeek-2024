package com.grb.abihelper.backendend.AbiHelper.model;

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
    private int passwortHash;
    private Set<String> roles = new HashSet<>();
    private static Set<User> userList = new HashSet<>();

    public User() {
    }

    public User(  String email, String passwort, Set<String> roles) {
        this.passwortHash = hashPasswort(passwort);
        this.email = email;
        this.roles = roles;
        if (!isExisting(this)){
            userList.add(this);
        }
    }


    public void setPasswortHash(int passwortHash) {
        this.passwortHash = passwortHash;
    }

    public static Set<User> getUserList() {
        return userList;
    }

    public int getPasswort() {
        return passwortHash;
    }

    public String getEmail() {
        return email;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public int hashPasswort(String passwort) {
        return Objects.hash(passwort);
    }

    public boolean isExisting(User user){
        return userList.contains(user);
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

    public static User findByUsername(String email) {
        for (User user : userList) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }
}
