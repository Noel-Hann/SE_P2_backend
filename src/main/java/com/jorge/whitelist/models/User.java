package com.jorge.whitelist.models;

import jakarta.persistence.*;

@Entity
@Table(name = "User")
public class User {

    public int getId() {
        return id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //private int id;
    private String username;
    private String password;

    public User( String username, String password) {

        this.username = username;
        this.password = password;
    }


    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }



    public User() {
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}